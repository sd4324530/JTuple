package com.github.sd4324530.jtuple;

import java.io.Serializable;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static java.util.Objects.isNull;
import static java.util.Objects.requireNonNull;

/**
 * 元组类型
 * 用于表示多个不同类型的数据集合
 * 可迭代
 * 不可变，线程安全
 *
 * @author peiyu
 * @see Tuple2
 */
public abstract class Tuple implements Iterable<Object>, Serializable {

    private final List<Object> valueList;

    Tuple(final Object... objects) {
        this.valueList = Arrays.asList(objects);
    }

    /**
     * 将元组转换成列表
     *
     * @return 转换得到的列表
     */
    public final List<Object> toList() {
        return new ArrayList<>(this.valueList);
    }

    /**
     * 将元组转换成数组
     *
     * @return 转换得到的数组
     */
    public final Object[] toArray() {
        return this.valueList.toArray();
    }

    /**
     * 得到元组的大小
     *
     * @return 元组的大小
     */
    public final int size() {
        return this.valueList.size();
    }

    /**
     * 获取元组中指定位置的元素
     *
     * @param pos 元组中的位置
     * @param <T> 元素类型
     * @return 对应元素
     */
    @SuppressWarnings("unchecked")
    public final <T> T get(final int pos) {
        return (T) this.valueList.get(pos);
    }

    /**
     * 判断元组中是否包含某元素
     *
     * @param value 需要判定的元素
     * @return 是否包含
     */
    public final boolean contains(final Object value) {
        return this.valueList.contains(value);
    }

    @Override
    public final Iterator<Object> iterator() {
        return this.valueList.iterator();
    }

    @Override
    public final Spliterator<Object> spliterator() {
        return this.valueList.spliterator();
    }

    /**
     * 将元组转成流
     *
     * @return 流
     */
    public final Stream<Object> stream() {
        return StreamSupport.stream(spliterator(), false);
    }

    /**
     * 将元组转成并行流
     *
     * @return 流
     */
    public final Stream<Object> parallelStream() {
        return StreamSupport.stream(spliterator(), true);
    }

    /**
     * 迭代元组
     *
     * @param action 迭代函数
     */
    @Override
    public final void forEach(final Consumer<? super Object> action) {
        requireNonNull(action, "action is null");
        this.valueList.forEach(action);
    }

    /**
     * 带序号迭代元组
     *
     * @param action 带序号的迭代函数
     */
    public final void forEachWithIndex(final BiConsumer<Integer, ? super Object> action) {
        requireNonNull(action, "action is null");
        for (int i = 0, length = this.valueList.size(); i < length; i++)
            action.accept(i, this.valueList.get(i));
    }

    /**
     * 截取元组指定部分
     *
     * @param start 起始位置
     * @param end   终止位置
     * @return 截取得到的元组
     */
    public final Tuple subTuple(final int start, final int end) {
        if (start < 0 || end < 0)
            throw new IllegalArgumentException("start, end must >= 0");
        if (end >= this.valueList.size())
            throw new IllegalArgumentException("this tuple's size is" + this.valueList.size());
        int length = end - start + 1;
        if (length <= 0)
            throw new IllegalArgumentException("end must >= start");

        if (start == 0 && end == this.valueList.size() - 1)
            return this;

        switch (length) {
            case 1:
                return Tuple1.with(this.valueList.get(start));
            case 2:
                return Tuple2.with(this.valueList.get(start), this.valueList.get(end));
            case 3:
                return Tuple3.with(this.valueList.get(start), this.valueList.get(start + 1), this.valueList.get(end));
            case 4:
                return Tuple4.with(this.valueList.get(start), this.valueList.get(start + 1), this.valueList.get(start + 2), this.valueList.get(end));
            case 5:
                return Tuple5.with(this.valueList.get(start), this.valueList.get(start + 1), this.valueList.get(start + 2), this.valueList.get(start + 3), this.valueList.get(end));
            default:
                return TupleN.with(this.valueList.subList(start, end));
        }
    }

    /**
     * 于其他元组合并成新元组
     *
     * @param tuples 需要合并的元组
     * @return 合并后的新元组
     */
    public final Tuple add(final Tuple... tuples) {
        requireNonNull(tuples, "tuple is null");
        if (tuples.length == 0)
            return this;
        List<Object> temp = new ArrayList<>(this.valueList);
        for (Tuple t : tuples)
            temp.addAll(t.valueList);
        return TupleN.withList(temp);
    }

    /**
     * 将元组里的元素重复指定次数
     *
     * @param times 重复次数
     * @return 得到的元组
     */
    public final Tuple repeat(final int times) {
        if (times < 0)
            throw new IllegalArgumentException("times must >= 0");
        if (times == 0)
            return this;
        return TupleN.with(IntStream.range(0, times)
                .mapToObj(i -> this.valueList.toArray())
                .reduce((a, b) -> {
                    Object[] temp = new Object[a.length + b.length];
                    System.arraycopy(a, 0, temp, 0, a.length);
                    System.arraycopy(b, 0, temp, a.length, b.length);
                    return temp;
                }).get());
    }

    /**
     * 比较2个元组是否相同
     * 元组里的所有位置上的元素都相同，即为元组相同
     *
     * @param obj 需要比较的元组
     * @return 比较结果
     */
    @Override
    public final boolean equals(final Object obj) {
        if (isNull(obj))
            return false;
        if (obj == this)
            return true;
        if (obj instanceof Tuple)
            return ((Tuple) obj).valueList.equals(this.valueList);
        return false;
    }

    @Override
    public final int hashCode() {
        return this.valueList.hashCode();
    }

    /**
     * 得到元组的字符串，比如(123, 456)
     *
     * @return 元组的字符串
     */
    @Override
    public final String toString() {
        return this.valueList.stream()
                .map(Objects::toString)
                .collect(Collectors.joining(", ", "(", ")"));
    }

    /**
     * 反转元组
     * 反转后元组大小不变，子类各自实现可以达到最好性能，也可以指定返回值类型，方便使用
     *
     * @return 反转后的元组
     */
    public abstract Tuple swap();

    /**
     * 从一个列表生成一个元组
     *
     * @param list 列表
     * @return 元组
     * @deprecated 此方法有些多余，会在未来版本删除，可以直接使用各个元组类的with系列方法，比如{@link Tuple2#with(List)}
     */
    @Deprecated
    public static Tuple withList(final List<Object> list) {
        requireNonNull(list, "list is null");
        switch (list.size()) {
            case 0:
                return Tuple0.with();
            case 1:
                return Tuple1.with(list.get(0));
            case 2:
                return Tuple2.with(list.get(0), list.get(1));
            case 3:
                return Tuple3.with(list.get(0), list.get(1), list.get(2));
            case 4:
                return Tuple4.with(list.get(0), list.get(1), list.get(2), list.get(3));
            case 5:
                return Tuple5.with(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4));
            default:
                return TupleN.withList(list);
        }
    }

    /**
     * 元组列表针对其中某个元素排序，例如
     * <pre>{@code
     *     List<Tuple2> list = new ArrayList<>();
     *     list.add(Tuple2.with(5, "5"));
     *     list.add(Tuple2.with(2, "2"));
     *     list.add(Tuple2.with(3, "3"));
     *     list.add(Tuple2.with(1, "1"));
     *     list.add(Tuple2.with(4, "4"));
     *     //按第一列Integer类型升序
     *     Tuple.sort(list, 0, Integer::compare);
     *     //按第二列String类型升序
     *     Tuple.sort(list, 1, String::compareTo);
     *     }
     * </pre>
     *
     * @param list       需要排序的元组列表
     * @param index      用于排序的元素序号
     * @param comparator 排序函数
     * @param <T>        需要排序的数据类型
     */
    @SuppressWarnings("unchecked")
    public static <T> void sort(final List<? extends Tuple> list, final int index, final Comparator<? super T> comparator) {
        requireNonNull(list, "list is null");
        if (list.size() < 2)
            return;
        requireNonNull(comparator, "comparator is null");
        if (index < 0)
            throw new IllegalArgumentException("index must >= 0");
        list.sort(Comparator.comparing(t -> (T) t.get(index), comparator));
    }

    /**
     * 元组数组针对其中某个元素排序，例如
     * <pre>{@code
     *     Tuple2[] array = new Tuple2[5];
     *     array[0] = Tuple2.with("5", 5);
     *     array[1] = Tuple2.with("2", 2);
     *     array[2] = Tuple2.with("3", 3);
     *     array[3] = Tuple2.with("1", 1);
     *     array[4] = Tuple2.with("4", 4);
     *     //按第一列String类型升序
     *     Tuple.sort(array, 0, String::compareTo);
     *     //按第二列Integer类型升序
     *     Tuple.sort(array, 1, Integer::compare);
     *     }
     * </pre>
     *
     * @param array      需要排序的元组数组
     * @param index      用于排序的元素序号
     * @param comparator 排序函数
     * @param <T>        需要排序的数据类型
     */
    @SuppressWarnings("unchecked")
    public static <T> void sort(final Tuple[] array, final int index, final Comparator<? super T> comparator) {
        requireNonNull(array, "array is null");
        if (array.length < 2)
            return;
        requireNonNull(comparator, "comparator is null");
        if (index < 0)
            throw new IllegalArgumentException("index must >= 0");
        Arrays.sort(array, Comparator.comparing(t -> (T) t.get(index), comparator));
    }
}

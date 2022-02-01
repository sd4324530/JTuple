package com.github.sd4324530.jtuple;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.requireNonNull;

/**
 * 创建元组工具类，使用更加简便
 *
 * @author peiyu
 */
public final class Tuples {

    private Tuples() {
    }

    /**
     * 创建Tuple0
     *
     * @return Tuple0
     */
    public static Tuple0 tuple() {
        return Tuple0.with();
    }

    /**
     * 创建Tuple1
     *
     * @param first 元素
     * @param <A>   元素泛型
     * @return Tuple1
     */
    public static <A> Tuple1<A> tuple(final A first) {
        return Tuple1.with(first);
    }

    /**
     * 创建Tuple2
     *
     * @param first  元素
     * @param second 元素
     * @param <A>    元素泛型
     * @param <B>    元素泛型
     * @return Tuple2
     */
    public static <A, B> Tuple2<A, B> tuple(final A first, final B second) {
        return Tuple2.with(first, second);
    }

    /**
     * 创建Tuple3
     *
     * @param first  元素
     * @param second 元素
     * @param third  元素
     * @param <A>    元素泛型
     * @param <B>    元素泛型
     * @param <C>    元素泛型
     * @return Tuple3
     */
    public static <A, B, C> Tuple3<A, B, C> tuple(final A first, final B second, final C third) {
        return Tuple3.with(first, second, third);
    }

    /**
     * 创建Tuple4
     *
     * @param first  元素
     * @param second 元素
     * @param third  元素
     * @param fourth 元素
     * @param <A>    元素泛型
     * @param <B>    元素泛型
     * @param <C>    元素泛型
     * @param <D>    元素泛型
     * @return Tuple4
     */
    public static <A, B, C, D> Tuple4<A, B, C, D> tuple(final A first, final B second, final C third, final D fourth) {
        return Tuple4.with(first, second, third, fourth);
    }

    /**
     * 创建Tuple5
     *
     * @param first  元素
     * @param second 元素
     * @param third  元素
     * @param fourth 元素
     * @param fifth  元素
     * @param <A>    元素泛型
     * @param <B>    元素泛型
     * @param <C>    元素泛型
     * @param <D>    元素泛型
     * @param <E>    元素泛型
     * @return Tuple5
     */
    public static <A, B, C, D, E> Tuple5<A, B, C, D, E> tuple(final A first, final B second, final C third, final D fourth, final E fifth) {
        return Tuple5.with(first, second, third, fourth, fifth);
    }

    /**
     * 由动态参数生成元组
     * 情况1：
     * 当传入的参数为：tuple("test", 123)时，当数量大于等于6的时候，才会走本方法，返回的实际类型为TupleN，可以按需转换
     * 情况2：
     * 当传入的参数为数组时，则会根据数组大小，返回对应类型的元组，可以按需转换，如下所示
     * <pre>
     *     {@code
     *     Object[] array = new Object[2];
     *     array[0] = "hello";
     *     array[1] = 456;
     *     Tuple2<String, Integer> tuple = (Tuple2<String, Integer>) tuple(array);
     *     }
     * </pre>
     *
     * @param args 数组
     * @return 返回的元组
     */
    public static Tuple tuple(final Object... args) {
        final Tuple tuple;
        switch (args.length) {
            case 0:
                tuple = Tuple0.with();
                break;
            case 1:
                tuple = Tuple1.with(args[0]);
                break;
            case 2:
                tuple = Tuple2.with(args[0], args[1]);
                break;
            case 3:
                tuple = Tuple3.with(args[0], args[1], args[2]);
                break;
            case 4:
                tuple = Tuple4.with(args[0], args[1], args[2], args[3]);
                break;
            case 5:
                tuple = Tuple5.with(args[0], args[1], args[2], args[3], args[4]);
                break;
            default:
                tuple = TupleN.with(args);
        }
        return tuple;
    }

    /**
     * 由List创建元组
     *
     * @param list 列表
     * @return 返回的元组，根据列表的长度，返回对应的元组类型
     */
    public static Tuple tuple(final List<?> list) {
        final Tuple tuple;
        switch (list.size()) {
            case 0:
                tuple = Tuple0.with();
                break;
            case 1:
                tuple = Tuple1.with(list.get(0));
                break;
            case 2:
                tuple = Tuple2.with(list.get(0), list.get(1));
                break;
            case 3:
                tuple = Tuple3.with(list.get(0), list.get(1), list.get(2));
                break;
            case 4:
                tuple = Tuple4.with(list.get(0), list.get(1), list.get(2), list.get(3));
                break;
            case 5:
                tuple = Tuple5.with(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4));
                break;
            default:
                tuple = TupleN.with(list.toArray());
        }
        return tuple;
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
    public static <T> void sort(final List<? extends Tuple> list, final int index, final Comparator<T> comparator) {
        requireNonNull(list, "list is null");
        if (list.size() < 2)
            return;
        requireNonNull(comparator, "comparator is null");
        if (index < 0)
            throw new IllegalArgumentException("index must >= 0");
        list.sort(Comparator.comparing(t -> t.get(index), comparator));
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
    public static <T> void sort(final Tuple[] array, final int index, final Comparator<T> comparator) {
        requireNonNull(array, "array is null");
        if (array.length < 2)
            return;
        requireNonNull(comparator, "comparator is null");
        if (index < 0)
            throw new IllegalArgumentException("index must >= 0");
        Arrays.sort(array, Comparator.comparing(t -> (T) t.get(index), comparator));
    }
}

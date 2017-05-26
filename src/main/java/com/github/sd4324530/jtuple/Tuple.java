package com.github.sd4324530.jtuple;

import java.io.Serializable;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Stream;

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

    public final List<Object> toList() {
        return new ArrayList<>(this.valueList);
    }

    public final Object[] toArray() {
        return this.valueList.toArray();
    }

    public final int size() {
        return this.valueList.size();
    }

    public final Object get(final int pos) {
        return this.valueList.get(pos);
    }

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

    @Override
    public final void forEach(Consumer<? super Object> action) {
        requireNonNull(action, "action is null");
        this.valueList.forEach(action);
    }

    public final void forEachWithIndex(BiConsumer<Integer, ? super Object> action) {
        requireNonNull(action, "action is null");
        for (int i = 0, length = this.valueList.size(); i < length; i++) {
            action.accept(i, this.valueList.get(i));
        }
    }

    public final Tuple subTuple(int start, int end) {
        if (start < 0 || end < 0)
            throw new IllegalArgumentException("start, end must >= 0");
        if (end >= this.valueList.size())
            throw new IllegalArgumentException("this tuple's size is" + this.valueList.size());
        int length = end - start + 1;
        if (length <= 0) {
            throw new IllegalArgumentException("end must >= start");
        }

        switch (length) {
            case 1:
                return Tuple1.with(this.valueList.get(start));
            case 2:
                return Tuple2.with(this.valueList.get(start), this.valueList.get(end));
            case 3:
                return Tuple3.with(this.valueList.get(start), this.valueList.get(start + 1), this.valueList.get(start + 2));
            case 4:
                return Tuple4.with(this.valueList.get(start), this.valueList.get(start + 1), this.valueList.get(start + 2), this.valueList.get(start + 3));
            default:
                return TupleN.with(this.valueList.subList(start, end));
        }
    }

    public Tuple add(Tuple other) {
        requireNonNull(other, "tuple is null");
        final Stream.Builder<Object> builder = Stream.builder();
        this.valueList.forEach(builder::add);
        other.valueList.forEach(builder::add);
        return TupleN.with(builder.build().toArray());
    }

    @Override
    public boolean equals(Object obj) {
        if (isNull(obj))
            return false;
        if (obj == this)
            return true;
        if (obj instanceof Tuple) {
            Tuple other = (Tuple) obj;
            return other.valueList.equals(this.valueList);
        }
        return false;
    }

    @Override
    public String toString() {
        final StringJoiner joiner = new StringJoiner(", ", "(", ")");
        this.valueList.forEach(obj -> joiner.add(obj.toString()));
        return joiner.toString();
    }

    /**
     * 反转元组
     * 反转
     * @return 反转后的元组
     */
    public abstract Tuple swap();

    /**
     * 从一个map生成一个元组，常用于json的转换
     *
     * @param map map
     * @return 元组
     */
    public static Tuple withMap(final Map<String, Object> map) {
        requireNonNull(map, "map is null");
        switch (map.size()) {
            case 1:
                return Tuple1.with(map.get("first"));
            case 2:
                return Tuple2.with(map.get("first"), map.get("second"));
            case 3:
                return Tuple3.with(map.get("first"), map.get("second"), map.get("third"));
            case 4:
                return Tuple4.with(map.get("first"), map.get("second"), map.get("third"), map.get("fourth"));
            default:
                return TupleN.with(map.values().toArray());
        }
    }

    /**
     * 从一个List生成一个元组
     *
     * @param list list
     * @return 元组
     */
    public static Tuple withList(final List<Object> list) {
        requireNonNull(list, "list is null");
        switch (list.size()) {
            case 1:
                return Tuple1.with(list.get(0));
            case 2:
                return Tuple2.with(list.get(0), list.get(1));
            case 3:
                return Tuple3.with(list.get(0), list.get(1), list.get(2));
            case 4:
                return Tuple4.with(list.get(0), list.get(1), list.get(2), list.get(3));
            default:
                return TupleN.with(list.toArray());
        }
    }
}
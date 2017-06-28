package com.github.sd4324530.jtuple;

import java.util.List;

import static java.util.Objects.requireNonNull;

/**
 * 表示有2个元素的元组类型
 * 可迭代
 * 不可变，线程安全
 *
 * @author peiyu
 */
public final class Tuple2<A, B> extends Tuple {

    public final A first;
    public final B second;

    private Tuple2(final A first, final B second) {
        super(first, second);
        this.first = first;
        this.second = second;
    }

    /**
     * 创建一个包含2个元素的元组
     *
     * @param first  第一个元素
     * @param second 第二个元素
     * @param <A>    第一个元素类型
     * @param <B>    第二个元素类型
     * @return 元组
     * @see Tuples#tuple(Object, Object)
     */
    public static <A, B> Tuple2<A, B> with(final A first, final B second) {
        return new Tuple2<>(first, second);
    }

    /**
     * 通过列表创建一个包含2个元素的元组
     * 包含的元素是列表的前两个元素，如果不存在，则为null
     *
     * @param list 列表
     * @param <A>  第一个元素类型
     * @param <B>  第二个元素类型
     * @return 元组
     */
    @SuppressWarnings("unchecked")
    public static <A, B> Tuple2<A, B> with(final List<Object> list) {
        requireNonNull(list, "list is null");
        switch (list.size()) {
            case 0:
                return new Tuple2<>(null, null);
            case 1:
                return new Tuple2<>((A) list.get(0), null);
        }
        return new Tuple2<>((A) list.get(0), (B) list.get(1));
    }

    /**
     * 反转元组
     *
     * @return 反转后的元组
     */
    @Override
    public Tuple2<B, A> swap() {
        return Tuple2.with(this.second, this.first);
    }
}

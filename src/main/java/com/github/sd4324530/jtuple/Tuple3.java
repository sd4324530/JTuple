package com.github.sd4324530.jtuple;

import java.util.List;

import static java.util.Objects.requireNonNull;

/**
 * 表示有3个元素的元组类型
 * 可迭代
 * 不可变，线程安全
 *
 * @author peiyu
 */
public final class Tuple3<A, B, C> extends Tuple {

    public final A _0;
    public final B _1;
    public final C _2;

    private Tuple3(final A first, final B second, final C third) {
        super(first, second, third);
        this._0 = first;
        this._1 = second;
        this._2 = third;
    }

    /**
     * 创建一个包含3个元素的元组
     *
     * @param first  第一个元素
     * @param second 第二个元素
     * @param third  第三个元素
     * @param <A>    第一个元素类型
     * @param <B>    第二个元素类型
     * @param <C>    第三个元素类型
     * @return 元组
     */
    public static <A, B, C> Tuple3<A, B, C> with(final A first, final B second, final C third) {
        return new Tuple3<>(first, second, third);
    }

    /**
     * 通过列表创建一个包含3个元素的元组
     * 包含的元素是列表的前三个元素
     *
     * @param list 列表
     * @param <A>  第一个元素类型
     * @param <B>  第二个元素类型
     * @param <C>  第三个元素类型
     * @return 元组
     */
    public static <A, B, C> Tuple3<A, B, C> with(final List<Object> list) {
        requireNonNull(list, "list is null");
        if (list.size() != 3)
            throw new IllegalArgumentException("list's size != 3");
        return new Tuple3((A) list.get(0), (B) list.get(1), (C) list.get(2));
    }

    /**
     * 反转元组
     *
     * @return 反转后的元组
     */
    @Override
    public Tuple3<C, B, A> swap() {
        return Tuple3.with(this._2, this._1, this._0);
    }
}

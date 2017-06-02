package com.github.sd4324530.jtuple;

import java.util.List;

import static java.util.Objects.requireNonNull;

/**
 * 表示有4个元素的元组类型
 * 可迭代
 * 不可变，线程安全
 *
 * @author peiyu
 */
public final class Tuple4<A, B, C, D> extends Tuple {

    public final A _0;
    public final B _1;
    public final C _2;
    public final D _3;

    private Tuple4(final A first, final B second, final C third, final D fourth) {
        super(first, second, third, fourth);
        this._0 = first;
        this._1 = second;
        this._2 = third;
        this._3 = fourth;
    }

    /**
     * 创建一个包含4个元素的元组
     *
     * @param first  第一个元素
     * @param second 第二个元素
     * @param third  第三个元素
     * @param fourth 第四个元素
     * @param <A>    第一个元素类型
     * @param <B>    第二个元素类型
     * @param <C>    第三个元素类型
     * @param <D>    第四个元素类型
     * @return 元组
     */
    public static <A, B, C, D> Tuple4<A, B, C, D> with(final A first, final B second, final C third, final D fourth) {
        return new Tuple4<>(first, second, third, fourth);
    }

    /**
     * 通过列表创建一个包含4个元素的元组
     * 包含的元素是列表的前四个元素
     *
     * @param list 列表
     * @param <A>  第一个元素类型
     * @param <B>  第二个元素类型
     * @param <C>  第三个元素类型
     * @param <D>  第四个元素类型
     * @return 元组
     */
    public static <A, B, C, D> Tuple4<A, B, C, D> with(final List<Object> list) {
        requireNonNull(list, "list is null");
        if (list.size() != 4)
            throw new IllegalArgumentException("list's size != 4");
        return new Tuple4((A) list.get(0), (B) list.get(1), (C) list.get(2), (D) list.get(3));
    }

    /**
     * 反转元组
     *
     * @return 反转后的元组
     */
    @Override
    public Tuple4<D, C, B, A> swap() {
        return Tuple4.with(this._3, this._2, this._1, this._0);
    }
}

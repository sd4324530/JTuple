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

    public static <A, B, C, D> Tuple4<A, B, C, D> with(final A first, final B second, final C third, final D fourth) {
        return new Tuple4<>(first, second, third, fourth);
    }

    public static <A, B, C, D> Tuple4<A, B, C, D> with(final List<Object> list) {
        requireNonNull(list, "list is null");
        if (list.size() != 4)
            throw new IllegalArgumentException("list's size != 4");
        return new Tuple4((A) list.get(0), (B) list.get(1), (C) list.get(2), (D) list.get(3));
    }

    @Override
    public Tuple4<D, C, B, A> swap() {
        return Tuple4.with(this._3, this._2, this._1, this._0);
    }
}

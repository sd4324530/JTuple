package com.github.sd4324530.jtuple;

import java.util.List;
import java.util.Map;

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

    public static <A, B, C> Tuple3<A, B, C> with(final A first, final B second, final C third) {
        return new Tuple3<>(first, second, third);
    }

    public static <A, B, C> Tuple3<A, B, C> with(final List<Object> list) {
        requireNonNull(list, "list is null");
        if (list.size() != 3)
            throw new IllegalArgumentException("list's size != 3");
        return new Tuple3((A) list.get(0), (B) list.get(1), (C) list.get(2));
    }

    @Override
    public Tuple3<C, B, A> swap() {
        return Tuple3.with(this._2, this._1, this._0);
    }
}

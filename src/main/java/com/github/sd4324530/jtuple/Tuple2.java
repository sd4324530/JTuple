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

    public final A _0;
    public final B _1;

    private Tuple2(final A first, final B second) {
        super(first, second);
        this._0 = first;
        this._1 = second;
    }

    public static <A, B> Tuple2<A, B> with(final A first, final B second) {
        return new Tuple2<>(first, second);
    }

    public static <A, B> Tuple2<A, B> with(final List<Object> list) {
        requireNonNull(list, "list is null");
        if (list.size() != 2)
            throw new IllegalArgumentException("list's size != 2");
        return new Tuple2<>((A) list.get(0), (B) list.get(1));
    }

    @Override
    public Tuple2<B, A> swap() {
        return Tuple2.with(this._1, this._0);
    }
}

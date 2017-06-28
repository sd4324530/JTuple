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

    public final A first;
    public final B second;
    public final C third;
    public final D fourth;

    private Tuple4(final A first, final B second, final C third, final D fourth) {
        super(first, second, third, fourth);
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
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
     * @see Tuples#tuple(Object, Object, Object, Object)
     */
    public static <A, B, C, D> Tuple4<A, B, C, D> with(final A first, final B second, final C third, final D fourth) {
        return new Tuple4<>(first, second, third, fourth);
    }

    /**
     * 通过列表创建一个包含4个元素的元组
     * 包含的元素是列表的前四个元素，如果不存在，则为null
     *
     * @param list 列表
     * @param <A>  第一个元素类型
     * @param <B>  第二个元素类型
     * @param <C>  第三个元素类型
     * @param <D>  第四个元素类型
     * @return 元组
     */
    @SuppressWarnings("unchecked")
    public static <A, B, C, D> Tuple4<A, B, C, D> with(final List<Object> list) {
        requireNonNull(list, "list is null");
        switch (list.size()) {
            case 0:
                return new Tuple4<>(null, null, null, null);
            case 1:
                return new Tuple4<>((A) list.get(0), null, null, null);
            case 2:
                return new Tuple4<>((A) list.get(0), (B) list.get(1), null, null);
            case 3:
                return new Tuple4<>((A) list.get(0), (B) list.get(1), (C) list.get(2), null);
        }
        return new Tuple4((A) list.get(0), (B) list.get(1), (C) list.get(2), (D) list.get(3));
    }

    /**
     * 反转元组
     *
     * @return 反转后的元组
     */
    @Override
    public Tuple4<D, C, B, A> swap() {
        return Tuple4.with(this.fourth, this.third, this.second, this.first);
    }
}

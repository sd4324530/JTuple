package com.github.sd4324530.jtuple;

import java.util.List;

import static java.util.Objects.requireNonNull;

/**
 * 表示有5个元素的元组类型
 * 可迭代
 * 不可变，线程安全
 *
 * @author peiyu
 */
public final class Tuple5<A, B, C, D, E> extends Tuple {

    public final A first;
    public final B second;
    public final C third;
    public final D fourth;
    public final E fifth;

    private Tuple5(final A first, final B second, final C third, final D fourth, final E fifth) {
        super(first, second, third, fourth, fifth);
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.fifth = fifth;
    }

    /**
     * 创建一个包含5个元素的元组
     *
     * @param first  第一个元素
     * @param second 第二个元素
     * @param third  第三个元素
     * @param fourth 第四个元素
     * @param fifth  第五个元素
     * @param <A>    第一个元素类型
     * @param <B>    第二个元素类型
     * @param <C>    第三个元素类型
     * @param <D>    第四个元素类型
     * @param <E>    第五个元素类型
     * @return 元组
     */
    public static <A, B, C, D, E> Tuple5<A, B, C, D, E> with(final A first, final B second, final C third, final D fourth, final E fifth) {
        return new Tuple5<>(first, second, third, fourth, fifth);
    }

    /**
     * 通过列表创建一个包含5个元素的元组
     * 包含的元素是列表的前五个元素，如果不存在，则为null
     *
     * @param list 列表
     * @param <A>  第一个元素类型
     * @param <B>  第二个元素类型
     * @param <C>  第三个元素类型
     * @param <D>  第四个元素类型
     * @param <E>  第五个元素类型
     * @return 元组
     */
    public static <A, B, C, D, E> Tuple5<A, B, C, D, E> with(final List<Object> list) {
        requireNonNull(list, "list is null");
        switch (list.size()) {
            case 0:
                return new Tuple5<>(null, null, null, null, null);
            case 1:
                return new Tuple5<>((A) list.get(0), null, null, null, null);
            case 2:
                return new Tuple5<>((A) list.get(0), (B) list.get(1), null, null, null);
            case 3:
                return new Tuple5<>((A) list.get(0), (B) list.get(1), (C) list.get(2), null, null);
            case 4:
                return new Tuple5<>((A) list.get(0), (B) list.get(1), (C) list.get(2), (D) list.get(3), null);
        }
        return new Tuple5((A) list.get(0), (B) list.get(1), (C) list.get(2), (D) list.get(3), (E) list.get(4));
    }

    /**
     * 反转元组
     *
     * @return 反转后的元组
     */
    @Override
    public Tuple5<E, D, C, B, A> swap() {
        return Tuple5.with(this.fifth, this.fourth, this.third, this.second, this.first);
    }
}

package com.github.sd4324530.jtuple;

/**
 * 表示有0个元素的元组类型
 *
 * @author peiyu
 */
public final class Tuple0 extends Tuple {

    private static final Object[] EMPTY    = new Object[]{};
    private static final Tuple0   INSTANCE = new Tuple0();

    private Tuple0() {
        super(EMPTY);
    }

    @Override
    public Tuple0 swap() {
        return this;
    }

    public static Tuple0 with() {
        return INSTANCE;
    }
}

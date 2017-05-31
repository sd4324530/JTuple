package com.github.sd4324530.jtuple;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * @author peiyu
 */
public class TupleTest {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Test
    public void testToString() {
        TupleN tuple = TupleN.with("hello", 123, true, 186.5, null);
        log.debug("toString:{}", tuple.toString());
    }

    @Test
    public void testForeach() {
        TupleN tuple = TupleN.with("hello", 123, true, 186.5, null);
        log.debug("foreach:");
        tuple.forEach(o -> log.debug(Objects.toString(o)));
    }

    @Test
    public void testAdd() {
        Tuple1 tuple1 = Tuple1.with("hello");
        Tuple2 tuple2 = Tuple2.with("world", "!");
        Tuple3 tuple3 = Tuple3.with(1, 2, null);
        log.debug("add:{}", tuple1.add(tuple2).toString());
        log.debug("add:{}", tuple1.add(tuple2, tuple3).toString());
    }

    @Test
    public void testSwap() {
        TupleN tuple = TupleN.with("hello", 123, true, null, 186.5);
        log.debug("swap:{}", tuple.swap().toString());
    }

    @Test
    public void testTuple0() {
        Tuple0 tuple0 = Tuple0.with();
        Tuple0 tuple01 = Tuple0.with();
        log.debug("tuple0:{}", tuple0 == tuple01);
        Tuple1 tuple1 = Tuple1.with("123");
        log.debug("0+1:{}", tuple0.add(tuple1));
    }

    @Test
    public void testRepeat() {
        Tuple2 tuple2 = Tuple2.with("a", null);
        log.debug("repeat:{}", tuple2.repeat(3).toString());
    }

    @Test
    public void testTuple2() {
        Tuple2 tuple2 = Tuple2.with("test", 123);
        log.debug("first:{}", tuple2._0);//test
        log.debug("second:{}", tuple2._1);//123
    }

    @Test
    public void testNull() {
        Tuple2 tuple2 = Tuple2.with("test", null);
        log.debug("test null:{}", tuple2.toString());
        log.debug("null:{}", tuple2._1);
    }
}

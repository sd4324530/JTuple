package com.github.sd4324530.jtuple;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author peiyu
 */
public class TupleTest {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Test
    public void testToString() {
        TupleN tuple = TupleN.with("hello", 123, true, 186.5);
        log.debug("toString:{}", tuple.toString());
    }

    @Test
    public void testForeach() {
        TupleN tuple = TupleN.with("hello", 123, true, 186.5);
        log.debug("foreach:");
        tuple.forEach(o -> log.debug(o.toString()));
    }

    @Test
    public void testAdd() {
        Tuple1 tuple1 = Tuple1.with("hello");
        Tuple2 tuple2 = Tuple2.with("world", "!");
        log.debug("add:{}", tuple1.add(tuple2).toString());
    }

    @Test
    public void testSwap() {
        TupleN tuple = TupleN.with("hello", 123, true, 186.5);
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
        Tuple2 tuple2 = Tuple2.with("a", "b");
        log.debug("repeat2:{}", tuple2.repeat(3).toString());
    }
}

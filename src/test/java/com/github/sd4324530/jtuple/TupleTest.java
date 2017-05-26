package com.github.sd4324530.jtuple;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
}

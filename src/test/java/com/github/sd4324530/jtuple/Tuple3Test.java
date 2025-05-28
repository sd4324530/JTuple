package com.github.sd4324530.jtuple;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author peiyu
 */
public class Tuple3Test {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Test
    public void testWith() {
        Tuple3<Integer, String, Double> tuple3 = Tuple3.with(123, "test", 186.5);
        log.debug("tuple3:{}", tuple3);
        log.debug("first:{}", tuple3.first);
        log.debug("second:{}", tuple3.second);
        log.debug("third:{}", tuple3.third);
    }

    @Test
    public void testSwap() {
        Tuple3<Integer, String, Double> tuple3 = Tuple3.with(123, "test", 186.5);
        log.debug("reverse:{}", tuple3.reverse());
    }
}

package com.github.sd4324530.jtuple;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author peiyu
 */
public class Tuple4Test {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Test
    public void testWith() {
        Tuple4<Integer, String, Double, Boolean> tuple4 = Tuple4.with(123, "test", 186.5, true);
        log.debug("tuple4:{}", tuple4);
        log.debug("first:{}", tuple4.first);
        log.debug("second:{}", tuple4.second);
        log.debug("third:{}", tuple4.third);
        log.debug("fourth:{}", tuple4.fourth);
    }

    @Test
    public void testSwap() {
        Tuple4<Integer, String, Double, Boolean> tuple4 = Tuple4.with(123, "test", 186.5, true);
        log.debug("reverse:{}", tuple4.reverse());
    }
}

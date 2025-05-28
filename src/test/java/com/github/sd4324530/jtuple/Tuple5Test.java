package com.github.sd4324530.jtuple;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author peiyu
 */
public class Tuple5Test {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Test
    public void testWith() {
        Tuple5<Integer, String, Double, Boolean, Object> tuple5 = Tuple5.with(123, "test", 186.5, true, null);
        log.debug("tuple5:{}", tuple5);
        log.debug("first:{}", tuple5.first);
        log.debug("second:{}", tuple5.second);
        log.debug("third:{}", tuple5.third);
        log.debug("fourth:{}", tuple5.fourth);
        log.debug("fifth:{}", tuple5.fifth);
    }

    @Test
    public void testSwap() {
        Tuple5<Integer, String, Double, Boolean, Object> tuple5 = Tuple5.with(123, "test", 186.5, true, null);
        log.debug("reverse:{}", tuple5.reverse());
    }
}

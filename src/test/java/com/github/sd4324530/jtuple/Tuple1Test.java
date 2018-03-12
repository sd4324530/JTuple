package com.github.sd4324530.jtuple;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author peiyu
 */
public class Tuple1Test {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Test
    public void testWith() {
        Tuple1 tuple1 = Tuple1.with("hello");
        log.debug("tuple1:{}", tuple1.toString());
        log.debug("first:{}", tuple1.first);
    }

    @Test
    public void testSwap() {
        Tuple1 tuple1 = Tuple1.with("hello");
        log.debug("reverse:{}", tuple1.reverse().toString());
    }
}

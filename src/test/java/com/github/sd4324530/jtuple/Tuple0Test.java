package com.github.sd4324530.jtuple;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author peiyu
 */
public class Tuple0Test {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Test
    public void testWith() {
        Tuple0 tuple0 = Tuple0.with();
        log.debug("tuple0:{}", tuple0.toString());
    }

    @Test
    public void testSwap() {
        Tuple0 tuple0 = Tuple0.with();
        log.debug("reverse:{}", tuple0.reverse().toString());
    }
}

package com.github.sd4324530.jtuple;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author peiyu
 */
public class Tuple2Test {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Test
    public void testWith() {
        Tuple2 tuple2 = Tuple2.with("test", 123);
        log.debug("tuple2:{}", tuple2.toString());
        log.debug("first:{}", tuple2.first);
        log.debug("second:{}", tuple2.second);
    }

    @Test
    public void testSwap() {
        Tuple2 tuple2 = Tuple2.with("test", 123);
        log.debug("reverse:{}", tuple2.reverse().toString());
    }

}

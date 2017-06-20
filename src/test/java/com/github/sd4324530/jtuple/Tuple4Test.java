package com.github.sd4324530.jtuple;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author peiyu
 */
public class Tuple4Test {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Test
    public void testWith() {
        Tuple4 tuple4 = Tuple4.with(123, "test", 186.5, true);
        log.debug("tuple4:{}", tuple4.toString());
        log.debug("first:{}", tuple4.first);
        log.debug("second:{}", tuple4.second);
        log.debug("third:{}", tuple4.third);
        log.debug("fourth:{}", tuple4.fourth);
        List<Object> list = new ArrayList<>();
        list.add("say");
        list.add(true);
        list.add(123);
        list.add(null);
        Tuple4 tuple41 = Tuple4.with(list);
        log.debug("tuple41:{}", tuple41.toString());
    }

    @Test
    public void testSwap() {
        Tuple4 tuple4 = Tuple4.with(123, "test", 186.5, true);
        log.debug("swap:{}", tuple4.swap().toString());
    }
}

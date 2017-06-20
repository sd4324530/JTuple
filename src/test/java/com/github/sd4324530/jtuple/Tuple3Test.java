package com.github.sd4324530.jtuple;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author peiyu
 */
public class Tuple3Test {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Test
    public void testWith() {
        Tuple3 tuple3 = Tuple3.with(123, "test", 186.5);
        log.debug("tuple3:{}", tuple3.toString());
        log.debug("first:{}", tuple3.first);
        log.debug("second:{}", tuple3.second);
        log.debug("third:{}", tuple3.third);
        List<Object> list = new ArrayList<>();
        list.add("say");
        list.add(true);
        list.add(123);
        Tuple3 tuple31 = Tuple3.with(list);
        log.debug("tuple31:{}", tuple31.toString());
    }

    @Test
    public void testSwap() {
        Tuple3 tuple3 = Tuple3.with(123, "test", 186.5);
        log.debug("swap:{}", tuple3.swap().toString());
    }
}

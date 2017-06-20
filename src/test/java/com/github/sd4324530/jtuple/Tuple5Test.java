package com.github.sd4324530.jtuple;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author peiyu
 */
public class Tuple5Test {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Test
    public void testWith() {
        Tuple5 tuple5 = Tuple5.with(123, "test", 186.5, true, null);
        log.debug("tuple5:{}", tuple5.toString());
        log.debug("first:{}", tuple5.first);
        log.debug("second:{}", tuple5.second);
        log.debug("third:{}", tuple5.third);
        log.debug("fourth:{}", tuple5.fourth);
        log.debug("fifth:{}", tuple5.fifth);
        List<Object> list = new ArrayList<>();
        list.add("say");
        list.add(true);
        list.add(123);
        list.add(null);
        list.add('A');
        Tuple5 tuple51 = Tuple5.with(list);
        log.debug("tuple51:{}", tuple51.toString());
    }

    @Test
    public void testSwap() {
        Tuple5 tuple5 = Tuple5.with(123, "test", 186.5, true, null);
        log.debug("swap:{}", tuple5.swap().toString());
    }
}

package com.github.sd4324530.jtuple;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

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
        List<Object> list = new ArrayList<>();
        list.add("say");
        list.add(true);
        Tuple2<String, Boolean> tuple21 = Tuple2.with(list);
        log.debug("tuple21:{}", tuple21.toString());
    }

    @Test
    public void testSwap() {
        Tuple2 tuple2 = Tuple2.with("test", 123);
        log.debug("swap:{}", tuple2.swap().toString());
    }

}

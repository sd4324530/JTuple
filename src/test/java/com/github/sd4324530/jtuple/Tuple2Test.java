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
        //空List传入
        Tuple2<String, Boolean> tuple21 = Tuple2.with(list);
        log.debug("tuple21:{}", tuple21.toString());
        list.add("say");
        //size=1的List传入
        Tuple2<String, Boolean> tuple22 = Tuple2.with(list);
        log.debug("tuple22:{}", tuple22.toString());
        list.add(true);
        //正常传入
        Tuple2<String, Boolean> tuple23 = Tuple2.with(list);
        log.debug("tuple23:{}", tuple23.toString());
    }

    @Test
    public void testSwap() {
        Tuple2 tuple2 = Tuple2.with("test", 123);
        log.debug("swap:{}", tuple2.swap().toString());
    }

}

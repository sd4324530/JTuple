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
        //空List传入
        Tuple5 tuple51 = Tuple5.with(list);
        log.debug("tuple51:{}", tuple51.toString());
        list.add("say");
        //size=1的List传入
        Tuple5 tuple52 = Tuple5.with(list);
        log.debug("tuple52:{}", tuple52.toString());
        list.add(true);
        //size=2的List传入
        Tuple5 tuple53 = Tuple5.with(list);
        log.debug("tuple53:{}", tuple53.toString());
        list.add(123);
        //size=3的List传入
        Tuple5 tuple54 = Tuple5.with(list);
        log.debug("tuple54:{}", tuple54.toString());
        list.add(null);
        //size=4的List传入
        Tuple5 tuple55 = Tuple5.with(list);
        log.debug("tuple55:{}", tuple55.toString());
        list.add('A');
        //正常传入
        Tuple5 tuple56 = Tuple5.with(list);
        log.debug("tuple56:{}", tuple56.toString());
    }

    @Test
    public void testSwap() {
        Tuple5 tuple5 = Tuple5.with(123, "test", 186.5, true, null);
        log.debug("swap:{}", tuple5.swap().toString());
    }
}

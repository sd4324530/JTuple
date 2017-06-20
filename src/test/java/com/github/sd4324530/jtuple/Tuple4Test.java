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
        //空List传入
        Tuple4 tuple41 = Tuple4.with(list);
        log.debug("tuple41:{}", tuple41.toString());
        list.add("say");
        //size=1的List传入
        Tuple4 tuple42 = Tuple4.with(list);
        log.debug("tuple42:{}", tuple42.toString());
        list.add(true);
        //size=2的List传入
        Tuple4 tuple43 = Tuple4.with(list);
        log.debug("tuple43:{}", tuple43.toString());
        list.add(123);
        //size=3的List传入
        Tuple4 tuple44 = Tuple4.with(list);
        log.debug("tuple44:{}", tuple44.toString());
        list.add(null);
        //正常传入
        Tuple4 tuple45 = Tuple4.with(list);
        log.debug("tuple45:{}", tuple45.toString());
    }

    @Test
    public void testSwap() {
        Tuple4 tuple4 = Tuple4.with(123, "test", 186.5, true);
        log.debug("swap:{}", tuple4.swap().toString());
    }
}

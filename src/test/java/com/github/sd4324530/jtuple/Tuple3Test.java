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
        //空List传入
        Tuple3 tuple31 = Tuple3.with(list);
        log.debug("tuple31:{}", tuple31.toString());
        list.add("say");
        //size=1的List传入
        Tuple3 tuple32 = Tuple3.with(list);
        log.debug("tuple32:{}", tuple32.toString());
        list.add(true);
        //size=2的List传入
        Tuple3 tuple33 = Tuple3.with(list);
        log.debug("tuple33:{}", tuple33.toString());
        list.add(123);
        //正常传入
        Tuple3 tuple34 = Tuple3.with(list);
        log.debug("tuple34:{}", tuple34.toString());
    }

    @Test
    public void testSwap() {
        Tuple3 tuple3 = Tuple3.with(123, "test", 186.5);
        log.debug("swap:{}", tuple3.swap().toString());
    }
}

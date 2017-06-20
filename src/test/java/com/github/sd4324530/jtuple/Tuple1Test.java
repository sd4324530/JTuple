package com.github.sd4324530.jtuple;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author peiyu
 */
public class Tuple1Test {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Test
    public void testWith() {
        Tuple1 tuple1 = Tuple1.with("hello");
        log.debug("tuple1:{}", tuple1.toString());
        log.debug("first:{}", tuple1.first);
        List<String> list = new ArrayList<>();
        //空List传入
        Tuple1 tuple11 = Tuple1.with(list);
        log.debug("tuple11:{}", tuple11.toString());
        list.add("world");
        //正常List传入
        Tuple1 tuple12 = Tuple1.with(list);
        log.debug("tuple12:{}", tuple12.toString());
    }

    @Test
    public void testSwap() {
        Tuple1 tuple1 = Tuple1.with("hello");
        log.debug("swap:{}", tuple1.swap().toString());
    }
}

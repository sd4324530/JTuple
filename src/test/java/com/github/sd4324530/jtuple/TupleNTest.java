package com.github.sd4324530.jtuple;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author peiyu
 */
public class TupleNTest {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Test
    public void testWith() {
        TupleN tupleN = TupleN.with(123, 456, "test", "hello", "world", true, 2.5, null, 'B');
        log.debug("tupleN:{}", tupleN.toString());
        Integer first = tupleN.get(0);
        String third = tupleN.get(2);
        log.debug("first:{}", first);
        log.debug("third:{}", third);
        List<Object> list = new ArrayList<>();
        list.add("say");
        list.add(true);
        list.add(123);
        list.add(null);
        list.add('A');
        list.add(null);
        list.add("test");
        TupleN tupleN1 = TupleN.withList(list);
        log.debug("tupleN1:{}", tupleN1.toString());
    }

    @Test
    public void testSwap() {
        TupleN tupleN = TupleN.with(123, 456, "test", "hello", "world", true, 2.5, null, 'B');
        log.debug("swap:{}", tupleN.swap().toString());
    }

}

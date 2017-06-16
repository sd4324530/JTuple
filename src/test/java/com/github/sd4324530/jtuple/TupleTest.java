package com.github.sd4324530.jtuple;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * @author peiyu
 */
public class TupleTest {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Test
    public void testToString() {
        TupleN tuple = TupleN.with("hello", 123, true, 186.5, null);
        String one = tuple.get(0);
        int two = tuple.get(1);
        log.debug("one:{}", one);
        log.debug("two:{}", two);
        log.debug("toString:{}", tuple.toString());
    }

    @Test
    public void testForeach() {
        TupleN tuple = TupleN.with("hello", 123, true, 186.5, null);
        log.debug("foreach:");
        tuple.forEach(o -> log.debug(Objects.toString(o)));
    }

    @Test
    public void testAdd() {
        Tuple1 tuple1 = Tuple1.with("hello");
        Tuple2 tuple2 = Tuple2.with("world", "!");
        Tuple3 tuple3 = Tuple3.with(1, 2, null);
        log.debug("add:{}", tuple1.add(tuple2).toString());
        log.debug("add:{}", tuple1.add(tuple2, tuple3).toString());
    }

    @Test
    public void testSwap() {
        TupleN tuple = TupleN.with("hello", 123, true, null, 186.5);
        log.debug("swap:{}", tuple.swap().toString());
    }

    @Test
    public void testTuple0() {
        Tuple0 tuple0 = Tuple0.with();
        Tuple0 tuple01 = Tuple0.with();
        log.debug("tuple0:{}", tuple0 == tuple01);
        Tuple1 tuple1 = Tuple1.with("123");
        log.debug("0+1:{}", tuple0.add(tuple1));
    }

    @Test
    public void testRepeat() {
        Tuple2 tuple2 = Tuple2.with("a", null);
        log.debug("repeat:{}", tuple2.repeat(3).toString());
    }

    @Test
    public void testTuple2() {
        Tuple2 tuple2 = Tuple2.with("test", 123);
        log.debug("first:{}", tuple2.first);//test
        log.debug("second:{}", tuple2.second);//123
    }

    @Test
    public void testNull() {
        Tuple2 tuple2 = Tuple2.with("test", null);
        log.debug("test null:{}", tuple2.toString());
        log.debug("null:{}", tuple2.second);
    }

    @Test
    public void testSub() {
        TupleN tupleN = TupleN.with(0, 1, 2, 3, 4, 5, 6);
        log.debug("sub:{}", tupleN.subTuple(0, 3).toString());
    }

    @Test
    public void testStream() {
        TupleN tupleN = TupleN.with("hello", 123, true, null, 186.5);
        tupleN.stream().forEach(o -> log.debug("元素:{}", o));
    }

    @Test
    public void testSort() {
        List<Tuple2> list = new ArrayList<>();
        list.add(Tuple2.with(5, "5"));
        list.add(Tuple2.with(2, "2"));
        list.add(Tuple2.with(3, "3"));
        list.add(Tuple2.with(1, "1"));
        list.add(Tuple2.with(4, "4"));
        log.debug("before:{}", list);
        //按第一列Integer类型升序
        Tuple.sort(list, 0, Integer::compare);
        log.debug("after:{}", list);

        Tuple2[] array = new Tuple2[5];
        array[0] = Tuple2.with("5", 5);
        array[1] = Tuple2.with("2", 2);
        array[2] = Tuple2.with("3", 3);
        array[3] = Tuple2.with("1", 1);
        array[4] = Tuple2.with("4", 4);
        log.debug("before:{}", Arrays.toString(array));
        //按第一列String类型升序
        Tuple.sort(array, 0, String::compareTo);
        log.debug("after:{}", Arrays.toString(array));

    }
}

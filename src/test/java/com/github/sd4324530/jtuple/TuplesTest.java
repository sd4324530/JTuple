package com.github.sd4324530.jtuple;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.github.sd4324530.jtuple.Tuples.sort;
import static com.github.sd4324530.jtuple.Tuples.tuple;

/**
 * @author peiyu
 */
public class TuplesTest {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Test
    public void testTuple0() {
        Tuple0 tuple = tuple();
        log.debug("tuple0:{}", tuple.toString());
    }

    @Test
    public void testTuple1() {
        Tuple1<String> tuple = tuple("test");
        log.debug("tuple1:{}", tuple);
    }

    @Test
    public void testTuple2() {
        Tuple2<String, Integer> tuple = tuple("test", 123);
        log.debug("tuple2:{}", tuple);
    }

    @Test
    public void testTuple3() {
        Tuple3<String, Integer, Boolean> tuple = tuple("test", 123, true);
        log.debug("tuple3:{}", tuple);
    }

    @Test
    public void testTuple4() {
        Tuple4<String, Integer, Boolean, Double> tuple = tuple("test", 123, true, 186.5);
        log.debug("tuple4:{}", tuple);
    }

    @Test
    public void testTuple5() {
        Tuple5<String, Integer, Boolean, Double, Character> tuple = tuple("test", 123, true, 186.5, 'A');
        log.debug("tuple5:{}", tuple);
    }

    @Test
    public void testArrayTupleN() {
        Object[] array = new Object[2];
        array[0] = "hello";
        array[1] = 456;
        Tuple2<String, Integer> tuple = (Tuple2<String, Integer>) tuple(array);
        log.debug("tuple class:{}", tuple.getClass());
        log.debug("tuple:{}", tuple);
    }

    @Test
    public void testListTuple() {
        List<Object> list = new ArrayList<>();
        Tuple tuple0 = tuple(list);
        log.debug("tuple class:{}", tuple0.getClass());
        log.debug("tuple:{}", tuple0);
        list.add("hello");
        Tuple tuple1 = tuple(list);
        log.debug("tuple class:{}", tuple1.getClass());
        log.debug("tuple:{}", tuple1);
        list.add(456);
        Tuple tuple2 = tuple(list);
        log.debug("tuple class:{}", tuple2.getClass());
        log.debug("tuple:{}", tuple2);
        list.add(456);
        Tuple tuple3 = tuple(list);
        log.debug("tuple class:{}", tuple3.getClass());
        log.debug("tuple:{}", tuple3);
        list.add(456);
        Tuple tuple4 = tuple(list);
        log.debug("tuple class:{}", tuple4.getClass());
        log.debug("tuple:{}", tuple4);
        list.add(456);
        Tuple tuple5 = tuple(list);
        log.debug("tuple class:{}", tuple5.getClass());
        log.debug("tuple:{}", tuple5);
        list.add('A');
        Tuple tupleN = tuple(list);
        log.debug("tuple class:{}", tupleN.getClass());
        log.debug("tuple:{}", tupleN);
    }

    @Test
    public void testSort() {
        List<Tuple2> list = new ArrayList<>();
        list.add(tuple(5, "5"));
        list.add(tuple(2, "2"));
        list.add(tuple(3, "3"));
        list.add(tuple(1, "1"));
        list.add(tuple(4, "4"));
        log.debug("before:{}", list);
        //按第一列Integer类型升序
        sort(list, 0, Integer::compare);
        log.debug("after:{}", list);

        Tuple2[] array = new Tuple2[5];
        array[0] = tuple("5", 5);
        array[1] = tuple("2", 2);
        array[2] = tuple("3", 3);
        array[3] = tuple("1", 1);
        array[4] = tuple("4", 4);
        log.debug("before:{}", Arrays.toString(array));
        //按第一列String类型升序
        sort(array, 0, String::compareTo);
        log.debug("after:{}", Arrays.toString(array));


        List<Tuple2> list2 = new ArrayList<>();
        //空List传入
        sort(list2, 0, Integer::compare);
        list2.add(tuple(5, "5"));
        //size=1的List传入
        sort(list2, 0, Integer::compare);

        Tuple2[] array2 = new Tuple2[0];
        //空数组传入
        sort(array2, 0, String::compareTo);
        array2 = new Tuple2[1];
        array2[0] = tuple("5", 5);
        //length=1的数组传入
        sort(array2, 0, String::compareTo);
        try {
            sort(list, -1, Integer::compare);
        } catch (Exception e) {
            log.error("", e);
        }
        try {
            sort(array, -1, Integer::compare);
        } catch (Exception e) {
            log.error("", e);
        }
    }
}

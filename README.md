# JTuple

java语言版本的`元组`数据类型，实现了元组类型的特性（`不可变`、 `可迭代`）以及常用操作方法

**轻量级，无依赖，线程安全**



## 主要实现

|   类名   |          描述           |
| :----: | :-------------------: |
| Tuple  | 元组抽象，实现元组数据结构已经常用操作方法 |
| Tuple0 |      空元组，不包含任何元素      |
| Tuple1 |      只包含1个元素的元组       |
| Tuple2 |      只包含2个元素的元组       |
| Tuple3 |      只包含3个元素的元组       |
| Tuple4 |      只包含4个元素的元组       |
| Tuple5 |      只包含5个元素的元组       |
| TupleN |       包含N个元素的元组       |



## 元组操作

|      操作API       |               说明                |
| :--------------: | :-----------------------------: |
|       add        |              元组合并               |
|     foreach      |              元组迭代               |
| forEachWithIndex |             元组带序号迭代             |
|       swap       |              元组反转               |
|      toList      |             元组转成列表              |
|       get        |            获取元组某一个元素            |
|     contains     |           元组中是否包含某个元素           |
|     subTuple     |              截取子元组              |
|      equals      |          比较2个元组内容是否相同           |
|     toString     |    输出字符串表示的元组，如: (123, 456)     |
|      repeat      |           重复元组内的所有元素            |
|      stream      |      将元组转换成流，类似List.stream      |
|  parallelStream  | 将元组转换成并行流，类似List.parallelStream |

## 样例
```java
//创建元组时，明确知道个数，可以优先使用Tuple0-Tuple4，获取元素API更加友好
Tuple2 tuple2 = Tuple2.with("test", 123);
log.debug("first:{}", tuple2.first);//test
log.debug("second:{}", tuple2.second);//123
```


``` java
//toString
TupleN tuple = TupleN.with("hello", 123, true, 186.5);
log.debug("toString:{}", tuple.toString());//(hello, 123, true, 186.5)
```

``` java
//元组遍历
TupleN tuple = TupleN.with("hello", 123, true, 186.5, null);
tuple.forEach(o -> log.debug(Objects.toString(o)));
```

```java
//元组合并
Tuple1 tuple1 = Tuple1.with("hello");
Tuple2 tuple2 = Tuple2.with("world", "!");
Tuple3 tuple3 = Tuple3.with(1, 2, 3);
log.debug("add:{}", tuple1.add(tuple2).toString());//(hello, world, !)
log.debug("add:{}", tuple1.add(tuple2, tuple3).toString());//(hello, world, !, 1, 2, 3)
```

```java
//元组翻转
TupleN tuple = TupleN.with("hello", 123, true, 186.5);
log.debug("swap:{}", tuple.swap().toString());//(186.5, true, 123, hello)
```

```java
//元组重复
Tuple2 tuple2 = Tuple2.with("a", "b");
log.debug("repeat:{}", tuple2.repeat(3).toString());//(a, b, a, b, a, b)
```

``` java
//截取子元组
TupleN tupleN = TupleN.with(0, 1, 2, 3, 4, 5, 6);
log.debug("sub:{}", tupleN.subTuple(0, 3).toString());//(0, 1, 2, 3)
```

```java
//转换成流
TupleN tupleN = TupleN.with("hello", 123, true, null, 186.5);
tupleN.stream().forEach(o -> log.debug("元素:{}", o));
```



## 引入(要求jdk8)

```xml
<dependency>
     <groupId>com.github.sd4324530</groupId>
     <artifactId>JTuple</artifactId>
     <version>1.0.0</version>
</dependency>
```


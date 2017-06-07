# JTuple

java语言版本的`元组`数据类型，实现了元组类型的特性（`不可变`、 `可迭代`）以及常用操作方法

**轻量级，无依赖，线程安全**



## 主要实现

| 类名     | 描述                    |
| ------ | --------------------- |
| Tuple  | 元组抽象，实现元组数据结构已经常用操作方法 |
| Tuple0 | 空元组，不包含任何元素           |
| Tuple1 | 只包含1个元素的元组            |
| Tuple2 | 只包含2个元素的元组            |
| Tuple3 | 只包含3个元素的元组            |
| Tuple4 | 只包含4个元素的元组            |
| TupleN | 包含N个元素的元组             |



## 元组操作

| 操作API            | 说明                       |
| ---------------- | ------------------------ |
| add              | 元组合并                     |
| foreach          | 元组迭代                     |
| forEachWithIndex | 元组带序号迭代                  |
| swap             | 元组反转                     |
| toList           | 元组转成列表                   |
| get              | 获取元组某一个元素                |
| contains         | 元组中是否包含某个元素              |
| subTuple         | 截取子元组                    |
| equals           | 比较2个元组内容是否相同             |
| toString         | 输出字符串表示的元组，如: (123,456) |
| repeat           | 重复元组内的所有元素               |
|                  |                          |

## 样例
```java
Tuple2 tuple2 = Tuple2.with("test", 123);
log.debug("first:{}", tuple2.first);//test
log.debug("second:{}", tuple2.second);//123
```


``` java
TupleN tuple = TupleN.with("hello", 123, true, 186.5);
log.debug("toString:{}", tuple.toString());//(hello, 123, true, 186.5)
```

```java
Tuple1 tuple1 = Tuple1.with("hello");
Tuple2 tuple2 = Tuple2.with("world", "!");
Tuple3 tuple3 = Tuple3.with(1, 2, 3);
log.debug("add:{}", tuple1.add(tuple2).toString());//(hello, world, !)
log.debug("add:{}", tuple1.add(tuple2, tuple3).toString());//(hello, world, !, 1, 2, 3)
```

```java
TupleN tuple = TupleN.with("hello", 123, true, 186.5);
log.debug("swap:{}", tuple.swap().toString());//(186.5, true, 123, hello)
```

```java
Tuple2 tuple2 = Tuple2.with("a", "b");
log.debug("repeat:{}", tuple2.repeat(3).toString());//(a, b, a, b, a, b)
```



## 引入(要求jdk8)

```xml
<dependency>
     <groupId>com.github.sd4324530</groupId>
     <artifactId>JTuple</artifactId>
     <version>1.0.0</version>
</dependency>
```


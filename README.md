# JTuple

java语言版本的`元组`数据类型，实现了元组类型的特性以及常用操作方法

`add` `forEach` `forEachWithIndex` `swap` `toList` `get` `contains` `subTuple` `equals` `toString` `repeat`



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



## 样例

``` java
TupleN tuple = TupleN.with("hello", 123, true, 186.5);
log.debug("toString:{}", tuple.toString());
```

```java
Tuple1 tuple1 = Tuple1.with("hello");
Tuple2 tuple2 = Tuple2.with("world", "!");
log.debug("add:{}", tuple1.add(tuple2).toString());
```

```java
TupleN tuple = TupleN.with("hello", 123, true, 186.5);
log.debug("swap:{}", tuple.swap().toString());
```

```java
Tuple2 tuple2 = Tuple2.with("a", "b");
log.debug("repeat2:{}", tuple2.repeat(3).toString());
```



## 引入(要求jdk8)

```xml
<dependency>
     <groupId>com.github.sd4324530</groupId>
     <artifactId>JTuple</artifactId>
     <version>1.0</version>
</dependency>
```


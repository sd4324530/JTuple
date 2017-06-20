# JTuple

[![Build Status](https://api.travis-ci.org/sd4324530/JTuple.png?branch=master)](https://travis-ci.org/sd4324530/JTuple)
[![@peiyu on weibo](https://img.shields.io/badge/weibo-%40peiyu-red.svg)](http://weibo.com/1728407960)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.sd4324530/JTuple/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.sd4324530/JTuple)
[![Circle CI](https://circleci.com/gh/sd4324530/JTuple/tree/master.svg?style=svg)](https://circleci.com/gh/sd4324530/JTuple/tree/master)
[![codecov](https://codecov.io/gh/sd4324530/JTuple/branch/master/graph/badge.svg)](https://codecov.io/gh/sd4324530/JTuple)
[![Hex.pm](https://img.shields.io/hexpm/l/plug.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

java语言版本的`元组`数据类型，实现了元组类型的特性（`不可变`、 `可迭代`）以及常用操作方法

**轻量级，无依赖，线程安全**



##  元组的意义

**元组最重要的意义是用来实现多值返现。** 很多时候我们需要返回一组值，更可怕的是这组值的类型可能并不完全一样，比如http请求时，有请求的返回码（int）以及响应报文（String）

对于java人员来说，遇到这种情况时，一般的解决方案是编写一个类，类里只有2个属性，分别是以上2个，然后返回给调用者。是不是有种胸闷的感觉。折腾，造孽啊

或者就返回一个列表，但是因为类型不统一，只能用`List<Object>`，后续处理的代码的可读性会很差，我相信任何一个技术水平过关或者有职业操守的程序员都不会这么做

元组的出现，就是为了解决这种情况的，很多年轻的语言（`Python`, `Scala`...）都内置了元组，本项目就是让Java开发人员也可以享受到元组带来的编程时的便捷和快乐

## 主要实现

|   类名   |          描述           |
| :----: | :-------------------: |
| Tuple  | 元组抽象，实现元组数据结构以及常用操作方法 |
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
|       swap       |              元组翻转               |
|     toArray      |             元组转成数组              |
|      toList      |             元组转成列表              |
|       get        |            获取元组某一个元素            |
|     contains     |           元组中是否包含某个元素           |
|     subTuple     |              截取子元组              |
|      equals      |          比较2个元组内容是否相同           |
|     toString     |    输出字符串表示的元组，如: (123, 456)     |
|      repeat      |           重复元组内的所有元素            |
|      stream      |      将元组转换成流，类似List.stream      |
|  parallelStream  | 将元组转换成并行流，类似List.parallelStream |
|       sort       |          将元组列表（数组）进行排序          |

## API使用样例
```java
//创建元组时，明确知道个数，可以优先使用Tuple0-Tuple5，获取元素API更加友好
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

```java
//元组列表排序
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
```

```java
//元组数组排序
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
```





## 元组使用场景样例

1. http请求封装

   ```java
   public class HttpKit {

       /**
        * http get 请求
        *
        * @param url 请求url
        * @return 请求结果元组，第一个元素为请求返回码，第二个参数为返回内容，第三个参数为请求失败时的异常
        */
       public Tuple3<Integer, String, Exception> get(String url) {
           //发送请求，解析结果
           return null;
       }
   }
   ```

   ​

2. 数据库操作封装

   ```java
   public class DbKit {

       /**
        * 执行查询sql
        *
        * @param sql 查询sql
        * @return 执行结果元组，第一个元素用来判断执行是否出现异常，如果为null，则表示成功；第二个参数为查询结果
        */
       public Tuple2<Exception, List<Object>> query(String sql) {
           try (Connection connection = getConn(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {
               List<Object> data = handleResult(resultSet);
               return Tuple2.with(null, data);
           } catch (Exception e) {
               return Tuple2.with(e, null);
           }
       }
   }
   ```

## 引入(jdk >= 1.8)

```xml
<dependency>
     <groupId>com.github.sd4324530</groupId>
     <artifactId>JTuple</artifactId>
     <version>1.1.1</version>
</dependency>
```


# 150：实例化 Class 类的 5 种方法

<img src="http://image.renkaigis.com/keepcoding/2017111601.png">

**运行结果：**

```java
第 1 种方法：Object.getClass()
java.util.Date
第 2 种方法：.class 语法
boolean
第 3 种方法：Class.forName()
java.lang.String
第 4 种方法：包装类的 TYPE 域
double
```

# 151：获得 Class 对象表示实体的名称

<img src="http://image.renkaigis.com/keepcoding/2017111602.png">

**运行结果：**

```java
非数组引用类型的名称：java.util.Date
基本类型的名称：byte
一维引用类型数组：[Ljava.util.Date;
二维基本类型数组：[[I
```


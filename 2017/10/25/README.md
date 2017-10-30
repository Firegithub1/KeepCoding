# transient 关键字的应用

- 在保存对象的时候，会将对象的状态也一并保存。然而有些状态却是不应该被保存的，如表示密码的域。此时可以使用 transient 关键字来修饰不想保存的域。

**关键技术：**

transient 关键字用来防止序列化域。如果一个引用类型被 transient 修饰，则其反序列化的结果是 null。如果一个基本类型被 transient 修饰，则其反序列化的结果是 0。如果域的引用类型是不可序列化的类，则也应该使用 transient 修饰，它在序列化时会被直接跳过。

运行结果：

```java
输出原始对象的信息：
用户名：mingrisoft，密码：mr
输出克隆对象的信息：
用户名：mingrisoft，密码：null
```


# 使用 sort() 方法排序（Arrays.sort()）

- 在对对象数组进行排序时，有很方法，最简单的就是使用 Arrays 类的 sort() 方法。直接将需要排序的数组作为参数传递给该方法即可。但是，使用这种方式排序的对象，类必须实现了 Comparable 接口。在该接口中定义了如何比较两个对象，这是排序的基础。

**关键技术：**

接口主要用来描述类所具有的功能，它并不关心类如何实现这个功能。一个类可以实现任意多个接口，这点弥补了单继承的缺陷。在需要接口的地方，可以使用实现了该接口的对象。

Comparable 接口的定义如下：

```java
public interface Comparable<T>{
    int compareTo(T other);
}
```

如果一个类要实现这个接口，可以使用如下语句声明：

```java
public class Employee implements Comparable<Employee>{}
```

在 Employee 中必须要实现接口中定义的 compareTo() 方法。

运行结果：

```java
排序前：
编号：3，姓名：Java，年龄：1
编号：2，姓名：C++，年龄：2
编号：1，姓名：JavaScript，年龄：3
排序后：
编号：1，姓名：JavaScript，年龄：3
编号：2，姓名：C++，年龄：2
编号：3，姓名：Java，年龄：1
```
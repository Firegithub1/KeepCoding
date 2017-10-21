# 简化 toString() 方法的重写（ToStringBuilder 类）

运行结果：

```java
猫咪 1 号：Cat5@3feba861[
  Java
  12
  21.0
  java.awt.Color[r=0,g=0,b=0]
]
猫咪 2 号：Cat5@5b480cf9[
  C++
  12
  21.0
  java.awt.Color[r=255,g=255,b=255]
]
猫咪 3 号：Cat5@6f496d9f[
  Java
  12
  21.0
  java.awt.Color[r=0,g=0,b=0]
]
```

# Java对象的假克隆（错误的克隆方法）

运行结果：

```java
克隆之前：
员工 1 的信息：
姓名：Java，年龄：12
克隆之后：
员工 2 的信息：
姓名：hahah，年龄：113
员工 1 的信息：
姓名：hahah，年龄：113
```

**注意：**当修改 employee2 的域时，employee1 的域也被修改了，因此是假克隆。

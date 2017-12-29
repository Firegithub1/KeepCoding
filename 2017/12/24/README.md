# 229：简化文件（夹）复制（Commons IO 组件简介）

- **不懂运行的结果为什么打印了两遍，找不到原因。**

<img src="http://image.renkaigis.com/keepcoding/2017122401.png">

**运行结果：**

```java
复制之前文件夹中的文件：
d:\desktop\Java4\commons-dbutils-1.3.jar
d:\desktop\Java4\commons-io-1.4.jar
d:\desktop\Java4\commons-math-2.1.jar
d:\desktop\Java4\mysql-connector-java-5.1.6-bin.jar

复制之后文件夹中的文件：
d:\desktop\Java4\commons-dbutils-1.3.jar
d:\desktop\Java4\commons-io-1.4.jar
d:\desktop\Java4\commons-math-2.1.jar
d:\desktop\Java4\mysql-connector-java-5.1.6-bin.jar
d:\desktop\Java4\commons-dbutils-1.3.jar
d:\desktop\Java4\commons-io-1.4.jar
d:\desktop\Java4\commons-math-2.1.jar
d:\desktop\Java4\mysql-connector-java-5.1.6-bin.jar
```

# 230：简化文件（夹）排序（Commons IO 组件简介）

<img src="http://image.renkaigis.com/keepcoding/2017122402.png">

**运行结果：**

```java
文件（夹）的原始排序：
commons-dbutils-1.3.jar	
commons-io-1.4.jar	
commons-math-2.1.jar	
Java6	
mysql-connector-java-5.1.6-bin.jar	

文件（夹）的 SIZE_COMPARATOR 排序：
Java6	
commons-dbutils-1.3.jar	
commons-io-1.4.jar	
mysql-connector-java-5.1.6-bin.jar	
commons-math-2.1.jar	

文件（夹）的 SIZE_REVERSE 排序：
commons-math-2.1.jar	
mysql-connector-java-5.1.6-bin.jar	
commons-io-1.4.jar	
commons-dbutils-1.3.jar	
Java6	

文件（夹）的 SIZE_SUMDIR_COMPARATOR 排序：
Java6	
commons-dbutils-1.3.jar	
commons-io-1.4.jar	
mysql-connector-java-5.1.6-bin.jar	
commons-math-2.1.jar	

文件（夹）的 SIZE_SUMDIR_REVERSE 排序：
commons-math-2.1.jar	
mysql-connector-java-5.1.6-bin.jar	
commons-io-1.4.jar	
commons-dbutils-1.3.jar	
Java6
```


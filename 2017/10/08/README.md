# 将字符串转换成整数（Integer.parseInt(s)）

*日常吐槽，这界面真心丑！！！*

## 关键技术：

Integer 类是基本类型 int 类型的包装类，可以将基本类型转换成引用类型。

该类还提供了将字符串转换成 int 类型的静态方法，声明如下：

```java
public static int parseInt(String s) throws NumberFormatException
``` 

运行结果：

<img src="http://image.renkaigis.com/keepcoding/2017100801.png">

# 整数进制转换器

## Integer 类常用方法

| 方法名 | 作用 |
| --- | --- |
| toBinaryString(int i) | 返回指定数字 i 的二进制 |
| toOctalString(int i) | 返回指定数字 i 的八进制 |
| toHexString(int i) | 返回指定数字 i 的十六进制 |

运行结果：

<img src="http://image.renkaigis.com/keepcoding/2017100802.png">
<img src="http://image.renkaigis.com/keepcoding/2017100803.png">
<img src="http://image.renkaigis.com/keepcoding/2017100804.png">
<img src="http://image.renkaigis.com/keepcoding/2017100805.png">
# 170：方法中抛出异常

<img src="http://image.renkaigis.com/keepcoding/2017112501.png">

**运行结果：**

```java
Exception in thread "main" java.lang.UnsupportedOperationException: 方法尚未实现
	at ThrowException1.throwException1(ThrowException1.java:5)
	at ThrowException1.main(ThrowException1.java:9)
```

# 171：方法上抛出异常

<img src="http://image.renkaigis.com/keepcoding/2017112502.png">

**运行结果：**

```java
java.lang.ClassNotFoundException: con.mysql.jdbc.Driver
	at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
	at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:335)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
	at java.lang.Class.forName0(Native Method)
	at java.lang.Class.forName(Class.java:264)
	at ThrowException2.throwsException(ThrowException2.java:3)
	at ThrowException2.main(ThrowException2.java:8)
```

# 172：自定义异常类

<img src="http://image.renkaigis.com/keepcoding/2017112503.png">

**运行结果：**

```java
array[4]/4=1
array[3]/3=1
array[2]/2=2
array[1]/1=5
Exception in thread "main" DivideZeroException: 除零异常
	at ThrowException3.main(ThrowException3.java:9)
```


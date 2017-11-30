# 173：捕获单个异常

<img src="http://image.renkaigis.com/keepcoding/2017112601.png">

**运行结果：**

```java
java.lang.ClassNotFoundException: 
	at java.lang.Class.forName0(Native Method)
	at java.lang.Class.forName(Class.java:264)
	at CatchException.main(CatchException.java:5)
进入 try 块
进入 catch 块
离开 catch 块
进入 finally 块
```

# 174：捕获多个异常

<img src="http://image.renkaigis.com/keepcoding/2017112602.png">

**运行结果：**

```java
java.lang.ClassNotFoundException: com.mysql.jdbc.Driver
	at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
	at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:335)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
	at java.lang.Class.forName0(Native Method)
	at java.lang.Class.forName(Class.java:264)
	at CatchExceptions.getConnection(CatchExceptions.java:14)
	at CatchExceptions.main(CatchExceptions.java:26)
```


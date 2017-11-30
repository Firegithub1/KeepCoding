# 160：利用反射重写 toString() 方法

<img src="http://image.renkaigis.com/keepcoding/2017112101.png">

运行结果：

```java
包名：java.lang	类名：Object
公共的构造方法：
public java.lang.Object()
公共域：
公共方法：
public final void java.lang.Object.wait() throws java.lang.InterruptedException
public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException
public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException
public boolean java.lang.Object.equals(java.lang.Object)
public java.lang.String java.lang.Object.toString()
public native int java.lang.Object.hashCode()
public final native java.lang.Class<?> java.lang.Object.getClass()
public final native void java.lang.Object.notify()
public final native void java.lang.Object.notifyAll()
```

# 161：反射与动态代理

<img src="http://image.renkaigis.com/keepcoding/2017112102.png">

运行结果：

```java
不使用代理方式：
销售人员在卖房子
使用代理方式：
代理人员在卖房子
```


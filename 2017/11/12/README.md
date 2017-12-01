# 143：使用线程池优化多线程编程

**运行结果：**

```java
独立运行 1000 个线程所占用的内存：1363536字节
独立创建 1000 个线程所消耗的时间：34毫秒
使用连接池运行 1000 个线程所占用的内存：1022400字节
使用连接池创建 1000 个线程所消耗的时间：5毫秒
```

# 144：Object 类中线程相关的方法

Object 类中 notify()、notifyAll() 和 wait() 方法是用来控制线程的运行状态。其中 wait() 方法有 3 种重载形式，这些方法的说明如下表。

| 方法名 | 作用 |
| :---: | --- |
| notify() | 唤醒在此对象监视器上等待的单个线程 |
| notifyAll() | 唤醒在此对象监视器上等待的所有线程 |
| wait() | 在其他线程调用此对象的 notify() 方法或 notifyAll() 方法前，导致当前线程等待 |
| wait(long timeout) | 在其他线程调用此对象 notify() 方法或 notifyAll() 方法，或者超过指定的时间量前，导致当前线程等待 |
| wait(long timeout,int nanos) | 在其他线程调用此对象的 notify() 方法或 notifyAll() 方法，或者其他某个线程中断当前线程，或者已超过某个实际时间量前，导致当前线程等待 |

**注意：** 以上方法均在 Object 类中，并且都是 final 的。不要把它们和 Thread 类混淆。

wait()、notify() 和 notifyAll() 这 3 个方法要与 synchronized 关键字一起使用，并且他们都是与对象监视器有关的。当前线程必须要拥有此对象监视器，否则会出现 IllegalMonitorStateException 异常。

**运行结果：**

<img src="http://image.renkaigis.com/keepcoding/2017111201.png">


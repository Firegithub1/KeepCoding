# 141：使用阻塞队列实现线程同步

LinkedBlockingQueue<E> 是一个基于已链接节点的、范围任意的 blocking queue 。此队列按 FIFO（先进先出）排序元素。队列的头部是在队列中时间最长的元素。队列的尾部是在队列中时间最短的元素。新元素插入到队列的尾部，并且队列获取操作会获得位于队列头部的元素。链接队列的吞吐量通常要高于基于数组的队列，但是在大多数并发应用程序中，其可预知的性能要低。 

LinkedBlockingQueue 类的常用方法如下表：

| 方法名 | 作用 |
| :---: | --- |
| LinkedBlockingQueue() | 创建一个容量为 Integer.MAX_VALUE 的 LinkedBlockingQueue |
| put(E e) | 在队尾添加一个元素，如果队列满则阻塞 |
| size() | 返回队列中的元素个数 |
| take() | 移除并返回队头元素，如果队列空则阻塞 |

运行结果：

<img src="http://image.renkaigis.com/keepcoding/2017111001.png">

BlockingQueue<E> 接口定义了阻塞队列的常用方法。例如，对于添加元素有 add()、offer() 和 put() 3种方法。当队列满时，add() 方法会抛出异常，offer() 方法会返回 false，put() 方法会阻塞。根据自己的需求选择适当的方法。



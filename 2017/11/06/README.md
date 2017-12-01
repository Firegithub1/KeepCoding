# 使用代码块实现线程同步

**运行结果：**

<img src="http://image.renkaigis.com/keepcoding/2017110601.png">

# 使用特殊域变量实现线程同步（volatile）

volatile 关键字为域变量的访问提供了一种免锁机制。使用 volatile 修饰域相当于告诉虚拟机该域可能会被其他线程更新。因此每次使用该域就要重新计算，而不是使用寄存器中的值。volatile 不会提供任何原子操作。它也不能用来修饰 final 类型的变量。

**运行结果：**

<img src="http://image.renkaigis.com/keepcoding/2017110602.png">


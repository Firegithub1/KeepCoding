/**
 * 140：解决线程的死锁问题
 */

public class DeadLock1 implements Runnable {
    private boolean flag;
    private static final Object o1 = new Object();
    private static final Object o2 = new Object();

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + ":flag = " + flag);
        if (flag == true) {
            synchronized (o1) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(threadName + "进入同步块 o1 准备进入 o2");
                System.out.println(threadName + "已经进入同步块 o2");
            }
        }
        if (flag == false) {
            synchronized (o2) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(threadName + "进入同步块 o2 准备进入 o1");
                synchronized (o1) {
                    System.out.println(threadName + "已经进入同步块 o1");
                }
            }
        }
    }

    public static void main(String[] args) {
        DeadLock1 d1 = new DeadLock1();
        DeadLock1 d2 = new DeadLock1();
        d1.flag = true;
        d2.flag = false;
        new Thread(d1).start();
        new Thread(d2).start();
    }
}
// 对于 4 个同步块，去掉任何一个就可以解决死锁问题。
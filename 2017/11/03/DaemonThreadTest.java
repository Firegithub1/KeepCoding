/**
 * 128：使用守护线程（Daemon Thread）
 */

public class DaemonThreadTest {
    public static void main(String[] args) {
        Thread userThread = new Thread(new Worker()); // 创建用户线程
        Thread daemonThread = new Thread(new Timer()); // 创建守护线程
        daemonThread.setDaemon(true); // 设置守护线程
        userThread.start(); // 启动用户线程
        daemonThread.start(); // 启动守护线程
        // 注意：一定要在线程运行以前也就是运行 Thread 类的 start 方法之前设置一个线程为守护线程。
    }
}

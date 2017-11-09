/**
 * 131：线程的插队运行（join()）
 */

public class JoinThread {
    public static void main(String[] args) {
        Thread thread = new Thread(new EmergencyThread()); // 创建新线程
        thread.start(); // 运行新线程
        for (int i = 1; i < 6; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("正常情况：" + i + "号车出发！");
            try {
                thread.join(); // 使用 join() 方法让新创建的线程优先完成
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

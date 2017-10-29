/**
 * 120：局部内部类的简单应用
 */

import javax.swing.*;

public class Test19 {
    public static void main(String[] args) {
        AlarmClock clock = new AlarmClock(1000, true); // 创建 AlarmClock 对象
        clock.start();
        JOptionPane.showMessageDialog(null, "是否退出？");
        System.exit(0); // 退出程序
    }
}

/**
 * 299：震动效果的提示信息（顶层容器的应用）
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ShakeDialog {
    private JDialog dialog;
    private Point start; // 保存对话框的初始位置
    private Timer shakeTimer;

    public ShakeDialog(JDialog dialog) { // 在构造方法中获得对话框对象
        this.dialog = dialog;
    }

    public void startShake() { // 开始震动方法
        final long startTime = System.currentTimeMillis(); // 获得程序运行的起始时间
        start = dialog.getLocation(); // 获得对话框的初始位置
        shakeTimer = new Timer(10, new ActionListener() { // 每隔 10 毫秒启动改变对话框坐标事件
            @Override
            public void actionPerformed(ActionEvent e) {
                long elapsed = System.currentTimeMillis() - startTime; // 获得程序运行的时间
                Random random = new Random(elapsed); // 以运行时间为种子创建随机数对象
                int change = random.nextInt(50); // 获得一个小于 50 的随机数整数
                dialog.setLocation(start.x + change, start.y + change); // 随机改变坐标
                if (elapsed >= 1000) { // 如果程序运行时间大于 1 秒钟则停止
                    stopShake();
                }
            }
        });
        shakeTimer.start();
    }

    public void stopShake() { // 停止震动方法
        shakeTimer.stop(); // 停止 Timer
        dialog.setLocation(start); // 恢复对话框的坐标
        dialog.repaint(); // 重新绘制对话框
    }

    public static void main(String[] args) { // 测试方法
        JOptionPane pane = new JOptionPane("Java 编程词典真好用！",JOptionPane.WARNING_MESSAGE);
        JDialog d = pane.createDialog(null, "震动效果的对话框"); // 获得对话框对象
        ShakeDialog sd = new ShakeDialog(d);
        d.pack(); // 按对话框内的控件来绘制对话框
        d.setModal(false); // 关闭模态
        d.setVisible(true); // 设为可见
        sd.startShake(); // 开始震动
    }
}

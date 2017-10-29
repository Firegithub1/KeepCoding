import com.sun.org.apache.xpath.internal.SourceTree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AlarmClock {
    private int delay; // 表示延迟时间
    private boolean flag; // 表示是否要发出声音

    public AlarmClock(int delay, boolean flag) { // 使用构造方法初始化各个域
        this.delay = delay;
        this.flag = flag;
    }

    public void start() {
        class Printer implements ActionListener { // 定义内部类实现动作监听接口
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat format = new SimpleDateFormat("k:m:s"); // 定义时间的格式
                String result = format.format(new Date()); // 获得当前的时间
                System.out.println("当前的是时间是：" + result); // 显示当前的时间
                if (flag) { // 根据 flag 来决定是否要发出声音
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        }
        new Timer(delay, new Printer()).start(); // 创建 Timer 对象并启动
    }
}

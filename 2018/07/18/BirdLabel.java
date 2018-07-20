import java.awt.Container;
import java.awt.event.*;

import javax.swing.*;

/**
 * @author
 */
public class BirdLabel extends JLabel implements Runnable {
    /**
     * 控件的控件事件监听器
     */
    private final class ComponentAction extends ComponentAdapter {
        public void componentResized(final ComponentEvent e) {
            thread.start();// 线程启动
        }
    }

    /**
     * 控件的鼠标事件监听器
     *
     */
    private final class MouseAction extends MouseAdapter {
        public void mousePressed(final MouseEvent e) {
            if (!MainFrame2.readyAmmo())// 如果子弹没有准备好
                return;// 什么也不做
            MainFrame2.useAmmo();// 消耗子弹
            appScore();// 加分
            destory();// 销毁本组件
        }
    }

    // 随机生成线程的休眠时间，即控制小鸟移动速度
    private int sleepTime = (int) (Math.random() * 300) + 5;
    private int y = 100;
    private Thread thread;// 将线程作为成员变量
    private Container parent;
    private int score = 15;// 该类角色对应的分数

    /**
     * 构造方法
     */
    public BirdLabel() {
        super();
        // 创建小鸟图标对象
        ImageIcon icon = new ImageIcon(getClass().getResource(
                "image/bird.gif"));
        setIcon(icon);// 设置控件图标
        addMouseListener(new MouseAction());// 添加鼠标事件监听器
        // 添加控件事件监听器
        addComponentListener(new ComponentAction());
        thread = new Thread(this);// 创建线程对象
    }

    @Override
    public void run() {
        parent = null;
        int width = 0;
        try {
            while (width <= 0 || parent == null) {
                if (parent == null){
                    parent = getParent();// 获取父容器
                } else {
                    width = parent.getWidth();// 获取父容器的宽度
                }
                Thread.sleep(10);
            }
            for (int i = width; i > 0 && parent != null; i -= 8) {
                setLocation(i, y);// 从右向左移动本组件位置
                Thread.sleep(sleepTime);// 休眠片刻
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (parent != null) {
            MainFrame2.appScore(-score * 10); // 自然销毁将扣分
        }
        destory();// 移动完毕，销毁本组件
    }

    /**
     * 从容器移除本组件的方法
     */
    public void destory() {
        if (parent == null)
            return;
        parent.remove(this);// 从父容器中移除本逐渐
        parent.repaint();
        parent = null; // 通过该语句终止线程循环
    }

    /**
     * 加分的方法
     */
    private void appScore() {
        MainFrame2.appScore(15);
    }
}

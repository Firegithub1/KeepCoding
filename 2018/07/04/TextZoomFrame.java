/**
 * 065：文字缩放（文字动画）
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TextZoomFrame extends JFrame {
    private Image img = null; // 声明图像对象
    private TextZoomPanel textZoomPanel = null; // 声明图像面板对象

    public static void main(String args[]) {
        TextZoomFrame frame = new TextZoomFrame();
        frame.setVisible(true);
    }

    public TextZoomFrame() {
        super();
        URL imgUrl = TextZoomFrame.class.getResource("image.jpg");// 获取图片资源的路径
        img = Toolkit.getDefaultToolkit().getImage(imgUrl); // 获取图像资源
        textZoomPanel = new TextZoomPanel(); // 创建图像面板对象
        this.setBounds(200, 160, 376, 237); // 设置窗体大小和位置
        this.add(textZoomPanel); // 在窗体上添加图像面板对象
        Thread thread = new Thread(textZoomPanel);// 创建线程对象
        thread.start();// 启动线程对象
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置窗体关闭模式
        this.setTitle("文字缩放特效"); // 设置窗体标题
    }

    // 创建面板类
    class TextZoomPanel extends JPanel implements Runnable {
        boolean flag = false;// 定义标记变量，用于控制x的值
        int x = 12;// 定义表示字体大小的变量x
        Font font = new Font("华文楷体", Font.BOLD, x);// 创建字体对象
        public void paint(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;// 获得Graphics2D对象
            g2.drawImage(img, 0, 0, getWidth(), getHeight(), this);// 绘制图像
            g2.setFont(font);// 指定字体
            g2.setColor(Color.RED);// 指定颜色
            g2.drawString("编程词典", 30, 120);// 绘制文本
        }
        public void run() {
            while (true) {
                if (flag) {        // flag为true时
                    x-=1;       // x进行减1计算
                    if (x <= 12) {// x小于等于12时
                        x = 12;   // x等于12
                        flag = false;// 为flag赋值为false
                    }
                } else {// flag为false时
                    x+=1;// x进行加1计算
                    if (x >= 72) {// x大于等于72时
                        x = 72;// x等于72
                        flag = true;// 为flag赋值为true
                    }
                }
                font = new Font("华文楷体", Font.BOLD, x);// 重新创建字体对象
                repaint();// 调用paint()方法
                try {
                    Thread.sleep(50);// 休眠50毫秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

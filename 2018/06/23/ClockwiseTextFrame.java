/**
 * 045：顺时针旋转文字（文字特效）
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class ClockwiseTextFrame extends JFrame {
    private JTextField textField;
    ClockwiseTextPanel clockwiseTextPanel = new ClockwiseTextPanel(); // 创建面板类的实例

    public static void main(String args[]) { // 主方法
        ClockwiseTextFrame frame = new ClockwiseTextFrame(); // 创建窗体类的实例
        frame.setVisible(true); // 显示窗体
    }

    public ClockwiseTextFrame() {
        super(); // 调用超类的构造方法
        setTitle("顺时针旋转文字"); // 窗体标题
        setBounds(100, 100, 340, 240); // 窗体的显示位置和大小
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 窗体关闭方式
        add(clockwiseTextPanel); // 将面板类的实例添加到窗体容器中
        textField = new JTextField();
        textField.addCaretListener(new CaretListener() {
            public void caretUpdate(CaretEvent arg0) {
                String text = textField.getText();// 获取文本框字符串
                clockwiseTextPanel.setText(text);// 为面板中的text变量赋值
            }
        });
        getContentPane().add(textField, BorderLayout.SOUTH);
    }

    class ClockwiseTextPanel extends JPanel { // 创建内部面板类
        private String text;
        public ClockwiseTextPanel() {
            setOpaque(false);// 设置面板为透明
            setLayout(null);// 设置为绝对布局
        }
        public String getText() {
            return text; // 获得成员变量的值
        }
        public void setText(String text) {
            this.text = text;// 为成员变量赋值
            repaint();// 调整paint()方法
        }
        public void paint(Graphics g) {// 重写paint()方法
            Graphics2D g2 = (Graphics2D) g;// 获得Graphics2D的实例
            int width = getWidth();// 获得面板的宽度
            int height = getHeight();// 获得面板的高度
            if (text != null) {
                char[] array = text.toCharArray();// 将文本转换为字符数组
                int len = array.length * 5;// 定义圆的半径，同时可以调整文字的距离
                Font font = new Font("宋体", Font.BOLD, 22);// 创建字体
                g2.setFont(font);// 设置字体
                double angle = 0;// 定义初始角度
                for (int i = 0; i < array.length; i++) {// 遍历字符串中的字符
                    if (i == 0) {
                        g2.setColor(Color.BLUE);// 第一个字符用蓝色
                    } else {
                        g2.setColor(Color.BLACK);// 其他字符用黑色
                    }
                    int x = (int) (len * Math.sin(Math.toRadians(angle + 270)));// 计算每个文字的横坐标位置
                    int y = (int) (len * Math.cos(Math.toRadians(angle + 270)));// 计算每个文字的纵坐标位置
                    g2.drawString(array[i] + "", width / 2 + x, height / 2 - y);// 绘制字符
                    angle = angle + 360d / array.length;// 改变角度
                }
            }
        }
    }
}

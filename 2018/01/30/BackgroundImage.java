/**
 * 295：框架容器的背景图片（顶层容器的应用）
 */

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class BackgroundImage extends JFrame {
    private static final long serialVersionUID = -7734031908388740823L;

    public BackgroundImage() {
        ImageIcon background = new ImageIcon("30/mingri.jpg"); // 创建图标
        JLabel label = new JLabel(background); // 利用给定的图片创建标签
        // 将标签的大小设置成图标的大小
        label.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
        JPanel panel = (JPanel) getContentPane(); // 将内容窗格转型成面板
        panel.setOpaque(false); // 将面板设置成透明
        panel.setLayout(new FlowLayout()); // 将内容窗格的布局设置为流式布局
        panel.add(new JButton("编程词典")); // 创建一个按钮对象作为测试
        getLayeredPane().add(label, new Integer(Integer.MIN_VALUE)); // 给层级窗格增加标签
        setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置单击关闭图标时框架为关闭
        setLocationRelativeTo(null); // 将框架居中显示
        setTitle("框架容器的背景图片");
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                BackgroundImage image = new BackgroundImage(); // 在时间调度线程时运行程序
                image.setVisible(true); // 设置框架为可见
            }
        });
    }
}

/**
 * 283：窗体顶层的进度条（让窗体更有活力）
 */

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UnsupportedLookAndFeelException;

import javax.swing.UIManager;

public class LoginFrame extends JFrame {

    /**
     * 登录按钮的事件监听器
     */
    private final class LoginActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // 显示窗体的登录进度面板
            getGlassPane().setVisible(true);
        }
    }

    private static final long serialVersionUID = 1L;
    private JPanel jContentPane = null;
    private ProgressPanel panel;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton button;

    /**
     * 主类的入口方法
     *
     * @param args
     * @throws UnsupportedLookAndFeelException
     *             不支持的外观
     */
    public static void main(String[] args) {
        try {
            UIManager
                    .setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                LoginFrame loginFrame = new LoginFrame();
                loginFrame.setVisible(true);
            }
        });
    }

    /**
     * 登录窗体的构造方法
     */
    public LoginFrame() {
        super();
        // 创建登录进度面板
        panel = new ProgressPanel();
        // 把登录进度面板设置为窗体顶层
        setGlassPane(panel);
        jContentPane = new JPanel();
        this.setContentPane(jContentPane);
        jContentPane.setLayout(null);

        JLabel label = new JLabel("XX登录窗体");
        label.setFont(new Font("SansSerif", Font.PLAIN, 28));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBounds(6, 6, 386, 44);
        jContentPane.add(label);

        JLabel label_1 = new JLabel("用户名：");
        label_1.setBounds(38, 75, 55, 18);
        jContentPane.add(label_1);

        JLabel label_2 = new JLabel("密　码：");
        label_2.setBounds(38, 115, 55, 18);
        jContentPane.add(label_2);

        textField = new JTextField();
        textField.setBounds(105, 69, 168, 30);
        jContentPane.add(textField);
        textField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBounds(105, 109, 168, 30);
        jContentPane.add(passwordField);

        button = new JButton("登录");
        button.setBounds(287, 62, 90, 71);
        button.addActionListener(new LoginActionListener());
        jContentPane.add(button);
        // 设置窗体大小
        setSize(new Dimension(414, 243));
        setLocationRelativeTo(null);// 窗体居中
    }
}

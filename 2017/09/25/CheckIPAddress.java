/**
 * 071：验证 IP 地址的有效性（代码很简单，但是看不懂正则表达式！！！）
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CheckIPAddress extends JFrame {

    private JPanel contentPane;
    private JTextField textField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CheckIPAddress frame = new CheckIPAddress();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public CheckIPAddress() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 323, 127);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblIp = new JLabel("\u8BF7\u8F93\u5165 IP \u5730\u5740\uFF1A");
        lblIp.setBounds(10, 20, 102, 15);
        contentPane.add(lblIp);

        textField = new JTextField();
        textField.setBounds(111, 17, 186, 21);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton button = new JButton("\u9A8C\u8BC1");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setBounds(98, 51, 93, 23);
        contentPane.add(button);
    }

    protected void do_button_actionPerformed(ActionEvent e) {
        String text = textField.getText();
        String info = matches(text);
        JOptionPane.showMessageDialog(null, info);
    }

    public String matches(String text) {
        if (text != null && !text.isEmpty()) {
            // 定义正则表达式（看不懂！！！）
            String regex = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d[1-9])\\."
                    + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\." + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                    + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
            // 判断 IP 地址是否与正则表达式匹配
            if (text.matches(regex)) {
                return text + "\n是一个合法的 IP 地址！";
            } else {
                return text + "\n不是一个合法的 IP 地址！";
            }
        }
        return "请输入要验证的 IP 地址！";
    }
}

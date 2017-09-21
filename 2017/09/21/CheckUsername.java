/**
 * 066：判断用户名是否正确（equals）
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

public class CheckUsername extends JFrame {

    private JPanel contentPane;
    private JTextField textField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CheckUsername frame = new CheckUsername();
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
    public CheckUsername() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 293, 172);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel label = new JLabel("\u8BF7\u8F93\u5165\u4F60\u8981\u627E\u56DE\u5BC6\u7801\u7684\u7528\u6237\u540D\u79F0\u3002");
        label.setBounds(21, 20, 280, 15);
        contentPane.add(label);

        JLabel label_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
        label_1.setBounds(21, 59, 54, 15);
        contentPane.add(label_1);

        textField = new JTextField();
        textField.setBounds(75, 56, 185, 21);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton button = new JButton("\u63D0\u4EA4");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setBounds(40, 100, 93, 23);
        contentPane.add(button);

        JButton button_1 = new JButton("\u5173\u95ED");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_1_actionPerformed(e);
            }
        });
        button_1.setBounds(163, 100, 93, 23);
        contentPane.add(button_1);
    }

    protected void do_button_actionPerformed(ActionEvent e) {
        String name = textField.getText(); // 获取用户输入
        if (name.equals("admin")) { // 判断是否是管理员账号
            JOptionPane.showMessageDialog(null, "对不起，这个用户名是管理员的，不是你的");
        } else if (name.equals("renkai")) { // 判断是否注册用户
            JOptionPane.showMessageDialog(null, "该用户名对应的密码已经发送到注册时的邮箱，请查收");
        } else { // 给错误用户名的提示对话框
            JOptionPane.showMessageDialog(null, "你输入的用户名不存在，留意 Caps Lock 键是否放下！");
        }
    }

    protected void do_button_1_actionPerformed(ActionEvent e) {
        dispose(); // 关闭窗口
    }
}

/**
 * 068：判断网页请求与 FTP 请求（简单的 if…else…）
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
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RequestType extends JFrame {

    private JPanel contentPane;
    private JTextField textField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RequestType frame = new RequestType();
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
    public RequestType() {
        setTitle("\u5224\u65AD\u7F51\u9875\u8BF7\u6C42\u4E0E FTP \u8BF7\u6C42");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 130);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel label = new JLabel("\u8F93\u5165\u8BF7\u6C42\u7F51\u5740\uFF1A");
        label.setFont(new Font("宋体", Font.PLAIN, 13));
        label.setBounds(10, 14, 91, 15);
        contentPane.add(label);

        textField = new JTextField();
        textField.setBounds(101, 7, 323, 29);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton button = new JButton("\u9A8C\u8BC1");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setFont(new Font("宋体", Font.PLAIN, 13));
        button.setBounds(83, 46, 93, 35);
        contentPane.add(button);

        JButton button_1 = new JButton("\u5173\u95ED");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_1_actionPerformed(e);
            }
        });
        button_1.setFont(new Font("宋体", Font.PLAIN, 13));
        button_1.setBounds(231, 46, 93, 35);
        contentPane.add(button_1);
    }

    protected void do_button_actionPerformed(ActionEvent e) {
        String request = textField.getText();
        if (request.startsWith("http")) {
            JOptionPane.showMessageDialog(null, "您输入的是网页地址，希望浏览某个网址。");
        } else if (request.startsWith("ftp")) {
            JOptionPane.showMessageDialog(null, "您输入的是 FTP 地址，希望访问 FTP 服务器。");
        } else {
            JOptionPane.showMessageDialog(null, "您输入的请求信息不完整。");
        }
    }

    protected void do_button_1_actionPerformed(ActionEvent e) {
        dispose();
    }
}

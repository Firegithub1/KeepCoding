/**
 * 065：字符与 Unicode 码的转换（toCharArray）
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;

public class CharacterASCII extends JFrame {

    private JPanel contentPane;
    private JTextField textField_1;
    private JTextField textField_2;
    private JFormattedTextField textField_3;
    private JTextField textField_4;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CharacterASCII frame = new CharacterASCII();
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
    public CharacterASCII() {
        setTitle("\u5B57\u7B26\u4E0E Unicode \u7801\u7684\u8F6C\u6362");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 142);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        textField_1 = new JTextField();
        textField_1.setBounds(10, 33, 136, 21);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        JLabel lblUnicode = new JLabel("\u5B57\u7B26\u4E0E Unicode \u7801\u7684\u8F6C\u6362\uFF1A");
        lblUnicode.setBounds(10, 10, 210, 15);
        contentPane.add(lblUnicode);

        JButton codeButton = new JButton("\u8F6C\u4E3A Unicode");
        codeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_codeButton_actionPerformed(e);
            }
        });
        codeButton.setBounds(155, 32, 123, 23);
        contentPane.add(codeButton);

        textField_2 = new JTextField();
        textField_2.setEditable(false);
        textField_2.setColumns(10);
        textField_2.setBounds(288, 33, 136, 21);
        contentPane.add(textField_2);

        textField_3 = new JFormattedTextField(NumberFormat.getIntegerInstance());
        textField_3.setColumns(10);
        textField_3.setBounds(10, 76, 136, 21);
        contentPane.add(textField_3);

        JButton charButton = new JButton("\u8F6C\u6362\u4E3A\u5B57\u7B26");
        charButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_charButton_actionPerformed(e);
            }
        });
        charButton.setBounds(155, 75, 123, 23);
        contentPane.add(charButton);

        textField_4 = new JTextField();
        textField_4.setEditable(false);
        textField_4.setColumns(10);
        textField_4.setBounds(288, 76, 136, 21);
        contentPane.add(textField_4);
    }

    protected void do_codeButton_actionPerformed(ActionEvent e) {
        String text = textField_1.getText(); // 获取用户输入的字符串
        char[] charArray = text.toCharArray(); // 获取字符串的字符数组
        StringBuilder builder = new StringBuilder(); // 创建字符串构建器
        for (char c : charArray) { // 遍历字符数组
            builder.append((int) c + " "); // 连接各字符的编码

        }
        textField_2.setText(builder.toString()); // 结果输出到文本框
    }

    protected void do_charButton_actionPerformed(ActionEvent e) {
        Number value = (Number) textField_3.getValue(); // 获取用户输入的 Unicode 编码
        long code = value.longValue(); // 获取输入数字的 long 类型值
        textField_4.setText(((char) code) + ""); // 输出编码到文本框

    }
}

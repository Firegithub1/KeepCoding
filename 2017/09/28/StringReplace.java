/**
 * 076：批量替换某一类字符串（replace(oldStr,newStr)）
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StringReplace extends JFrame {

    private JPanel contentPane;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextArea textArea;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StringReplace frame = new StringReplace();
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
    public StringReplace() {
        setTitle("\u6279\u91CF\u66FF\u6362\u5B57\u7B26\u4E32");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        textArea = new JTextArea("明日视频学\n明日编程词典\n明日编程宝典\n明日范例大全\n明日入门模式\n明日开发经验技巧");
        textArea.setBounds(10, 10, 414, 172);
        contentPane.add(textArea);

        JLabel label = new JLabel("\u67E5\u627E\u5B57\u7B26\u4E32\uFF1A");
        label.setBounds(32, 192, 99, 15);
        contentPane.add(label);

        JLabel label_1 = new JLabel("\u66FF\u6362\u5B57\u7B26\u4E32\uFF1A");
        label_1.setBounds(32, 232, 99, 15);
        contentPane.add(label_1);

        textField_1 = new JTextField();
        textField_1.setBounds(109, 189, 200, 21);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(109, 229, 200, 21);
        contentPane.add(textField_2);

        JButton button = new JButton("\u5168\u90E8\u66FF\u6362");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setBounds(319, 228, 93, 23);
        contentPane.add(button);
    }

    protected void do_button_actionPerformed(ActionEvent e) {
        String searchStr = textField_1.getText(); // 获取搜索字符串
        String replaceStr = textField_2.getText(); // 获取替换字符串
        String text = textArea.getText(); // 获取段落文本
        String newText = text.replace(searchStr, replaceStr); // 执行替换
        textArea.setText(newText); // 替换结果显示在文本域控件
    }
}

/**
 * 054：使用 sort 方法对数组进行排序（Java 自带 Arrays 类中的 sort 方法）
 * <p>
 * 奇怪的是为什么限制文本框输入字符的 keyPressed 方法没用！！！
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SortArray extends JFrame {

    private JPanel contentPane;
    private JTextField arrayField;
    private JTextArea sortArea;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SortArray frame = new SortArray();
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
    public SortArray() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel(
                "\u8F93\u5165\u6570\u7EC4\u5185\u5BB9\uFF0C\u7A7A\u683C\u4E3A\u6570\u7EC4\u5143\u7D20\u5206\u9694\u7B26\uFF1A");
        lblNewLabel.setBounds(10, 10, 243, 15);
        contentPane.add(lblNewLabel);

        arrayField = new JTextField();
        arrayField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                do_arrayField_keyPressed(e); // 感觉这个是可有可有可无的，很奇怪！！！
            }

            @Override
            public void keyTyped(KeyEvent e) {
                char key = e.getKeyChar();
                String mask = "0123456789 " + (char) 8; // (char)8 指的是退格键
                if (mask.indexOf(key) == -1) {
                    e.consume();
                }
            }
        });
        arrayField.setBounds(10, 35, 414, 29);
        contentPane.add(arrayField);
        arrayField.setColumns(10);

        JButton button = new JButton("\u6392\u5E8F");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setBounds(174, 74, 73, 29);
        contentPane.add(button);

        sortArea = new JTextArea();
        sortArea.setBounds(10, 113, 414, 138);
        contentPane.add(sortArea);
    }

    protected void do_button_actionPerformed(ActionEvent e) {
        String text = arrayField.getText(); // 获取用户输入
        String[] arrayStr = text.split(" {1,}"); // 拆分输入为数组
        int[] array = new int[arrayStr.length]; // 创建整数类型数组
        sortArea.setText("数组原有内容：\n");
        for (String string : arrayStr) { // 输出原有数组内容
            sortArea.append(string + "  ");
        }
        for (int i = 0; i < array.length; i++) { // 初始化整型数组
            array[i] = Integer.parseInt(arrayStr[i]);
        }
        sortArea.append("\n");
        Arrays.sort(array);
        sortArea.append("数组排序后的内容：\n"); // 使用 sort() 方法对整型数组进行排序
        for (int value : array) {
            sortArea.append(value + "  "); // 输出排序后的数组内容
        }
    }

    protected void do_arrayField_keyPressed(KeyEvent e) {
        char key = e.getKeyChar(); // 获取用户按键字符
        String mask = "0123456789 " + (char) 8; // (char)8 指的是退格键 // 定义规范化字符模板
        if (mask.indexOf(key) == -1) { // 判断按键字符是否属于规范化字符范围
            e.consume(); // 取消非规范化字符的输入有效性
        }
    }
}

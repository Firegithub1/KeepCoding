/**
 * 050：使用选择排序法（**必须掌握的方法**）
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class SelectSort extends JFrame {

    private JPanel contentPane;
    private JTextArea textArea1;
    private JTextArea textArea2;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SelectSort frame = new SelectSort();
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
    public SelectSort() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 286);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        textArea1 = new JTextArea();
        textArea1.setBounds(10, 10, 414, 76);
        contentPane.add(textArea1);

        textArea2 = new JTextArea();
        textArea2.setBounds(10, 129, 414, 76);
        contentPane.add(textArea2);

        JButton button = new JButton("\u751F\u6210\u968F\u673A\u6570");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setBounds(142, 96, 121, 23);
        contentPane.add(button);

        JButton button_1 = new JButton("\u9009\u62E9\u6392\u5E8F\u6CD5");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_1_actionPerformed(e);
            }
        });
        button_1.setBounds(142, 214, 121, 23);
        contentPane.add(button_1);
    }

    private int[] array = new int[10];

    protected void do_button_actionPerformed(ActionEvent e) {
        Random random = new Random(); // 创建随机数对象
        textArea1.setText(""); // 清空文本域
        for (int i = 0; i < array.length; i++) { // 初始化数组元素
            array[i] = random.nextInt(50); // 生成50以内的随机数
            textArea1.append(array[i] + "  "); // 把数组元素显示的文本域控件中
        }
    }

    // 选择排序法
    protected void do_button_1_actionPerformed(ActionEvent e) {
        textArea2.setText(""); // 清空文本域
        int index;
        for (int i = 1; i < array.length; i++) {
            index = 0;
            for (int j = 1; j <= array.length - i; j++) {
                if (array[j] > array[index]) {
                    index = j; // 查找最大值
                }
            }
            // 交换在位置array.length-i和index(最大值)两个数
            int temp = array[array.length - i];
            array[array.length - i] = array[index];
            array[index] = temp;
        }
        for (int i = 0; i < array.length; i++) {
            textArea2.append(array[i] + "  "); // 把排序后的数组元素显示到文本域中
        }
    }
}

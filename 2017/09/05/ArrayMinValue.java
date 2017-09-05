/**
 * 042：获取一维数组最小值（用JFrame，没有再现代码！！没搞懂！）
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Arrays;

public class ArrayMinValue extends JFrame {
    
    private JPanel contentPane;
    private JTextField textField;
    private JLabel label; // 自己做时出了错，解决方法是在这里重新声明 label
    private JLabel label_1;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            UIManager
                    .setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ArrayMinValue frame = new ArrayMinValue();
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
    public ArrayMinValue() {
        setTitle("\u83B7\u53D6\u4E00\u7EF4\u6570\u7EC4\u6700\u5C0F\u503C");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 149);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        textField = new JTextField();
        textField.setBounds(6, 36, 414, 30);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JButton button = new JButton("\u8BA1\u7B97");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setBounds(16, 76, 90, 30);
        contentPane.add(button);

        // 使用Swing拖放的label是在这里声明的，将其放在外面声明即可
        label = new JLabel("\u6700\u5C0F\u503C\uFF1A");
        label.setBounds(116, 82, 304, 18);
        contentPane.add(label);

        label_1 = new JLabel(
                "\u8BF7\u5728\u6587\u672C\u6846\u4E2D\u8F93\u5165\u591A\u4E2A\u6574\u6570\uFF0C\u4EE5\u7A7A\u683C\u4E3A\u5206\u9694\u7B26\u3002\u4F8B\u5982\uFF1A3 5 2 562 125");
        label_1.setBounds(6, 6, 422, 18);
        contentPane.add(label_1);
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        String arrayStr = textField.getText().trim();
        for (int i = 0; i < arrayStr.length(); i++) {// 过滤非法字符
            char charAt = arrayStr.charAt(i);
            if (!Character.isDigit(charAt) && charAt != ' ') {
                JOptionPane.showMessageDialog(null, "输入包含非数字内容");
                textField.setText("");
                return;
            }
        }
        String[] numStrs = arrayStr.split(" {1,}");// 分割字符串
        int[] numArray = new int[numStrs.length];// 创建整数数组
        // 转换输入为整数数组
        for (int i = 0; i < numArray.length; i++) {
            numArray[i] = Integer.valueOf(numStrs[i]);
        }
        int min = numArray[0];// 创建最小数变量
        for (int j = 0; j < numArray.length; j++) {
            if (min > numArray[j]) {// 提取最小整数
                min = numArray[j];
            }
        }
        label.setText("数组中最小的数是：" + min);
    }
}

/*使用软件eclipse，插件Windows Builder设计器

自己做的时候遇到了问题，使用Swing直接拖的label声明在ArrayMinValue类中，
导致do_button_actionPerformed方法不能使用它。
只需要将label重新声明在ArrayMinValue窗体中即可。

 */

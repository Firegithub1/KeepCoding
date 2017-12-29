/**
 * 212：大乐透号码生成器（其他常用类的使用）
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class SuperFun extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 6787592245621788484L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextArea textArea;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SuperFun frame = new SuperFun();
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
    public SuperFun() {
        setTitle("\u5927\u4E50\u900F\u53F7\u7801\u751F\u6210\u5668");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);
        panel.setLayout(new GridLayout(1, 2, 5, 5));

        JLabel label = new JLabel("\u8BF7\u8F93\u5165\u53F7\u7801\u4E2A\u6570\uFF1A");
        label.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label);

        textField = new JTextField();
        textField.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        panel.add(textField);
        textField.setColumns(10);

        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        JButton button = new JButton("\u751F\u6210\u53F7\u7801");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        buttonPanel.add(button);

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        textArea = new JTextArea();
        textArea.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        scrollPane.setViewportView(textArea);
    }

    protected void do_button_actionPerformed(ActionEvent e) {
        int times = Integer.parseInt(textField.getText());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            for (int j = 0; j < 5; j++) { // 在 1-35 中间随机选择 5 个数字
                List<Integer> list = new ArrayList<>();
                for (int k = 1; k < 36; k++) {
                    list.add(k); // 将 1-35 添加到列表中
                }
                int number = list.get(new Random().nextInt(list.size())); // 随机选择一个数字
                String luckNumber = number < 10 ? "0" + number : "" + number; // 格式化数组
                sb.append(luckNumber + " "); // 向 sb 中增加数字
                list.remove(new Integer(number)); // 删除选择的数字，这样就避免了重复
            }
            sb.append("\t\t");
            for (int j = 0; j < 2; j++) {
                List<Integer> list = new ArrayList<>();
                for (int k = 1; k < 13; k++) {
                    list.add(k);
                }
                int number = list.get(new Random().nextInt(list.size()));
                String luckNumber = number < 10 ? "0" + number : "" + number;
                sb.append(luckNumber + " ");
                list.remove(new Integer(number));
            }
            sb.append("\n");
        }
        textArea.setText(sb.toString());
    }

}

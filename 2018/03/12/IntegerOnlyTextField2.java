/**
 * 370：强制输入合法的整数（其他文本控件的应用）
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import java.awt.GridLayout;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IntegerOnlyTextField2 extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = -6338040209770877326L;
    private JPanel contentPane;
    private JTextField textField;
    private JFormattedTextField formattedTextField;

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
                    IntegerOnlyTextField2 frame = new IntegerOnlyTextField2();
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
    public IntegerOnlyTextField2() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActivated(e);
            }
        });
        setTitle("\u53EA\u80FD\u8F93\u5165\u6574\u6570\u7684\u6587\u672C\u57DF");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 350, 200);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(3, 1, 5, 5));

        JPanel inputPanel = new JPanel();
        panel.add(inputPanel);

        JLabel label1 = new JLabel("\u8F93\u5165\uFF1A");
        label1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        inputPanel.add(label1);

        formattedTextField = new JFormattedTextField();
        formattedTextField.setColumns(15);
        formattedTextField.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        inputPanel.add(formattedTextField);

        JPanel outputPanel = new JPanel();
        panel.add(outputPanel);

        JLabel label2 = new JLabel("\u8F93\u51FA\uFF1A");
        label2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        outputPanel.add(label2);

        textField = new JTextField();
        textField.setEditable(false);
        textField.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        outputPanel.add(textField);
        textField.setColumns(15);

        JPanel buttonPanel = new JPanel();
        panel.add(buttonPanel);

        JButton button = new JButton("\u663E\u793A\u7ED3\u679C");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        buttonPanel.add(button);
    }

    protected void do_this_windowActivated(WindowEvent e) {
        formattedTextField.setValue(new Integer(0)); // 设置格式化文本域的初始值
        formattedTextField.setInputVerifier(new IntegerVerifier()); // 配置新的校验器
    }

    protected void do_button_actionPerformed(ActionEvent e) {
        textField.setText(formattedTextField.getValue().toString()); // 显示用户输入的值
    }

    private class IntegerVerifier extends InputVerifier {

        @Override
        public boolean verify(JComponent input) {
            JFormattedTextField field = (JFormattedTextField) input; // 强制类型转换
            return field.isEditValid(); // 使用默认的校验方式
        }
    }
}

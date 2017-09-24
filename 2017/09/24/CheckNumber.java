/**
 * 070：判断字符串是否为数字
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CheckNumber extends JFrame {

    private JPanel contentPane;
    private JTextField textField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CheckNumber frame = new CheckNumber();
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
    public CheckNumber() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 340, 130);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel label = new JLabel("\u8BF7\u8F93\u5165\u8D27\u5E01\u503C\uFF1A");
        label.setBounds(10, 26, 130, 15);
        contentPane.add(label);

        textField = new JTextField();
        textField.setBounds(101, 23, 182, 21);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel label_1 = new JLabel("\u5143");
        label_1.setBounds(293, 26, 21, 15);
        contentPane.add(label_1);

        JButton button = new JButton("\u5224\u65AD");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setBounds(121, 58, 93, 23);
        contentPane.add(button);
    }

    protected void do_button_actionPerformed(ActionEvent e) {
        String text = textField.getText();
        boolean isnum = NumberUtils.isNumber(text);
        if (isnum) {
            JOptionPane.showMessageDialog(null, "输入正确，是数字格式");

        } else {
            JOptionPane.showMessageDialog(null, "输入错误，请确认格式再输入");
        }
    }
}

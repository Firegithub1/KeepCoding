/**
 * 072：鉴别非法电话号码（正则表达式）
 */

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

public class CheckPhoneNum extends JFrame {

    private JPanel contentPane;
    private JTextField nameField;
    private JTextField ageField;
    private JTextField numField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CheckPhoneNum frame = new CheckPhoneNum();
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
    public CheckPhoneNum() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 244, 178);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel label = new JLabel("\u59D3\u540D\uFF1A");
        label.setBounds(10, 10, 54, 15);
        contentPane.add(label);

        JLabel label_1 = new JLabel("\u5E74\u9F84\uFF1A");
        label_1.setBounds(10, 45, 54, 15);
        contentPane.add(label_1);

        JLabel label_2 = new JLabel("\u7535\u8BDD\u53F7\u7801\uFF1A");
        label_2.setBounds(10, 82, 69, 15);
        contentPane.add(label_2);

        nameField = new JTextField();
        nameField.setBounds(74, 7, 129, 21);
        contentPane.add(nameField);
        nameField.setColumns(10);

        ageField = new JTextField();
        ageField.setColumns(10);
        ageField.setBounds(74, 42, 129, 21);
        contentPane.add(ageField);

        numField = new JTextField();
        numField.setColumns(10);
        numField.setBounds(74, 79, 129, 21);
        contentPane.add(numField);

        JButton button = new JButton("\u9A8C\u8BC1");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setBounds(58, 106, 93, 23);
        contentPane.add(button);
    }

    protected void do_button_actionPerformed(ActionEvent e) {
        String text = numField.getText();
        String info = check(text);
        JOptionPane.showMessageDialog(null, info);
    }

    public String check(String text) {
        if (text == null || text.isEmpty()) {
            return "请输入电话号码！";
        }
        String regex = "^\\d{3}-?\\d{8}|\\d{4}-?\\d{8}$";
        if (text.matches(regex)) {
            return text + "\n是一个合法的电话号码！";
        } else {
            return text + "\n不是一个合法的电话号码！";
        }
    }
}

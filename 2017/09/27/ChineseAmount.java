/**
 * 075：获取字符串中汉字的个数
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class ChineseAmount extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextArea textArea;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ChineseAmount frame = new ChineseAmount();
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
    public ChineseAmount() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel label = new JLabel("\u8F93\u5165\u4E00\u6BB5\u6587\u5B57\uFF1A");
        label.setBounds(10, 22, 98, 15);
        contentPane.add(label);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(107, 10, 327, 197);
        contentPane.add(scrollPane);

        textArea = new JTextArea();
        textArea.setLineWrap(true);
        scrollPane.setViewportView(textArea);

        JButton button = new JButton("\u8BA1\u7B97");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setBounds(90, 217, 93, 23);
        contentPane.add(button);

        textField = new JTextField();
        textField.setBounds(228, 217, 66, 21);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel label_1 = new JLabel("\u4E2A\u6C49\u5B57");
        label_1.setBounds(304, 221, 54, 15);
        contentPane.add(label_1);
    }

    protected void do_button_actionPerformed(ActionEvent e) {
        String text = textArea.getText();
        int amount = 0;
        for (int i = 0; i < text.length(); i++) {
            boolean matches = Pattern.matches("^[\u4E00-\u9FA5]{0,}$", "" + text.charAt(i));
            if (matches) {
                amount++;
            }
        }
        textField.setText(amount + "");
    }
}

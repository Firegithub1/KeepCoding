/**
 * 064：字符串大小写转换（ toUpper() 和 toLower() ）
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StringConvert extends JFrame {

    private JPanel contentPane;
    private JTextField inputField;
    private JTextField outputField;

    private final ButtonGroup buttonGroup = new ButtonGroup();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StringConvert frame = new StringConvert();
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
    public StringConvert() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 175);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        inputField = new JTextField();
        inputField.setBounds(10, 10, 414, 32);
        contentPane.add(inputField);
        inputField.setColumns(10);

        outputField = new JTextField();
        outputField.setColumns(10);
        outputField.setBounds(10, 94, 414, 32);
        contentPane.add(outputField);

        JButton button = new JButton("\u8F6C\u6362");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setFont(new Font("黑体", Font.PLAIN, 14));
        button.setBounds(44, 52, 93, 32);
        contentPane.add(button);

        JRadioButton radioButton = new JRadioButton("\u5927\u5199");
        radioButton.setActionCommand("大写");
        radioButton.setSelected(true);
        radioButton.setBounds(180, 57, 69, 23);
        buttonGroup.add(radioButton);
        contentPane.add(radioButton);

        JRadioButton radioButton_1 = new JRadioButton("\u5C0F\u5199");
        radioButton_1.setActionCommand("小写");
        radioButton_1.setSelected(true);
        radioButton_1.setBounds(289, 57, 69, 23);
        buttonGroup.add(radioButton_1);
        contentPane.add(radioButton_1);
    }

    protected void do_button_actionPerformed(ActionEvent e) {
        String command = buttonGroup.getSelection().getActionCommand();
        boolean upper = command.equals("大写");
        String text = inputField.getText();
        if (upper) {
            outputField.setText(text.toUpperCase());
        } else {
            outputField.setText(text.toLowerCase());
        }
    }
}

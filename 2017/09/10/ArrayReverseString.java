/**
 * 049：用数组反转字符串（renkai→iakner）
 *
 * 很不错的一个算法，值得学习~
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ArrayReverseString extends JFrame {

    private JPanel contentPane;
    private JTextField inputField;
    private JTextField outputField;
    private JTextArea infoArea;

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
                    ArrayReverseString frame = new ArrayReverseString();
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
    public ArrayReverseString() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("\u8F93\u5165\u4E00\u4E2A\u5B57\u7B26\u4E32\uFF1A");
        lblNewLabel.setBounds(10, 10, 115, 15);
        contentPane.add(lblNewLabel);

        inputField = new JTextField();
        inputField.setBounds(123, 7, 273, 30);
        contentPane.add(inputField);
        inputField.setColumns(10);

        outputField = new JTextField();
        outputField.setColumns(10);
        outputField.setBounds(123, 47, 273, 30);
        contentPane.add(outputField);

        JButton btnNewButton = new JButton("\u53CD\u8F6C");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_btnNewButton_actionPerformed(e);
            }
        });
        btnNewButton.setBounds(28, 46, 66, 23);
        contentPane.add(btnNewButton);

        infoArea = new JTextArea();
        infoArea.setBounds(10, 85, 414, 164);
        contentPane.add(infoArea);
    }

    protected void do_btnNewButton_actionPerformed(ActionEvent e) {
        String inputStr=inputField.getText();
        char[] strArray=inputStr.toCharArray();
        infoArea.setText("");
        for(int i=0;i<strArray.length/2;i++) {
            char temp=strArray[i];
            strArray[i]=strArray[strArray.length-i-1];
            strArray[strArray.length-i-1]=temp;
            infoArea.append("第"+(i+1)+"次循环：\t");
            for(char c:strArray) {
                infoArea.append(c+"");
            }
            infoArea.append("\n");
        }
        String outputStr =new String(strArray);
        outputField.setText(outputStr);
    }
}

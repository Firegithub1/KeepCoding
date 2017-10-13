/**
 * 096：ASCII编码查看器
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ASCIIViewer extends JFrame {

    private JPanel contentPane;
    private JTextField textField_1;
    private JTextField textField_2;
    private JLabel label_3;
    private JLabel label_4;
    private JLabel label_5;
    private JLabel label_6;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ASCIIViewer frame = new ASCIIViewer();
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
    public ASCIIViewer() {
        setTitle("ASCII编码查看器");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 447, 112);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel label_1 = new JLabel("输入字符：");
        label_1.setBounds(10, 10, 77, 15);
        contentPane.add(label_1);

        JLabel label_2 = new JLabel("输入数字：");
        label_2.setBounds(10, 44, 77, 15);
        contentPane.add(label_2);

        textField_1 = new JTextField();
        textField_1.setBounds(87, 7, 66, 21);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(87, 41, 66, 21);
        contentPane.add(textField_2);

        label_3 = new JLabel("转换结果：");
        label_3.setBounds(173, 10, 151, 15);
        contentPane.add(label_3);

        JButton button_1 = new JButton("转换");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_1_actionPerformed(e);
            }
        });
        button_1.setBounds(331, 6, 93, 23);
        contentPane.add(button_1);

        JButton button_2 = new JButton("转换");
        button_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_2_actionPerformed(e);
            }
        });
        button_2.setBounds(331, 40, 93, 23);
        contentPane.add(button_2);

        label_4 = new JLabel("转换结果：");
        label_4.setBounds(173, 44, 151, 15);
        contentPane.add(label_4);

        label_5 = new JLabel("");
        label_5.setBounds(238, 10, 54, 15);
        contentPane.add(label_5);

        label_6 = new JLabel("");
        label_6.setBounds(248, 44, 54, 15);
        contentPane.add(label_6);
    }

    protected void do_button_1_actionPerformed(ActionEvent e) {
        String ascii = textField_1.getText();
        int i = Character.codePointAt(ascii, 0);
        label_5.setText("" + i);
    }

    protected void do_button_2_actionPerformed(ActionEvent e) {
        String number = textField_2.getText();
        char[] a = Character.toChars(Integer.parseInt(number));
        label_6.setText(new String(a));
    }
}

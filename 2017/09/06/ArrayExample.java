/**
 * 044：利用数组随机抽取幸运观众（JFrame）
 * <p>
 * 成功实现了源代码，不容易啊！
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ArrayExample extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextArea personnelArea;
    private JTextArea resultArea;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ArrayExample frame = new ArrayExample();
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
    public ArrayExample() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 476, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("\u8F93\u5165\u5728\u573A\u89C2\u4F17\u59D3\u540D");
        lblNewLabel.setBounds(10, 10, 152, 15);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                do_textField_keyPressed(e);
            }
        });
        textField.setBounds(10, 35, 167, 21);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("\u9009\u53D6\u89C2\u4F17\u4EBA\u5458\uFF1A");
        lblNewLabel_1.setBounds(211, 10, 139, 15);
        contentPane.add(lblNewLabel_1);

        personnelArea = new JTextArea();
        personnelArea.setEditable(false);
        personnelArea.setBounds(10, 67, 167, 161);
        contentPane.add(personnelArea);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setBounds(211, 34, 167, 193);
        contentPane.add(resultArea);
        resultArea.setLineWrap(true);  // ���ڿ����ı��Զ�����

        JButton btnNewButton = new JButton("\u62BD\u53D6");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_btnNewButton_actionPerformed(e);
            }
        });
        btnNewButton.setBounds(388, 142, 62, 23);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("\u9000\u51FA");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_btnNewButton_1_actionPerformed(e);
            }
        });
        btnNewButton_1.setBounds(388, 187, 62, 23);
        contentPane.add(btnNewButton_1);
    }

    protected void do_textField_keyPressed(KeyEvent e) {
        if (e.getKeyChar() != '\n')
            return;
        String name = textField.getText();
        if (name.isEmpty())
            return;
        personnelArea.append(name + "\n");
        textField.selectAll();
    }

    protected void do_btnNewButton_actionPerformed(ActionEvent e) {
        String perstring = personnelArea.getText();
        String[] personnelArray = perstring.split("\n{1,}");
        int index = (int) (Math.random() * personnelArray.length);
        String formatArg = "本次抽取观众人员：\n\t%1$s\n恭喜%1$s成为本次观众抽奖的大奖得主。" + "\n\n我们将为%1$s颁发：\n过期的酸奶二十箱。";
        String info = String.format(formatArg, personnelArray[index]);
        resultArea.setText(info);
    }

    protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {
        dispose();
    }
}

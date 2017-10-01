/**
 * 073：根据标点符号对字符串进行分行（split（））
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JSlider;

public class StringLineWrap extends JFrame {

    private JPanel contentPane;
    private JTextArea textArea_1;
    private JTextArea textArea_2;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StringLineWrap frame = new StringLineWrap();
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
    public StringLineWrap() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 426, 439);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 84, 390, 122);
        contentPane.add(scrollPane);

        textArea_1 = new JTextArea();
        textArea_1.setLineWrap(true);
        scrollPane.setViewportView(textArea_1);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(10, 264, 390, 122);
        contentPane.add(scrollPane_1);

        textArea_2 = new JTextArea();
        scrollPane_1.setViewportView(textArea_2);

        JButton button = new JButton("\u5206\u884C\u663E\u793A");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setBounds(160, 216, 93, 34);
        contentPane.add(button);

        JLabel label = new JLabel("\u5728\u4E0B\u9762\u7684\u6587\u672C\u6846\u8F93\u5165\u5B57\u7B26\u4E32\u6BB5\u843D\uFF0C\u5176\u4E2D\u8981\u5305\u62EC\uFF08\uFF0C\uFF09\u6807\u70B9\u7B26\u53F7\u3002");
        label.setBounds(10, 10, 390, 65);
        contentPane.add(label);
    }

    protected void do_button_actionPerformed(ActionEvent e) {
        String sourceStr = textArea_1.getText();
        String[] lines = sourceStr.split(",|，");
        StringBuilder sbuilder = new StringBuilder();
        for (String line : lines) {
            sbuilder.append(line + "\n");
        }
        textArea_2.setText(sbuilder.toString());
    }
}

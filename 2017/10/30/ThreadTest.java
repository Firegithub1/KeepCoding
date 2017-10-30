/**
 * 123：新建无法返回的线程
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class ThreadTest extends JFrame {

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
                    ThreadTest frame = new ThreadTest();
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
    public ThreadTest() {
        setTitle("新建无返回值的线程");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton button_1 = new JButton("单线程程序");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_1_actionPerformed(e);
            }
        });
        button_1.setFont(new Font("宋体", Font.PLAIN, 14));
        button_1.setBounds(10, 10, 188, 38);
        contentPane.add(button_1);

        JButton button_2 = new JButton("多线程程序");
        button_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_2_actionPerformed(e);
            }
        });
        button_2.setFont(new Font("宋体", Font.PLAIN, 14));
        button_2.setBounds(236, 10, 188, 38);
        contentPane.add(button_2);

        textArea_1 = new JTextArea();
        textArea_1.setBounds(10, 58, 188, 193);
        contentPane.add(textArea_1);

        textArea_2 = new JTextArea();
        textArea_2.setBounds(236, 58, 188, 193);
        contentPane.add(textArea_2);
    }

    protected void do_button_1_actionPerformed(ActionEvent e) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            sb.append("Java 编程字典\n");
        }
        for (int i = 0; i < 5; i++) {
            sb.append("Java字符串\n");
        }
        textArea_1.setText(sb.toString());
    }

    protected void do_button_2_actionPerformed(ActionEvent e) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            new Thread() {
                public void run() {
                    sb.append("Java编程词典\n");
                };
            }.start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread() {
                public void run() {
                    sb.append("Java字符串\n");
                };
            }.start();
        }
        textArea_2.setText(sb.toString());
    }
}

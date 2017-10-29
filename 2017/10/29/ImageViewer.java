/**
 * 121：匿名内部类的简单应用
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class ImageViewer extends JFrame {

    private JPanel contentPane;
    private JLabel label;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ImageViewer frame = new ImageViewer();
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
    public ImageViewer() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 359, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton button_1 = new JButton("图片1"); // 创建按钮
        button_1.addActionListener(new ActionListener() { // 为按钮增加监听器
            public void actionPerformed(ActionEvent e) {
                label.setIcon(new ImageIcon("29/images/1.png")); // 在标签中显示图片
            }
        });
        button_1.setBounds(10, 10, 93, 23);
        contentPane.add(button_1);

        JButton button_2 = new JButton("图片2");
        button_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setIcon(new ImageIcon("29/images/2.png"));
            }
        });
        button_2.setBounds(126, 10, 93, 23);
        contentPane.add(button_2);

        JButton button_3 = new JButton("图片3");
        button_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setIcon(new ImageIcon("29/images/3.png"));
            }
        });
        button_3.setBounds(241, 10, 93, 23);
        contentPane.add(button_3);

        JButton button_4 = new JButton("图片4");
        button_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setIcon(new ImageIcon("29/images/4.png"));
            }
        });
        button_4.setBounds(10, 43, 93, 23);
        contentPane.add(button_4);

        JButton button_5 = new JButton("图片5");
        button_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setIcon(new ImageIcon("29/images/5.png"));
            }
        });
        button_5.setBounds(126, 43, 93, 23);
        contentPane.add(button_5);

        JButton button_6 = new JButton("图片6");
        button_6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setIcon(new ImageIcon("29/images/6.png"));
            }
        });
        button_6.setBounds(241, 43, 93, 23);
        contentPane.add(button_6);

        label = new JLabel("");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBounds(20, 76, 301, 175);
        contentPane.add(label);
    }
}

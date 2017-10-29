/**
 * 119：普通内部类的简单应用
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ButtonTest extends JFrame {

    private JPanel contentPane;
    private JPanel panel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ButtonTest frame = new ButtonTest();
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
    public ButtonTest() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 409, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        panel = new JPanel();
        panel.setBounds(10, 58, 374, 193);
        contentPane.add(panel);

        JButton redButton = new JButton("红色");
        redButton.addActionListener(new ColorAction(Color.RED));
        redButton.setBounds(10, 10, 93, 38);
        contentPane.add(redButton);

        JButton blueButton = new JButton("蓝色");
        blueButton.addActionListener(new ColorAction(Color.BLUE));
        blueButton.setBounds(151, 10, 93, 38);
        contentPane.add(blueButton);

        JButton greenButton = new JButton("绿色");
        greenButton.addActionListener(new ColorAction(Color.GREEN));
        greenButton.setBounds(290, 10, 93, 38);
        contentPane.add(greenButton);
    }

    /**
     * 编写 ColorAction 类，该类继承自 ActionListener 接口。
     * 在该类的构造方法中，需要为其指定一种颜色。
     * 在 actionPerformed() 方法中将面板设置成指定的颜色。
     * 代码如下：
     */
    private class ColorAction implements ActionListener {
        private Color background;

        public ColorAction(Color background) {
            this.background = background;
        }

        public void actionPerformed(ActionEvent e) {
            panel.setBackground(background);
        }
    }
}

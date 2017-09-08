/**
 * 046：数组的下标界限（数组下标越界抛出异常）
 * <p>
 * 主程序很简单，烦的是为什么都要界面编程。
 * 大致看了一下后面的程序，几乎都要使用界面。
 * 有点要疯狂了！！！
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.NumberFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class ArrayBound extends JFrame {

    private JPanel contentPane;
    private JFormattedTextField codeField;
    private JTextArea textArea;

    /**
     * Launch the application.
     */

    // 书中源码所使用的界面，感觉挺好！
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
                    ArrayBound frame = new ArrayBound();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // 原始的界面，有点丑~~
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ArrayBound frame = new ArrayBound();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

    /**
     * Create the frame.
     */
    public ArrayBound() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 337, 285);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setBounds(10, 83, 298, 156);
        contentPane.add(textArea);

        // 记得使用NumberFormat.getIntegerInstance()方法获取整数格式的对象
        codeField = new JFormattedTextField(NumberFormat.getIntegerInstance());
        codeField.setBounds(77, 52, 121, 21);
        contentPane.add(codeField);

        JButton btnNewButton = new JButton("\u786E\u5B9A");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_btnNewButton_actionPerformed(e);
            }
        });
        btnNewButton.setBounds(208, 50, 93, 23);
        contentPane.add(btnNewButton);

        JLabel lblNewLabel = new JLabel("\u805A\u4F1A\u8DA3\u5473\u9898\uFF1A\u9009\u62E9 0-5 \u7F16\u53F7\u7684\u9898\u76EE");
        lblNewLabel.setBounds(10, 21, 330, 15);
        contentPane.add(lblNewLabel);

        JLabel label = new JLabel("\u9898\u76EE\u7F16\u53F7\uFF1A");
        label.setBounds(10, 54, 69, 15);
        contentPane.add(label);
    }

    private String[] infos = {"50元奖金", "唱一首歌", "学狗叫", "为大家讲一个笑话", "3万元奖金"};

    protected void do_btnNewButton_actionPerformed(ActionEvent e) {
        int index = ((Number) codeField.getValue()).intValue();
        try {
            textArea.setText(infos[index]);
        } catch (Exception e2) {
            textArea.setText("发生异常：\n" + e2.toString());
        }
    }
}

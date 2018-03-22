/**
 * 372：使用微调控件浏览图片（其他文本控件的应用）
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpinnerListModel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ImageSpinner extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = -8615322216569328062L;
    private JPanel contentPane;
    private JSpinner spinner;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ImageSpinner frame = new ImageSpinner();
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
    public ImageSpinner() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActivated(e);
            }
        });
        setTitle("\u56FE\u7247\u6D4F\u89C8\u5DE5\u5177");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 150);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(1, 2, 5, 5));

        JLabel label = new JLabel("\u663E\u793A\u56FE\u7247\uFF1A");
        label.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        panel.add(label);

        spinner = new JSpinner();
        spinner.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        panel.add(spinner);
    }

    protected void do_this_windowActivated(WindowEvent e) {
        ImageIcon[] images = new ImageIcon[6]; // 利用数组来保存图片
        for (int i = 0; i < images.length; i++) {
            images[i] = new ImageIcon("13/" + (i + 1) + ".png");
        }
        spinner.setModel(new SpinnerListModel(images)); // 设置微调控件模型
        spinner.setEditor(new ImageLabel(spinner)); // 设置微调控件模型显示方式
    }
}

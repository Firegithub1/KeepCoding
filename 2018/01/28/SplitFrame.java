/**
 * 293：分割的窗体界面（窗体与控件外观）
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.UIManager;

public class SplitFrame extends JFrame {

    private JPanel contentPane;

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
                    SplitFrame frame = new SplitFrame();
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
    public SplitFrame() {
        setTitle("分割的窗体界面");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JSplitPane splitPane = new JSplitPane();// 创建分割面板
        splitPane.setResizeWeight(0.5);// 设置面板控件分配的百分比
        splitPane.setContinuousLayout(true);// 连续布局分割面板
        contentPane.add(splitPane, BorderLayout.CENTER);
        // 创建背景面板
        BGPanel panel = new BGPanel();
        panel.setIconFill(BGPanel.BOTH_FILL);// 背景双向填充
        // 设置背景图片
        panel.setImage(getToolkit().getImage(
                getClass().getResource("photo1.jpg")));// 设置背景图片
        splitPane.setLeftComponent(panel);
        // 创建背景面板
        BGPanel panel_1 = new BGPanel();
        panel_1.setIconFill(BGPanel.BOTH_FILL);// 背景双向填充
        panel_1.setImage(getToolkit().getImage(
                getClass().getResource("photo2.jpg")));// 设置背景图片
        splitPane.setRightComponent(panel_1);
    }

}

/**
 * 313：能显示图片的组合框（选择控件的应用）
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class JComboBoxTest extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = -7359353924560627099L;
    private JPanel contentPane;

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
                    JComboBoxTest frame = new JComboBoxTest();
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
    public JComboBoxTest() {
        setTitle("\u663E\u793A\u56FE\u7247\u7684\u7EC4\u5408\u6846");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 200, 150);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        Map<String, ImageIcon> content = new LinkedHashMap<String, ImageIcon>();
        content.put("图片1", new ImageIcon("09/1.png")); // 增加由图标说明和图标组成的映射
        content.put("图片2", new ImageIcon("09/2.png"));
        content.put("图片3", new ImageIcon("09/3.png"));

        JComboBox comboBox = new JComboBox(content.keySet().toArray()); // 利用键值构造组合框
        ComboBoxRenderer renderer = new ComboBoxRenderer(content); // 创建渲染器
        comboBox.setRenderer(renderer); // 设置渲染器
        comboBox.setMaximumRowCount(3); // 设置组合框最多显示 3 行可选项
        comboBox.setFont(new Font("微软雅黑", Font.PLAIN, 16)); // 设置组合框字体
        contentPane.add(comboBox, BorderLayout.CENTER); // 将组合框布局在框架中央
    }

}

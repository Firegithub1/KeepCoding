/**
 * 320：自定义软件安装向导（其他技术的应用）
 */

import java.awt.*;
import java.net.SocketImpl;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import jwizardcomponent.DefaultJWizardComponents;
import jwizardcomponent.Utilities;
import jwizardcomponent.example.SimpleLabelWizardPanel;
import jwizardcomponent.frame.SimpleLogoJWizardFrame;

public class WizardTest {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); // 修改默认的外观
            SimpleLogoJWizardFrame frame = new SimpleLogoJWizardFrame(new ImageIcon("13/logo.jpg")); // 利用指定的图标创建向导框架
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("简单的软件安装向导");

            DefaultJWizardComponents components = frame.getWizardComponents(); // 设置向导框
            JLabel label1 = new JLabel("软件安装第一步");
            label1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
            JLabel label2 = new JLabel("软件安装第二步");
            label2.setFont(new Font("微软雅黑", Font.PLAIN, 20));
            JLabel label3 = new JLabel("软件安装第三步");
            label3.setFont(new Font("微软雅黑", Font.PLAIN, 20));

            SimpleLabelWizardPanel panel1 = new SimpleLabelWizardPanel(components, label1);
            components.addWizardPanel(panel1); // 增加标签向导面板

            SimpleLabelWizardPanel panel2 = new SimpleLabelWizardPanel(components, label2);
            components.addWizardPanel(panel2);

            SimpleLabelWizardPanel panel3 = new SimpleLabelWizardPanel(components, label3);
            components.addWizardPanel(panel3);

            frame.setSize(450, 300);
            frame.setVisible(true); // 设置向导框可见
            Utilities.centerComponentOnScreen(frame); // 设置想到狂居中显示
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

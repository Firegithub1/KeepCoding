/**
 * 323：自定义系统托盘图标（其他技术的应用）
 */

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class SystemTrayTest extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 7276218747655657438L;
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
                    SystemTrayTest frame = new SystemTrayTest();
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
    public SystemTrayTest() {
        setTitle("\u7CFB\u7EDF\u6258\u76D8\u56FE\u6807\u6D4B\u8BD5");
        setBounds(100, 100, 225, 150);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JLabel lblJava = new JLabel("\u660E\u65E5\u79D1\u6280");
        lblJava.setHorizontalAlignment(SwingConstants.CENTER);
        lblJava.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        contentPane.add(lblJava, BorderLayout.CENTER);

        if (SystemTray.isSupported()) { // 如果系统支持系统托盘
            SystemTray tray = SystemTray.getSystemTray(); // 获得系统托盘
            Image image = Toolkit.getDefaultToolkit().getImage("15/icon.png");
            PopupMenu popupMenu = new PopupMenu();
            MenuItem openItem = new MenuItem("Open");
            openItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(true);
                }
            });

            MenuItem closeItem = new MenuItem("Close");
            closeItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });

            popupMenu.add(openItem);
            popupMenu.add(closeItem);
            TrayIcon trayIcon = new TrayIcon(image, "Java学习", popupMenu);
            trayIcon.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 2) { // 监听在托盘图标上双击鼠标的事件
                        setVisible(true);
                    }
                }
            });
            try {
                tray.add(trayIcon); // 在系统托盘上增加托盘图标
            } catch (AWTException e) {
                e.printStackTrace();
            }
        } else {
            // 如果系统不支持系统托盘则提示并退出
            JOptionPane.showMessageDialog(this, "您的系统不支持系统托盘！", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
    }

}

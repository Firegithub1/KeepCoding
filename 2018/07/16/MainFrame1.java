/**
 * 086：拼图游戏（游戏开发）
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame1 extends JFrame {

    private static final long serialVersionUID = 7791539566768257092L;

    /**
     * Launch the application
     *
     * @param args
     */
    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainFrame1 frame = new MainFrame1();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame
     */
    public MainFrame1() {
        super();
        getContentPane().setLayout(new BorderLayout());
        setTitle("拼图游戏");
        setBounds(300, 300, 358, 414);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 实例化JPanel
        final JPanel panel = new JPanel();
        // 添加到上方
        getContentPane().add(panel, BorderLayout.NORTH);
        // 实例化游戏面板
        final GamePanel gamePanel = new GamePanel();
        // 添加到中央位置
        getContentPane().add(gamePanel, BorderLayout.CENTER);
        // 实例化按钮
        final JButton button = new JButton();
        // 注册事件
        button.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                // 开始游戏
                gamePanel.random();
            }
        });
        button.setText("开始");
        panel.add(button);
    }

}

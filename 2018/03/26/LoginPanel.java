import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class LoginPanel extends JPanel {
    private ImageIcon bg;

    public LoginPanel() {
        //获取图片路径
        URL url = getClass().getResource("loginBG.png");
        bg = new ImageIcon(url); // 加载图片对象
        //设置面板与背景相同大小
        setSize(bg.getIconWidth(), bg.getIconHeight());
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        super.paintComponent(g2);
        if (bg != null) { // 如果背景图片对象初始化完毕
            // 绘制图片到界面中
            g2.drawImage(bg.getImage(), 0, 0, this);
        }
    }
}

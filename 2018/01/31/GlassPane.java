import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JComponent;

public class GlassPane extends JComponent {
    private static final long serialVersionUID = 9060636159598343142L;

    public GlassPane() {
        addMouseListener(new MouseAdapter() { // 屏蔽鼠标事件
        });
        addMouseMotionListener(new MouseMotionAdapter() { // 屏蔽鼠标拖拽事件
        });
        addKeyListener(new KeyAdapter() { // 屏蔽键盘事件
        });
        setFont(new Font("Default", Font.BOLD, 16)); // 设置控件的字体
    }

    protected void paintComponent(Graphics g) {
        g.setColor(Color.red); // 将画笔换成红色
        g.drawString("正在下载…", 190, 130); // 在坐标（190，130）处绘制字符串“正在下载…”
    }
}
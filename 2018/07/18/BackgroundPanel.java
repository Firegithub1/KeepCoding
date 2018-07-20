package com.zzk;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;
/**
 * 背景面板
 * @author 张振坤
 *
 */
public class BackgroundPanel extends JPanel {
    private static final long serialVersionUID = 5260642571525243284L;
    // 背景图片
    private Image image;

    public BackgroundPanel() {
        setOpaque(false);
        setLayout(null);
    }

    public void setImage(Image image) {
        this.image = image;
    }
    /**
     * 画出背景
     */
    protected void paintComponent(Graphics g) {
        if (image != null) {
            // 图片宽度
            int width = getWidth();
            // 图片高度
            int height = getHeight();
            // 画出图片
            g.drawImage(image, 0, 0, width, height, this);
        }
        super.paintComponent(g);
    }
}

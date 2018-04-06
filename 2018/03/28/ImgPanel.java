import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ImgPanel extends JPanel {
    private ImageIcon bg;

    public ImgPanel() {
        super();
        URL url = getClass().getResource("back.jpg");
        bg = new ImageIcon(url);
        setSize(bg.getIconWidth(), bg.getIconHeight());
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        super.paintComponent(g2);
        if (bg != null) {
            g2.drawImage(bg.getImage(), 0, 0, this);
        }
    }
}

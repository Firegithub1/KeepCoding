import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BackgroundJTextField extends JTextField {
    private static final long serialVersionUID = 5810044732894008630L;

    private TexturePaint paint;

    public BackgroundJTextField(File file) {
        super();
        try {
            BufferedImage image = ImageIO.read(file); // 获得缓冲图片
            Rectangle rectangle = new Rectangle(0, 0, image.getWidth(), image.getHeight());
            paint = new TexturePaint(image, rectangle); // 创建 TexturePaint 对象
            setOpaque(false); // 将文本域设置成透明的
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g1 = (Graphics2D) g; // 将 g 转型为 Graphics2D
        g1.setPaint(paint); // 设置新的颜色模式
        g.fillRect(0, 0, getWidth(), getHeight()); // 让图片充满整个区域
        super.paintComponent(g); // 调用父类的同名方法
    }
}

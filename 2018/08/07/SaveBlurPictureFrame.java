/**
 * 123：模糊图片并保存（打印的应用）
 */

import java.awt.BorderLayout;
import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SaveBlurPictureFrame extends JFrame {
    private BufferedImage image;// 声明缓冲图像对象
    private BlurPicturePanel blurPicturePanel = null; // 声明图像面板对象
    private boolean blurFlag = false;// 模糊标记

    public static void main(String args[]) {
        SaveBlurPictureFrame frame = new SaveBlurPictureFrame();
        frame.setVisible(true);
    }

    public SaveBlurPictureFrame() {
        super();
        setTitle("模糊图片并保存"); // 设置窗体标题
        setBounds(200, 160, 439, 319); // 设置窗体大小和位置
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置窗体关闭模式
        final JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.SOUTH);
        blurPicturePanel = new BlurPicturePanel(); // 创建图像面板对象
        add(blurPicturePanel); // 在窗体上添加图像面板对象
        final JButton button = new JButton();
        button.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                float[] elements = new float[9];// 定义表示像素分量的数组
                for (int i = 0; i < 9; i++) {
                    elements[i] = 0.11f;// 为数组赋值
                }
                convolve(elements);// 调用方法，实现模糊功能
                blurFlag = true;// 模糊图片标记
            }
        });
        button.setText("模糊图片");
        panel.add(button);

        final JButton button_2 = new JButton();
        button_2.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                if (!blurFlag) {
                    JOptionPane.showMessageDialog(null, "还没有模糊图片。");// 显示提示信息
                    return;
                }
                FileDialog dialog = new FileDialog(SaveBlurPictureFrame.this,
                        "保存");// 创建对话框
                dialog.setMode(FileDialog.SAVE);// 设置对话框为保存对话框
                dialog.setVisible(true);// 显示保存对话框
                String path = dialog.getDirectory();// 获得文件的保存路径
                String fileName = dialog.getFile();// 获得保存的文件名
                if (path == null || fileName == null) {
                    return;
                }
                String fileExtName = fileName
                        .substring(fileName.indexOf(".") + 1);// 文件扩展名,不含点
                String pathAndName = path + "\\" + fileName;// 文件的完整路径
                try {
                    ImageIO.write(image, fileExtName, new File(pathAndName));// 将缓冲图像保存到磁盘
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(null, "保存失败\n"
                            + e1.getMessage());// 显示提示信息
                }
            }
        });
        button_2.setText("保存图片");
        panel.add(button_2);

        final JButton button_1 = new JButton();
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                System.exit(0);
            }
        });
        button_1.setText("退    出");
        panel.add(button_1);
    }

    private void convolve(float[] elements) {
        Kernel kernel = new Kernel(3, 3, elements);// 创建 Kernel对象
        ConvolveOp op = new ConvolveOp(kernel);// 创建ConvolveOp对象
        if (image == null) {
            return;
        }
        image = op.filter(image, null); // 过滤缓冲图像对象
        repaint();// 调用paint()方法
    }

    // 创建面板类
    class BlurPicturePanel extends JPanel {
        public BlurPicturePanel() {
            Image img = null;// 声明创建图像对象
            try {
                img = ImageIO.read(new File("07/img/imag.jpg")); // 创建图像对象
            } catch (IOException e) {
                e.printStackTrace();
            }
            image = new BufferedImage(img.getWidth(null), img.getHeight(null),
                    BufferedImage.TYPE_INT_RGB);// 创建缓冲图像对象
            image.getGraphics().drawImage(img, 0, 0, null);// 在缓冲图像对象上绘制图像
        }
        public void paint(Graphics g) {
            if (image != null) {
                g.drawImage(image, 0, 0, null);// 绘制缓冲图像对象
            }
        }
    }
}

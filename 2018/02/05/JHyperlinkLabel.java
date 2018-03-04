import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class JHyperlinkLabel extends JLabel {
    private static final long serialVersionUID = -863116705726089148L;

    private String label;

    public JHyperlinkLabel(String label) { // 在初始化时指明要显示的字符串
        super(label);
        this.label = label;
        setForeground(Color.BLUE.darker()); // 将字符串的颜色设置成深蓝色
        setCursor(new Cursor(Cursor.HAND_CURSOR)); // 将字符串上的鼠标设置成手形
        addMouseListener(new HyperlinkLabelMouseAdapter()); // 增加单击的监听事件
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(getForeground()); // 将画笔的颜色设置成字符串的颜色
        Insets insets=getInsets(); // 获得标签的边框

        int left=insets.left;
        if(getIcon()!=null){ // 如果有图片则重新计算左下角 X 坐标
            left+=getIcon().getIconWidth()+getIconTextGap();
        }
        g.drawLine(left,getHeight()-1-insets.bottom,(int)getWidth()-insets.right,getHeight()-1-insets.bottom); // 绘制下划线
    }

    public class HyperlinkLabelMouseAdapter extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                URI uri = new URI(label); // 根据创建标签时使用的字符串来创建 URI 对象
                Desktop desktop = null;
                if (Desktop.isDesktopSupported()) { // 如果 Desktop 可用则获得其对象
                    desktop = Desktop.getDesktop();
                }
                if (desktop != null) {
                    desktop.browse(uri); // 用浏览器打开 uri
                }
            } catch (URISyntaxException e1) {
                e1.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }
}

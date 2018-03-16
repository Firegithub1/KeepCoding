import javax.swing.*;
import java.awt.*;

public class FontListCellRenderer implements ListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        DefaultListCellRenderer defaultrenderer = new DefaultListCellRenderer();
        JLabel renderer = (JLabel) defaultrenderer.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        // 获得 getListCellRendererComponent 的默认实现

        Font font = (Font) value; // 获得列表项的字体
        renderer.setFont(font); // 设置标签的字体
        renderer.setText(font.getFontName());
        return renderer;
    }
}

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class BorderListCellRenderer implements ListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();
        JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        // 获得 getListCellRendererComponent 的默认实现

        if (index % 2 == 0) { // 如果索引为偶数则增加边框
            renderer.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        }
        return renderer;
    }
}

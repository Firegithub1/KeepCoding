import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class ColorTableCellRenderer extends JPanel implements TableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        int times = 50; // 设置背景色与行列索引的倍数关系
        int r = row * times % 255; // 设置 r 值，代表红色
        int g = column * times % 255; // 设置 g 值，代表绿色
        int b = (row + column) * times % 255; // 设置 b 值，代表蓝色
        setBackground(new Color(r, g, b)); // 设置新的背景色
        return this;
    }
}

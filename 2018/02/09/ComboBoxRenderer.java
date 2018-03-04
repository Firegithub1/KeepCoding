import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class ComboBoxRenderer extends JLabel implements ListCellRenderer {
    private static final long serialVersionUID = -318939036460656104L;

    private Map<String, ImageIcon> content; // 保存图片及其说明

    public ComboBoxRenderer(Map<String, ImageIcon> content) {
        this.content = content;
        setOpaque(true); // 设置标签为不透明
        setHorizontalAlignment(CENTER); // 水平方向居中对齐
        setVerticalAlignment(CENTER); // 垂直方向居中对齐
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        String key = (String) value; // 将组合框的一个值转换成字符串
        if (isSelected) { // 根据是否处于选择状态而更改外观
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
        setText(key); // 设置标签的文本
        setIcon(content.get(key)); // 设置标签的图标
        setFont(list.getFont()); // 设置标签的字体
        return this;
    }
}

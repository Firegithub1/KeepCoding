import javax.swing.*;
import java.awt.*;

public class ImageListCellRenderer implements ListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        DefaultListCellRenderer defaultRenderer=new DefaultListCellRenderer();
        JLabel renderer= (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        // 获得 getListCellRendererComponent 的默认实现

        if(value instanceof Object[]){
            Object values[]= (Object[]) value; // 将列表项转换成对象数组
            renderer.setIcon((Icon) values[0]); // 为标签设置图标
            renderer.setText((String) values[1]);
        }
        return renderer;
    }
}

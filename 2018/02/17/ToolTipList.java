import javax.swing.*;
import java.awt.event.MouseEvent;

public class ToolTipList extends JList {
    private static final long serialVersionUID = -5334116242803068391L;
    private Object[][] data;

    public ToolTipList(Object[][] data) {
        this.data = data;
        Object[] listData = new Object[data.length]; // 定义一个列表项用来保存列表项
        for (int i = 0; i < listData.length; i++) {
            listData[i] = data[i][0]; // 获得列表项
        }
        setListData(listData); // 设置列表项
    }

    @Override
    public String getToolTipText(MouseEvent event) {
        int index = locationToIndex(event.getPoint()); // 获得鼠标所在位置的列表项的索引
        if (index > -1) {
            return "<html><font face=微软雅黑 size=16 color=red>" + data[index][1] + "</font></html>"; // 返回提示信息
        } else {
            return super.getToolTipText(event);
        }
    }
}

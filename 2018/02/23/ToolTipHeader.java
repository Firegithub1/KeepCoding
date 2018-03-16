import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import java.awt.event.MouseEvent;

public class ToolTipHeader extends JTableHeader {
    private static final long serialVersionUID = 6694115973725345619L;

    private String[] toolTips;

    public ToolTipHeader(TableColumnModel model) {
        super(model); // 初始化表头
    }

    public void setToolTips(String[] toolTips) {
        this.toolTips = toolTips; // 获得提示信息数组
    }

    @Override
    public String getToolTipText(MouseEvent event) {
        int index = columnAtPoint(event.getPoint()); // 获得鼠标所在位置
        if (index != -1) { // 如果鼠标位于表头
            return "<html><font face=微软雅黑 size=16 color=red>" + toolTips[index] + "</font></html>"; // 返回鼠标所在位置的提示信息
        } else {
            return ""; // 返回空字符串
        }
    }
}

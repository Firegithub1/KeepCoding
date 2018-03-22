import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;
import java.awt.*;
import java.util.Map;

public class ToolTipNode implements TreeCellRenderer {
    private DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
    private Map<DefaultMutableTreeNode, String> map; // 保存键值对

    public ToolTipNode(Map<DefaultMutableTreeNode, String> map) {
        this.map = map; // 初始化键值对
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        renderer.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
        renderer.setToolTipText("<html><font face=微软雅黑 size=16 color=red>" + map.get(value) + "</font></html>"); // 设置提示信息
        return renderer;
    }
}

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class FenseRenderer implements TableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel renderer= (JLabel) new DefaultTableCellRenderer().getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if(row%2==0){
            renderer.setForeground(Color.WHITE);
            renderer.setBackground(Color.MAGENTA);
        }else{
            renderer.setForeground(Color.MAGENTA);
            renderer.setBackground(Color.WHITE);
        }
        return renderer;
    }
}

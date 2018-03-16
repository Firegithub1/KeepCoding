/**
 * 348：单元格的细粒度排序（表格的高级应用）
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Comparator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class SortedTable2 extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 2215793712885732497L;
    private JPanel contentPane;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SortedTable2 frame = new SortedTable2();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public SortedTable2() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActivated(e);
            }
        });
        setTitle("\u652F\u6301\u6392\u5E8F\u529F\u80FD\u7684\u8868\u683C");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        table.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        table.setRowHeight(35);
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        header.setPreferredSize(new Dimension(header.getWidth(), 40));
        scrollPane.setViewportView(table);
    }

    protected void do_this_windowActivated(WindowEvent e) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        model.setColumnIdentifiers(new Object[] { "颜色名称", "颜色" });
        model.addRow(new Object[] { "黑色", Color.BLACK });
        model.addRow(new Object[] { "蓝色", "" });
        model.addRow(new Object[] { "灰色", Color.GRAY });
        model.addRow(new Object[] { "绿色", Color.GREEN });
        model.addRow(new Object[] { "橙色", Color.ORANGE });
        model.addRow(new Object[] { "粉色", Color.PINK });
        model.addRow(new Object[] { "红色", Color.RED });
        model.addRow(new Object[] { "白色", Color.WHITE });
        model.addRow(new Object[] { "黄色", Color.YELLOW });
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
        sorter.setComparator(1, new Comparator<Color>() { // 为第二列设置排序器

            @Override
            public int compare(Color o1, Color o2) { // 设置排序方式
                int r = o1.getRed() - o2.getRed();
                int g = o1.getGreen() - o2.getGreen();
                int b = o1.getBlue() - o2.getBlue();
                if (r != 0) { // 首先按红色值排序
                    return r;
                } else if (g != 0) { // 其次按绿色值排序
                    return g;
                } else {
                    return b; // 最后按蓝色值排序
                }
            }
        });
        table.setRowSorter(sorter); // 为表格增加排序器
        table.getColumnModel().getColumn(0).setPreferredWidth(150); // 设置第一列的宽度
        table.getColumnModel().getColumn(1).setPreferredWidth(300); // 设置第二列的宽度
    }
}

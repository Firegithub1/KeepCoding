/**
 * 045：用数组设置 JTable 表格的列名与列宽
 * <p>
 * 虽然自己实现出来了，但有些疑惑
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class ArrayCreateTable extends JFrame {

    private JPanel contentPane;
    private JTable table;
    JScrollPane scrollPane;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ArrayCreateTable frame = new ArrayCreateTable();
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
    public ArrayCreateTable() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 557, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        contentPane.add(getScrollPane(), BorderLayout.CENTER);


    }

    private JScrollPane getScrollPane() {
        if (scrollPane == null) {
            scrollPane = new JScrollPane();
            scrollPane.setViewportView(getTable());
        }
        return scrollPane;
    }

    private JTable getTable() {
        if (table == null) {
            table = new JTable();
            // 定义列名数组
            String[] columns = {"星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"};
            // 定义列宽数组
            int[] columnWidth = {10, 20, 30, 40, 50, 60, 70};
            // 创建数据表格模型
            DefaultTableModel model = new DefaultTableModel(columns, 15);
            table.setModel(model); // 设置数据表格模型
            TableColumnModel columnModel = table.getColumnModel(); // 获取列模型
            int count = columnModel.getColumnCount(); // 获取列数量
            for (int i = 0; i < count; i++) { // 遍历列
                TableColumn column = columnModel.getColumn(i); // 获取列对象
                column.setPreferredWidth(columnWidth[i]); // 以数组元素设置列的宽度
            }
        }
        return table;
    }
}

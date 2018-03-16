/**
 * 343：在表格中应用组合框（表格的高级应用）
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

public class ComboBoxTable extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = -4337886573574854144L;
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
                    ComboBoxTable frame = new ComboBoxTable();
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
    public ComboBoxTable() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActivated(e);
            }
        });
        setTitle("\u5305\u542B\u590D\u9009\u6846\u7684\u8868\u683C");
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
        table.setRowHeight(30);
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        header.setPreferredSize(new Dimension(header.getWidth(), 35));
        scrollPane.setViewportView(table);
    }

    protected void do_this_windowActivated(WindowEvent e) {
        ComboBoxTableModel tableModel = new ComboBoxTableModel(); // 创建自定义表格模型
        table.setModel(tableModel); // 设置表格模型
        JComboBox comboBox = new JComboBox(ComboBoxTableModel.getStates()); // 创建组合框对象
        comboBox.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        DefaultCellEditor editor = new DefaultCellEditor(comboBox); // 利用组合框创建单元格编辑器
        TableColumnModel columnModel = table.getColumnModel(); // 获得表格的列模型
        columnModel.getColumn(1).setCellEditor(editor); // 设置第二列为组合框
        columnModel.getColumn(0).setPreferredWidth(250); // 设置第一列的宽度为 250
        columnModel.getColumn(1).setPreferredWidth(100); // 设置第二列的宽度为 100
    }
}

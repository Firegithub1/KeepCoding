/**
 * 337：表头与列的高度设置（表格的简单应用）
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.UIManager;

public class ResizeTableTest extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 6589584750853602612L;
    private JPanel contentPane;
    private JTable table1;
    private JTable table2;

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
                    ResizeTableTest frame = new ResizeTableTest();
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
    public ResizeTableTest() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActivated(e);
            }
        });
        setTitle("\u8BBE\u7F6E\u8868\u683C\u5BBD\u5EA6\u4E0E\u9AD8\u5EA6");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(1, 2, 5, 5));

        JPanel panel1 = new JPanel();
        contentPane.add(panel1);
        panel1.setLayout(new BorderLayout(0, 0));

        JLabel label1 = new JLabel("\u9ED8\u8BA4\u7684\u8868\u683C");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        panel1.add(label1, BorderLayout.NORTH);

        JScrollPane scrollPane1 = new JScrollPane();
        panel1.add(scrollPane1, BorderLayout.CENTER);

        table1 = new JTable();
        scrollPane1.setViewportView(table1);

        JPanel panel2 = new JPanel();
        contentPane.add(panel2);
        panel2.setLayout(new BorderLayout(0, 0));

        JLabel label2 = new JLabel("\u81EA\u5B9A\u4E49\u8868\u683C");
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        panel2.add(label2, BorderLayout.NORTH);

        JScrollPane scrollPane2 = new JScrollPane();
        panel2.add(scrollPane2, BorderLayout.CENTER);

        table2 = new JTable();
        table2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        table2.setRowHeight(35); // 设置表格的行高
        JTableHeader header = table2.getTableHeader(); // 获得表头
        header.setFont(new Font("微软雅黑", Font.PLAIN, 16)); // 修改表头的字体
        header.setPreferredSize(new Dimension(header.getWidth(), 40)); // 修改表头的高度
        scrollPane2.setViewportView(table2); // 显示表
    }

    protected void do_this_windowActivated(WindowEvent e) {
        DefaultTableModel model = new DefaultTableModel(); // 创建表格模型
        model.setRowCount(0); // 将表格模型中的数据清空
        model.setColumnIdentifiers(new Object[] { "排名", "语言" }); // 设置表头
        model.addRow(new Object[] { "1", "Java" }); // 增加行
        model.addRow(new Object[] { "2", "C" });
        model.addRow(new Object[] { "3", "C#" });
        table1.setModel(model); // 为表格设置表格模型
        table2.setModel(model);
    }
}

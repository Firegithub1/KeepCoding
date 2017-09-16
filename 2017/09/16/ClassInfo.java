/**
 * 057：用 List 集合传递学生信息
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;

public class ClassInfo extends JFrame {

    private JPanel contentPane;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            UIManager
                    .setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ClassInfo frame = new ClassInfo();
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
    public ClassInfo() {
        setTitle("\u7528List\u96C6\u5408\u4F20\u9012\u5B66\u751F\u4FE1\u606F");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 282);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        scrollPane.setViewportView(getTable());
    }

    private JTable getTable() {
        if (table == null) {
            table = new JTable(); // 创建表格控件
            table.setRowHeight(23); // 设置行高度
            String[] columns = {"姓名", "性别", "出生日期"}; // 创建列名数组
            // 创建表格模型
            DefaultTableModel model = new DefaultTableModel(columns, 0);
            table.setModel(model); // 设置表格模型
            List<String> students = getStudents(); // 调用方法传递list集合对象
            for (String info : students) { // 遍历学生集合对象
                String[] args = info.split(","); // 把学生信息拆分为数组
                model.addRow(args); // 把学生信息添加到表格的行
            }
        }
        return table;
    }

    private List<String> getStudents() {
        // 创建List集合对象
        List<String> list = new ArrayList<String>();
        list.add("李刚,男,1990-1-1"); // 添加数据到集合对象
        list.add("陈胜,男,1993-2-3");
        list.add("王一,女,1995-8-10");
        list.add("小李,男,1992-5-7");
        list.add("小张,女,1993-9-26");
        list.add("小徐,女,1994-4-16");
        list.add("小江,男,1992-8-20");
        return list;
    }
}

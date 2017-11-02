/**
 * 126：查看和修改线程名称
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ThreadNameTest extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JTextField textField_1;
    private JTextField textField_2;

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
                    ThreadNameTest frame = new ThreadNameTest();
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
    public ThreadNameTest() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActived(e);
            }
        });
        setTitle("查看和修改线程名称");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.SOUTH);

        textField_1 = new JTextField();
        textField_1.setBounds(10, 218, 82, 33);
        panel.add(textField_1);
        textField_1.setColumns(10);

        JButton button_1 = new JButton("新建线程");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_1_actionPerformed(e);
            }
        });
        button_1.setBounds(102, 218, 93, 34);
        panel.add(button_1);

        textField_2 = new JTextField();
        textField_2.setBounds(238, 218, 66, 33);
        panel.add(textField_2);
        textField_2.setColumns(10);

        JButton button_2 = new JButton("修改名称");
        button_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_2_actionPerformed(e);
            }
        });
        button_2.setBounds(314, 218, 93, 34);
        panel.add(button_2);

        JScrollPane scrollPanel = new JScrollPane();
        contentPane.add(scrollPanel, BorderLayout.CENTER);

        table = new JTable();
        table.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        table.setRowHeight(30);
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        header.setPreferredSize(new Dimension(header.getWidth(), 35));
        scrollPanel.setViewportView(table);
    }

    protected void do_button_1_actionPerformed(ActionEvent e) {
        Object[] newThread = null;
        String name = textField_1.getText();
        if (name.isEmpty()) { // 如果用户没有输入，则使用默认名称创建新线程
            Thread thread = new Thread(new Forever());
            thread.start();
            newThread = new Object[]{thread.getId(), thread.getName()};
        } else { // 如果没有用户输入，则使用指定名称创建新线程
            Thread thread = new Thread(new Forever(), name);
            thread.start();
            newThread = new Object[]{thread.getId(), name};
        }
        ((DefaultTableModel) table.getModel()).addRow(newThread); // 更新表格中的数据
    }

    protected void do_button_2_actionPerformed(ActionEvent e) {
        int selectedRow = table.getSelectedRow(); // 获得用户选择的行
        String newName = textField_2.getText(); // 获得用户输入的名称
        if ((selectedRow == -1) || newName.isEmpty()) { // 如果没有选择或者输入为空，则直接退出该方法
            return;
        }
        DefaultTableModel model = (DefaultTableModel) table.getModel(); // 更新表格模型
        model.setValueAt(newName, selectedRow, 1); // 更改表格中的数据
        repaint(); // 重新绘制各个控件
    }

    protected void do_this_windowActived(WindowEvent e) {
        ThreadGroup group = Thread.currentThread().getThreadGroup(); // 获得当前线程所在线程组
        Thread[] threads = new Thread[group.activeCount()]; // 使用数组保存活动状态的线程
        group.enumerate(threads); // 获得所有线程
        DefaultTableModel model = (DefaultTableModel) table.getModel(); // 获得表格模型
        model.setRowCount(0); // 清空表格模型中的数据
        model.setColumnIdentifiers(new Object[]{"线程ID", "线程名称"}); // 定义表头
        for (Thread thread : threads) { // 增加行数据
            model.addRow(new Object[]{thread.getId(), thread.getName()});
        }
        table.setModel(model); // 更新表格模型
    }

    public class Forever implements Runnable {
        public void run() {
            while (true) { // 死循环
            }
        }
    }
}

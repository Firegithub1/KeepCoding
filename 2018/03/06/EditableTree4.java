/**
 * 360：双击编辑树节点功能（树控件高级应用）
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultCellEditor;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeCellEditor;
import javax.swing.UIManager;

public class EditableTree4 extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = -6092916733029206964L;
    private JPanel contentPane;
    private JTree tree;

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
                    EditableTree4 frame = new EditableTree4();
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
    public EditableTree4() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActivated(e);
            }
        });
        setTitle("\u53EF\u4EE5\u7F16\u8F91\u8282\u70B9\u7684\u6811");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        tree = new JTree();
        tree.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        scrollPane.setViewportView(tree);
    }

    protected void do_this_windowActivated(WindowEvent e) {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("明日科技新书");
        DefaultMutableTreeNode parent1 = new DefaultMutableTreeNode("从入门到精通系列");
        parent1.add(new DefaultMutableTreeNode("《Java从入门到精通（第2版）》"));
        parent1.add(new DefaultMutableTreeNode("《PHP从入门到精通（第2版）》"));
        parent1.add(new DefaultMutableTreeNode("《Visual Basic从入门到精通（第2版）》"));
        parent1.add(new DefaultMutableTreeNode("《Visual C++从入门到精通（第2版）》"));
        root.add(parent1);
        DefaultMutableTreeNode parent2 = new DefaultMutableTreeNode("编程词典系列");
        parent2.add(new DefaultMutableTreeNode("《Java编程词典》"));
        parent2.add(new DefaultMutableTreeNode("《PHP编程词典》"));
        parent2.add(new DefaultMutableTreeNode("《Visual Basic编程词典》"));
        parent2.add(new DefaultMutableTreeNode("《Visual C++编程词典》"));
        root.add(parent2);
        DefaultTreeModel model = new DefaultTreeModel(root);
        tree.setModel(model);
        JTextField textField = new JTextField();
        textField.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        TreeCellEditor editor = new DefaultCellEditor(textField); // 创建树编辑器
        tree.setEditable(true); // 设置树节点可编辑
        tree.setCellEditor(editor); // 使用树编辑器
    }
}

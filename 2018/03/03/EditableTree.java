/**
 * 355：在树控件中增加节点（树控件高级应用）
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

public class EditableTree extends JFrame {

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
                    EditableTree2 frame = new EditableTree2();
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
    public EditableTree() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActivated(e);
            }
        });
        setTitle("\u53EF\u4EE5\u589E\u52A0\u5B50\u8282\u70B9\u7684\u6811");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.SOUTH);

        JButton button = new JButton("\u589E\u52A0\u8282\u70B9");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        panel.add(button);

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        tree = new JTree();
        tree.setEditable(true);
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
    }

    protected void do_button_actionPerformed(ActionEvent e) {
        DefaultMutableTreeNode selectNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent(); // 获得用户选择的节点
        if (selectNode == null) {
            return;
        }
        DefaultTreeModel model = (DefaultTreeModel) tree.getModel(); // 获得当前树的模型
        DefaultMutableTreeNode newNode = new DefaultMutableTreeNode("New Node"); // 新建节点
        model.insertNodeInto(newNode, selectNode, selectNode.getChildCount()); // 增加节点
        TreeNode[] nodes = model.getPathToRoot(newNode); // 向上构建节点的父节点一直到根节点
        TreePath path = new TreePath(nodes); // 创建 TreePath 对象
        tree.scrollPathToVisible(path); // 确保路径中所有的路径控件均展开（最后一个路径控件除外）并滚动
        tree.setSelectionPath(path); // 选择指定路径标识的节点
        tree.startEditingAtPath(path); // 设置新建的节点处于可编辑状态
        tree.repaint(); // 重新绘制树
    }
}

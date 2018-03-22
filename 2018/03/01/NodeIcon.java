/**
 * 351：自定义树节点的图标（树控件简单应用）
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.Font;

public class NodeIcon extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = -9048535408788781352L;
    private JPanel contentPane;
    private JTree tree;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        UIManager.put("Tree.openIcon", new ImageIcon("01/open.png")); // 设置节点打开图标
        UIManager.put("Tree.closedIcon", new ImageIcon("01/closed.png")); // 设置关闭图标
        UIManager.put("Tree.leafIcon", new ImageIcon("01/leaf.png")); // 设置子节点的图标
        try { // 修改 Swing 的外观为 Nimbus
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() { // 在时间派发线程中运行 Swing 程序
            public void run() {
                try {
                    NodeIcon frame = new NodeIcon();
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
    public NodeIcon() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActivated(e);
            }
        });
        setTitle("\u4FEE\u6539\u6811\u8282\u70B9\u7684\u56FE\u6807");
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
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("明日科技新书"); // 设置根节点
        DefaultMutableTreeNode parent1 = new DefaultMutableTreeNode("从入门到精通系列");
        parent1.add(new DefaultMutableTreeNode("《Java从入门到精通（第2版）》"));
        parent1.add(new DefaultMutableTreeNode("《PHP从入门到精通（第2版）》"));
        parent1.add(new DefaultMutableTreeNode("《Visual Basic从入门到精通（第2版）》"));
        parent1.add(new DefaultMutableTreeNode("《Visual C++从入门到精通（第2版）》"));
        root.add(parent1); // 增加子节点
        DefaultMutableTreeNode parent2 = new DefaultMutableTreeNode("编程词典系列");
        parent2.add(new DefaultMutableTreeNode("《Java编程词典》"));
        parent2.add(new DefaultMutableTreeNode("《PHP编程词典》"));
        parent2.add(new DefaultMutableTreeNode("《Visual Basic编程词典》"));
        parent2.add(new DefaultMutableTreeNode("《Visual C++编程词典》"));
        root.add(parent2); // 增加子节点
        DefaultTreeModel model = new DefaultTreeModel(root); // 使用根节点创建默认树模型
        tree.setModel(model); // 更新树模型
    }
}

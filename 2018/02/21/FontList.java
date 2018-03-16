/**
 * 336：可以预览字体的列表（列表的高级应用）
 */

import javafx.scene.control.ListCell;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.border.EmptyBorder;

public class FontList extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = -2718910561731829476L;
    private JPanel contentPane;
    private JList list;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FontList frame = new FontList();
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
    public FontList() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActivated(e);
            }
        });
        setTitle("\u53EF\u4EE5\u9884\u89C8\u5B57\u4F53\u7684\u5217\u8868");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        list = new JList();
        scrollPane.setViewportView(list);
    }

    protected void do_this_windowActivated(WindowEvent e) {
        // 获得系统支持的全部字体
        String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        DefaultListModel model = new DefaultListModel(); // 创建表格模型
        for (String fontName : fontNames) { // 遍历全部字体并将其添加到表格模型中
            model.addElement(new Font(fontName, Font.PLAIN, 24));
        }
        list.setModel(model); // 设置表格模型
        ListCellRenderer renderer = new FontListCellRenderer();
        list.setCellRenderer(renderer); // 设置列表中的渲染工具
    }
}

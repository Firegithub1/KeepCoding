/**
 * 330：监听列表项双击事件（列表的简单应用）
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;

public class SelectEventTest2 extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 7020163320919418696L;
    private JPanel contentPane;
    private JList list;
    private JLabel label;

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
                    SelectEventTest2 frame = new SelectEventTest2();
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
    public SelectEventTest2() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActivated(e);
            }
        });
        setTitle("\u5217\u8868\u9879\u53CC\u51FB\u4E8B\u4EF6\u6D4B\u8BD5");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.SOUTH);

        label = new JLabel("\u56FE\u4E66\u8D2D\u4E70\u4FE1\u606F");
        label.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        panel.add(label);

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        list = new JList();
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                do_list_mouseClicked(e);
            }
        });
        list.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        scrollPane.setViewportView(list);
    }

    protected void do_this_windowActivated(WindowEvent e) {
        String[] listData = new String[7];
        listData[0] = "《Java从入门到精通（第2版）》";
        listData[1] = "《PHP从入门到精通（第2版）》";
        listData[2] = "《Visual Basic从入门到精通（第2版）》";
        listData[3] = "《Visual C++从入门到精通（第2版）》";
        listData[4] = "《Java编程词典》";
        listData[5] = "《细说Java》";
        listData[6] = "《视频学Java》";
        list.setListData(listData);
    }

    protected void do_list_mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) { // 如果列表项上发生双击事件
            JList source = (JList) e.getSource(); // 获得鼠标单击的列表
            label.setText("感谢您购买：" + source.getSelectedValue()); // 更新标签中的信息
        }
    }
}

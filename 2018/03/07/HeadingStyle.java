/**
 * 361：自定义文档标题的样式（JTextPane 控件的应用）
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import java.awt.Font;

public class HeadingStyle extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = -9123085459397426202L;
    private JPanel contentPane;
    private JTextPane textPane;

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
                    HeadingStyle frame = new HeadingStyle();
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
    public HeadingStyle() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActivated(e);
            }
        });
        setTitle("\u81EA\u5B9A\u4E49\u6807\u9898\u7684\u6837\u5F0F");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        textPane = new JTextPane();
        textPane.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        scrollPane.setViewportView(textPane);

    }

    protected void do_this_windowActivated(WindowEvent e) {
        String heading = "陋室铭\n";
        String content = "山不在高，有仙则名。水不在深，有龙则灵。斯是陋室，惟吾德馨。苔痕上阶绿，草色入帘青。谈笑有鸿儒，往来无白丁。可以调素琴，阅金经。无丝竹之乱耳，无案牍之劳形。南阳诸葛庐，西蜀子云亭。孔子云：何陋之有？\n";
        Style headingStyle = new StyleContext().addStyle("Heading", null); // 新建样式
        headingStyle.addAttribute(StyleConstants.Alignment, StyleConstants.ALIGN_CENTER);
        headingStyle.addAttribute(StyleConstants.Bold, true);
        headingStyle.addAttribute(StyleConstants.FontFamily, "微软雅黑");
        headingStyle.addAttribute(StyleConstants.FontSize, 18);
        headingStyle.addAttribute(StyleConstants.Foreground, Color.RED);
        DefaultStyledDocument document = new DefaultStyledDocument();
        try {
            document.insertString(0, heading + content, null); // 插入文本
        } catch (BadLocationException e1) {
            e1.printStackTrace();
        }
        document.setParagraphAttributes(0, 1, headingStyle, false); // 为段落设置样式
        textPane.setDocument(document); // 显示带有格式的文本内容
    }
}

/**
 * 367：支持超链接的浏览器（JEditorPane 控件的应用）
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class HyperLinkTest extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 6450255764865674830L;
    private JPanel contentPane;
    private JTextField textField;
    private JEditorPane editorPane;

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
                    HyperLinkTest frame = new HyperLinkTest();
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
    public HyperLinkTest() {
        setTitle("\u652F\u6301\u8D85\u94FE\u63A5\u7684\u6D4F\u89C8\u5668");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);

        JLabel label = new JLabel("\u8F93\u5165\u7F51\u5740\uFF1A");
        label.setFont(new Font("΢���ź�", Font.PLAIN, 16));
        panel.add(label);

        textField = new JTextField();
        textField.setFont(new Font("΢���ź�", Font.PLAIN, 16));
        panel.add(textField);
        textField.setColumns(15);

        JButton button = new JButton("\u6D4F\u89C8");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setFont(new Font("΢���ź�", Font.PLAIN, 16));
        panel.add(button);

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        editorPane = new JEditorPane();
        editorPane.addHyperlinkListener(new HyperlinkListener() {
            public void hyperlinkUpdate(HyperlinkEvent e) {
                do_editorPane_hyperlinkUpdate(e);
            }
        });
        editorPane.setEditable(false);
        scrollPane.setViewportView(editorPane);
    }

    protected void do_button_actionPerformed(ActionEvent e) {
        try {
            editorPane.setPage(textField.getText()); // 显示用户输入的网址
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    protected void do_editorPane_hyperlinkUpdate(HyperlinkEvent e) {
        if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) { // 如果超链接被激活
            try {
                editorPane.setPage(e.getURL()); // 显示新的网页
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}

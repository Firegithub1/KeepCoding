/**
 * 365：自定义 RTF 文件查看器（JEditorPane 控件的应用）
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.rtf.RTFEditorKit;

public class RTFViewer extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 6707594969168483573L;
    private JPanel contentPane;
    private JTextField textField;
    private JEditorPane editorPane;
    private RTFEditorKit editor;

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
                    RTFViewer frame = new RTFViewer();
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
    public RTFViewer() {
        setTitle("RTF\u6587\u4EF6\u67E5\u770B\u5668");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout(0, 0));

        JPanel filePanel = new JPanel();
        panel.add(filePanel, BorderLayout.NORTH);

        JLabel fileName = new JLabel("\u6587\u4EF6\u540D\uFF1A");
        fileName.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        filePanel.add(fileName);

        textField = new JTextField();
        textField.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        filePanel.add(textField);
        textField.setColumns(15);

        JButton button = new JButton("\u6253\u5F00");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        filePanel.add(button);

        JScrollPane scrollPane = new JScrollPane();
        panel.add(scrollPane, BorderLayout.CENTER);

        editorPane = new JEditorPane();
        editorPane.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        scrollPane.setViewportView(editorPane);

        editor = new RTFEditorKit();
        editorPane.setEditorKit(editor);
    }

    protected void do_button_actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser(); // 创建文件选择器
        chooser.setMultiSelectionEnabled(false); // 不能支持多选
        chooser.setFileFilter(new FileNameExtensionFilter("RTF文件", "rtf")); // 过滤可选的文件
        int result = chooser.showOpenDialog(this); // 获得用户操作文件选择器的结果
        if (result == JFileChooser.APPROVE_OPTION) { // 如果用户选择打开
            File file = chooser.getSelectedFile(); // 获得选择的文件
            textField.setText(file.getName()); // 在文本域中设置文件名
            try {
                FileInputStream in = new FileInputStream(file); // 创建输入流对象
                editor.read(in, editorPane.getDocument(), 0); // 读入 RTF 文件
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (BadLocationException e1) {
                e1.printStackTrace();
            }
        }
    }
}

/**
 * 376：监视文件读入的进度（进度指示器的应用）
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ProgressMonitorInputStream;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ProgressMonitorInputStreamTest extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = -3507295831463384535L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextArea textArea;

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
                    ProgressMonitorInputStreamTest frame = new ProgressMonitorInputStreamTest();
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
    public ProgressMonitorInputStreamTest() {
        setTitle("\u76D1\u89C6\u6587\u4EF6\u8BFB\u53D6\u8FDB\u5EA6");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);

        JLabel label = new JLabel("\u6587\u4EF6\u540D\uFF1A");
        label.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        panel.add(label);

        textField = new JTextField();
        textField.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        panel.add(textField);
        textField.setColumns(15);

        JButton button = new JButton("\u6253\u5F00\u6587\u4EF6");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        panel.add(button);

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        scrollPane.setViewportView(textArea);
    }

    protected void do_button_actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser(); // 创建文件选择器
        chooser.setMultiSelectionEnabled(false); // 限制不能多选
        chooser.setFileFilter(new FileNameExtensionFilter("TXT文件", "txt")); // 过滤非 txt 文件
        int result = chooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) { // 如果用户选择了文件
            File file = chooser.getSelectedFile(); // 获得文件
            textField.setText(file.getName()); // 显示文件名称
            try {
                FileInputStream fileIn = new FileInputStream(file); // 创建文件输入流
                // 创建输入流进度显示器
                ProgressMonitorInputStream progressIn = new ProgressMonitorInputStream(this, "正在读入文件：" + file.getName(), fileIn);
                final Scanner in = new Scanner(progressIn);
                textArea.setText("");
                SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {

                    @Override
                    protected Void doInBackground() throws Exception {
                        while (in.hasNextLine()) { // 读入文本并在文本区中显示
                            textArea.append(in.nextLine());
                        }
                        in.close(); // 关闭输入流
                        return null;
                    }

                };
                worker.execute();

            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}

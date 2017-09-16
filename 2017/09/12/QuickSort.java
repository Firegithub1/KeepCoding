/**
 * 052：快速排序法（**必须重点掌握**）
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class QuickSort extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextArea textArea;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    QuickSort frame = new QuickSort();
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
    public QuickSort() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 311);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[]{233, 0};
        gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
        gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
        contentPane.setLayout(gbl_contentPane);

        textField = new JTextField();
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.insets = new Insets(0, 0, 5, 0);
        gbc_textField.gridx = 0;
        gbc_textField.gridy = 0;
        contentPane.add(textField, gbc_textField);

        JButton button_1 = new JButton("\u751F\u6210\u968F\u673A\u6570");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_1_actionPerformed(e);
            }
        });
        contentPane.add(button_1);
        GridBagConstraints gbc_button_1 = new GridBagConstraints();
        gbc_button_1.gridx = 0;
        gbc_button_1.gridy = 1;
        contentPane.add(button_1, gbc_button_1);

        JScrollPane scrollPane_1 = new JScrollPane();
        GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
        gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
        gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
        gbc_scrollPane_1.gridx = 0;
        gbc_scrollPane_1.gridy = 2;
        contentPane.add(scrollPane_1, gbc_scrollPane_1);

        textArea = new JTextArea();
        scrollPane_1.setViewportView(textArea);

        JButton button = new JButton("\u5FEB\u901F\u6392\u5E8F\u6CD5");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        GridBagConstraints gbc_button = new GridBagConstraints();
        gbc_button.gridx = 0;
        gbc_button.gridy = 3;
        contentPane.add(button, gbc_button);
    }

    private int[] array = new int[10];

    protected void do_button_1_actionPerformed(ActionEvent e) {
        Random random = new Random(); // 创建随机数对象
        String text = "";
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(90);
            text += (array[i] + "  ");
        }
        textField.setText(text);
    }

    protected void do_button_actionPerformed(ActionEvent e) {
        textArea.setText(""); // 清空文本域
        quickSort(array, 0, array.length - 1); // 调用快速排序算法
    }

    private void quickSort(int sortarray[], int lowIndex, int highIndex) {
        int lo = lowIndex; // 记录最小索引
        int hi = highIndex; // 记录最大索引
        int mid; // 记录分界点元素
        if (highIndex > lowIndex) {
            mid = sortarray[(lowIndex + highIndex) / 2]; // 确定中间分界点元素值
            while (lo <= hi) {
                while ((lo < highIndex) && (sortarray[lo] < mid))
                    ++lo; // 确定不大于分解元素值的最小索引
                while ((hi > lowIndex) && (sortarray[hi] > mid))
                    --hi; // 确定大鱼分解元素之的最大索引
                if (lo <= hi) { // 如果最小和最大索引没有重叠
                    swap(sortarray, lo, hi); // 交换两个索引的元素
                    ++lo; // 递增最小索引
                    --hi; // 递减最大索引
                }
            }
            if (lowIndex < hi) // 递归排序没有未分解元素
                quickSort(sortarray, lowIndex, hi);
            if (lo < highIndex) // 递归排序没有未分解元素
                quickSort(sortarray, lo, highIndex);
        }
    }

    private void swap(int swapArray[], int i, int j) {
        int temp = swapArray[i]; // 交换数组元素
        swapArray[i] = swapArray[j];
        swapArray[j] = temp;
        for (int k = 0; k < array.length; k++) { // 把数组元素显示到文本域控件中
            textArea.append(array[k] + "  ");
        }
        textArea.append("\n"); // 追加换行符
    }
}

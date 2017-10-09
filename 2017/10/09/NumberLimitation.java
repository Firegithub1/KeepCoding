/**
 * 095：查看数字的取值范围（Byte.MAX_VALUE,Byte.MIN_VALUE）
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NumberLimitation extends JFrame {

    private JPanel contentPane;
    private JLabel maxLabel;
    private JLabel minLabel;
    private JLabel maxResult;
    private JLabel minResult;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    NumberLimitation frame = new NumberLimitation();
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
    public NumberLimitation() {
        setTitle("数字的取值范围");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 196);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        maxLabel = new JLabel("最大值：");
        maxLabel.setBounds(10, 10, 202, 15);
        contentPane.add(maxLabel);

        minLabel = new JLabel("最小值");
        minLabel.setBounds(10, 46, 202, 15);
        contentPane.add(minLabel);

        maxResult = new JLabel("");
        maxResult.setBounds(222, 10, 202, 15);
        contentPane.add(maxResult);

        minResult = new JLabel("");
        minResult.setBounds(222, 46, 202, 15);
        contentPane.add(minResult);

        JRadioButton rdbtnByte = new JRadioButton("byte类型");
        rdbtnByte.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_rdbtnByte_actionPerformed(e);
            }
        });
        rdbtnByte.setBounds(10, 95, 121, 23);
        contentPane.add(rdbtnByte);

        JRadioButton rdbtnShort = new JRadioButton("short类型");
        rdbtnShort.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_rdbtnShort_actionPerformed(e);
            }
        });
        rdbtnShort.setBounds(133, 95, 121, 23);
        contentPane.add(rdbtnShort);

        JRadioButton rdbtnInt = new JRadioButton("int类型");
        rdbtnInt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_rdbtnInt_actionPerformed(e);
            }
        });
        rdbtnInt.setBounds(256, 95, 121, 23);
        contentPane.add(rdbtnInt);

        JRadioButton rdbtnLong = new JRadioButton("long类型");
        rdbtnLong.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_rdbtnLong_actionPerformed(e);
            }
        });
        rdbtnLong.setBounds(10, 124, 121, 23);
        contentPane.add(rdbtnLong);

        JRadioButton rdbtnFloat = new JRadioButton("float类型");
        rdbtnFloat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_rdbtnFloat_actionPerformed(e);
            }
        });
        rdbtnFloat.setBounds(133, 124, 121, 23);
        contentPane.add(rdbtnFloat);

        JRadioButton rdbtnDouble = new JRadioButton("double类型");
        rdbtnDouble.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_rdbtnDouble_actionPerformed(e);
            }
        });
        rdbtnDouble.setBounds(256, 124, 121, 23);
        contentPane.add(rdbtnDouble);

        ButtonGroup group = new ButtonGroup();
        group.add(rdbtnByte);
        group.add(rdbtnShort);
        group.add(rdbtnInt);
        group.add(rdbtnLong);
        group.add(rdbtnFloat);
        group.add(rdbtnDouble);
    }

    protected void do_rdbtnByte_actionPerformed(ActionEvent e) {
        maxLabel.setText("byte类型的最大值：");
        minLabel.setText("byte类型的最小值：");
        maxResult.setText(Byte.MAX_VALUE + "");
        minResult.setText(Byte.MIN_VALUE + "");
    }

    protected void do_rdbtnShort_actionPerformed(ActionEvent e) {
        maxLabel.setText("short类型的最大值：");
        minLabel.setText("short类型的最小值：");
        maxResult.setText(Short.MAX_VALUE + "");
        minResult.setText(Short.MIN_VALUE + "");
    }

    protected void do_rdbtnInt_actionPerformed(ActionEvent e) {
        maxLabel.setText("int类型的最大值：");
        minLabel.setText("int类型的最小值：");
        maxResult.setText(Integer.MAX_VALUE + "");
        minResult.setText(Integer.MIN_VALUE + "");
    }

    protected void do_rdbtnLong_actionPerformed(ActionEvent e) {
        maxLabel.setText("long类型的最大值：");
        minLabel.setText("long类型的最小值：");
        maxResult.setText(Long.MAX_VALUE + "");
        minResult.setText(Long.MIN_VALUE + "");
    }

    protected void do_rdbtnFloat_actionPerformed(ActionEvent e) {
        maxLabel.setText("float类型的最大值：");
        minLabel.setText("float类型的最小值：");
        maxResult.setText(Float.MAX_VALUE + "");
        minResult.setText(Float.MIN_VALUE + "");
    }

    protected void do_rdbtnDouble_actionPerformed(ActionEvent e) {
        maxLabel.setText("double类型的最大值：");
        minLabel.setText("double类型的最小值：");
        maxResult.setText(Double.MAX_VALUE + "");
        minResult.setText(Double.MIN_VALUE + "");
    }
}

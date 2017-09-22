/**
 * 067：用户名排序（没看懂，明天继续看）
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserSort extends JFrame {

    private JPanel contentPane;
    private String[] names = new String[]{"lzw", "anti", "zzk", "lyf", "liuxin", "dongdayong", "gulili", "coolBoy",
            "newgirl", "myBoy", "redsky", "pankaihua", "blueBoy"};
    private JButton button_1;
    private JButton button_2;
    private JList sourseList;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserSort frame = new UserSort();
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
    public UserSort() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        sourseList = new JList();
        sourseList.setToolTipText("");
        sourseList.setBounds(10, 10, 312, 241);
        sourseList.setModel(new DefaultListModel() {
            public int getSize() {
                return names.length;
            }

            public Object getElementAt(int index) {
                return names[index];
            }
        });
        contentPane.add(sourseList);

        button_1 = new JButton("\u5347\u5E8F");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button_1.setBounds(332, 10, 93, 31);
        contentPane.add(button_1);

        button_2 = new JButton("\u964D\u5E8F");
        button_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button_2.setBounds(332, 54, 93, 31);
        contentPane.add(button_2);

        JButton closeButton = new JButton("\u5173\u95ED");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_closeButton_actionPerformed(e);
            }
        });
        closeButton.setBounds(332, 95, 93, 31);
        contentPane.add(closeButton);
    }

    protected void do_button_actionPerformed(final ActionEvent e) {
        new Thread() {
            int[] indexs = new int[2];

            public void run() {
                for (int i = names.length; --i >= 0; ) {
                    indexs[0] = i;
                    for (int j = 0; j < i; j++) {
                        boolean compare = names[j].compareToIgnoreCase(names[j + 1]) > 0;
                        if (compare && e.getSource() == button_1 || !compare && e.getSource() == button_2) {
                            String temp = names[j];
                            names[j] = names[j + 1];
                            names[j + 1] = temp;
                            sourseList.repaint();
                        }
                        try {
                            sleep(100);
                        } catch (InterruptedException e1) {

                        }
                        indexs[1] = j;
                        sourseList.setSelectedIndices(indexs);
                    }

                }
            }
        }.start();
        sourseList.repaint();
    }

    protected void do_closeButton_actionPerformed(ActionEvent e) {
        dispose();
    }
}

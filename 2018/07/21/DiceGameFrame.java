/**
 * 091：掷骰子（游戏开发）
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class DiceGameFrame extends JFrame {
    private boolean flag = false; // 用于标识压大压小的变量，true表示压大，false表示压小
    private int v1 = 0; // 第一个骰子的点数
    private int v2 = 0; // 第二个骰子的点数
    private int v3 = 0; // 第三个骰子的点数
    private int stopIndex = 0; // 当stopIndex为50时，显示最终的点数
    private final JLabel lb_dice_1 = new JLabel();
    private final JLabel lb_dice_2 = new JLabel();
    private final JLabel lb_dice_3 = new JLabel();
    final JLabel lb_follow = new JLabel();
    Thread thread = null; // 定义判断骰子点数的线程
    Thread okThread = null; // 定义确认赌注的线程
    // 人民币面值
    private int ten = 10;
    private int twenty = 20;
    private int fifty = 50;
    private int hundred = 100;
    // 人民币面值标记
    private boolean tenFlag = false;
    private boolean twentyFlag = false;
    private boolean fiftyFlag = false;
    private boolean hundredFlag = false;
    // 人民币标记
    private boolean moneyFlag = false;
    // 加倍下注的标记
    private boolean doubleFlag = false;
    // 人民币车累计金额
    int totalMoney = 0;
    // 确认下注标记
    private boolean ok = false;

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DiceGameFrame frame = new DiceGameFrame();
        frame.setVisible(true);
    }

    public DiceGameFrame() {
        super();
        setTitle("掷骰子");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(673, 577);
        final BackgroundPanel3 bgPanel = new BackgroundPanel3();
        bgPanel.setImage(SwingResourceManager.getImage(DiceGameFrame.class,
                "/image/background.jpg"));
        getContentPane().add(bgPanel, BorderLayout.CENTER);

        lb_dice_1.setIcon(SwingResourceManager.getIcon(DiceGameFrame.class,
                "/icon/1.png"));
        lb_dice_1.setBounds(253, 143, 57, 55);
        bgPanel.add(lb_dice_1);

        lb_dice_3.setIcon(SwingResourceManager.getIcon(DiceGameFrame.class,
                "/icon/1.png"));
        lb_dice_3.setBounds(304, 231, 57, 55);
        bgPanel.add(lb_dice_3);

        lb_dice_2.setIcon(SwingResourceManager.getIcon(DiceGameFrame.class,
                "/icon/1.png"));
        lb_dice_2.setBounds(354, 143, 57, 55);
        bgPanel.add(lb_dice_2);

        final JButton button = new JButton();
        button.setIcon(SwingResourceManager.getIcon(DiceGameFrame.class,
                "/icon/小.png"));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent arg0) {
                if (ok == true) {
                    if (thread == null) {
                        flag = false; // 为false表示压小
                        thread = new Thread(new DiceThread()); // 创建判断骰子点数的线程
                        thread.start(); // 启动线程
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "请下注后进行确认。");
                }
            }
        });
        button.setBounds(216, 337, 106, 28);
        bgPanel.add(button);

        final JButton button_1 = new JButton();
        button_1.setIcon(SwingResourceManager.getIcon(DiceGameFrame.class,
                "/icon/大.png"));
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent arg0) {
                if (ok == true) {
                    if (thread == null) {
                        flag = true; // 为true表示压大
                        thread = new Thread(new DiceThread()); // 创建判断骰子点数的线程
                        thread.start(); // 启动线程
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "请下注后进行确认。");
                }
            }
        });
        button_1.setBounds(339, 337, 106, 28);
        bgPanel.add(button_1);

        final JButton btn_10 = new JButton();
        btn_10.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent arg0) {
                if (!tenFlag) {
                    // 人民币面值标记
                    tenFlag = true;
                    // 人民币标记
                    moneyFlag = true;
                    // 人民币车累计金额
                    totalMoney = totalMoney + ten;
                }
            }
        });
        btn_10.setText("10元");
        btn_10.setBounds(215, 386, 106, 28);
        bgPanel.add(btn_10);

        final JButton btn_20 = new JButton();
        btn_20.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent arg0) {
                if (!twentyFlag) {
                    // 人民币面值标记
                    twentyFlag = true;
                    // 人民币标记
                    moneyFlag = true;
                    // 人民币车累计金额
                    totalMoney = totalMoney + twenty;
                }
            }
        });
        btn_20.setText("20元");
        btn_20.setBounds(339, 386, 106, 28);
        bgPanel.add(btn_20);

        final JButton btn_50 = new JButton();
        btn_50.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent arg0) {
                if (!fiftyFlag) {
                    // 人民币面值标记
                    fiftyFlag = true;
                    // 人民币标记
                    moneyFlag = true;
                    // 人民币车累计金额
                    totalMoney = totalMoney + fifty;
                }
            }
        });
        btn_50.setText("50元");
        btn_50.setBounds(216, 420, 106, 28);
        bgPanel.add(btn_50);

        final JButton btn_100 = new JButton();
        btn_100.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent arg0) {
                if (!hundredFlag) {
                    // 人民币面值标记
                    hundredFlag = true;
                    // 人民币标记
                    moneyFlag = true;
                    // 人民币车累计金额
                    totalMoney = totalMoney + hundred;
                }
            }
        });
        btn_100.setText("100元");
        btn_100.setBounds(339, 420, 106, 28);
        bgPanel.add(btn_100);

        final JButton btn_double = new JButton();
        btn_double.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent arg0) {
                if (!doubleFlag) {
                    if (moneyFlag == true) {
                        totalMoney = totalMoney * 2;
                        doubleFlag = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "选择人民币后才能加倍下注。");
                    }
                }
            }
        });
        btn_double.setText("加倍");
        btn_double.setBounds(339, 454, 106, 28);
        bgPanel.add(btn_double);

        final JButton btn_ok = new JButton();
        btn_ok.setIcon(SwingResourceManager.getIcon(DiceGameFrame.class,
                "/icon/xiazhu.png"));
        btn_ok.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent arg0) {
                if (moneyFlag == true) { // 如果玩家确认下注了就执行下面的代码
                    ok = true;
                    if (okThread == null) {
                        okThread = new Thread(new OkAnteThread()); // 创建确认赌注的线程对象
                    }
                    if (!okThread.isAlive()) {
                        okThread.start(); // 启动线程对象
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "请下注后进行确认。");
                }
            }
        });
        btn_ok.setBounds(339, 505, 106, 28);
        bgPanel.add(btn_ok);

        lb_follow.setFont(new Font("", Font.BOLD, 16));
        lb_follow.setForeground(new Color(0, 0, 255));
        lb_follow.setText("跟了......");
        lb_follow.setBounds(121, 478, 137, 55);
        lb_follow.setVisible(false);
        bgPanel.add(lb_follow);

    }

    /**
     * @author 张振坤
     * 判断骰子点数的线程
     */
    private class DiceThread implements Runnable {
        public void run() {
            while (true) {
                stopIndex++;
                v1 = (int) (Math.random() * 6 + 1); // 随机产生第一个骰子的点数
                v2 = (int) (Math.random() * 6 + 1); // 随机产生第二个骰子的点数
                v3 = (int) (Math.random() * 6 + 1); // 随机产生第三个骰子的点数
                // 显示骰子的图片
                lb_dice_1.setIcon(SwingResourceManager.getIcon(
                        DiceGameFrame.class, "/icon/" + v1 + ".png"));
                lb_dice_2.setIcon(SwingResourceManager.getIcon(
                        DiceGameFrame.class, "/icon/" + v2 + ".png"));
                lb_dice_3.setIcon(SwingResourceManager.getIcon(
                        DiceGameFrame.class, "/icon/" + v3 + ".png"));
                int totalValues = v1 + v2 + v3; // 骰子的点数总和
                if (stopIndex == 50) { // 当stopIndex为50时，显示消息框，并提示最终的点数
                    if (flag == true) {
                        if (totalValues > 9) { // 骰子的点数为大时显示的提示信息
                            JOptionPane.showMessageDialog(null, "点数是："
                                    + totalValues + "，大。\n玩家赢！！！\n总钱数：人民币"
                                    + totalMoney + "元");
                        } else {
                            JOptionPane.showMessageDialog(null, "点数是："
                                    + totalValues + "，小。\n庄家赢！！！\n总钱数：人民币"
                                    + totalMoney + "元");
                        }
                    } else {
                        if (totalValues <= 9) { // 骰子的点数为小时显示的提示信息
                            JOptionPane.showMessageDialog(null, "点数是："
                                    + totalValues + "，小。\n玩家赢！！！\n总钱数：人民币"
                                    + totalMoney + "元");
                        } else {
                            JOptionPane.showMessageDialog(null, "点数是："
                                    + totalValues + "，大。\n庄家赢！！！\n总钱数：人民币"
                                    + totalMoney + "元");
                        }
                    }
                    thread = null;
                    stopIndex = 0;
                    // 人民币面值标记
                    tenFlag = false;
                    twentyFlag = false;
                    fiftyFlag = false;
                    hundredFlag = false;
                    // 加倍下注的标记
                    doubleFlag = false;
                    // 人民币标记
                    moneyFlag = false;
                    // 人民币车累计金额
                    totalMoney = 0;
                    // 确认下注标记
                    ok = false;
                    break;
                }
                try {
                    Thread.sleep(20);
                } catch (Exception ex) {
                    System.out.println(flag);
                }
            }
        }
    }

    /**
     * @author 张振坤
     * 确认赌注的线程
     */
    private class OkAnteThread implements Runnable {
        public void run() {
            boolean followFlag = true; // 使文字闪耀的标记变量
            while (true) {
                if (moneyFlag == true && ok == true) { // 如果玩家确认下注了就执行下面的语句，显示跟了的信息
                    int count = 0;
                    while (true && followFlag == true) {
                        count++;
                        lb_follow.setVisible(true);
                        // 实现文字的闪耀效果
                        if (count % 2 == 1) {
                            lb_follow.setForeground(new Color(255, 0, 0));
                        } else {
                            lb_follow.setForeground(new Color(0, 0, 255));
                        }
                        if (count > 20) {
                            lb_follow.setVisible(false); // 隐藏文字闪耀的标签
                            followFlag = false; // 把使文字闪耀的标记变量设置为false
                            break;
                        }
                        try {
                            Thread.sleep(100);
                        } catch (Exception ex) {

                        }
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (Exception ex) {
                        System.out.println(flag);
                    }
                    lb_follow.setVisible(false); // 隐藏文字闪耀的标签
                    okThread = null; // 释放线程资源
                    break;
                }
            }
        }
    }
}

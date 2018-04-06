import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class JClock extends JLabel implements Runnable {
    // 3个指针的粗细
    private static final BasicStroke HOURS_POINT_WIDTH = new BasicStroke(5);
    private static final BasicStroke MINUETES_POINT_WIDTH = new BasicStroke(3);
    private static final BasicStroke SEC_POINT_WIDTH = new BasicStroke(2);
    private ImageIcon background;
    private int centerX; // 中心坐标
    private int centerY;
    private final static int secLen = 60; // 指针长度
    private final static int minuesLen = 55; // 指针长度
    private final static int hoursLen = 36; // 指针长度

    /**
     * 构造方法
     */
    public JClock() {
        setOpaque(false);
        background = new ImageIcon(getClass().getResource("Core.data"));
        int iconWidth = background.getIconWidth();
        centerX = iconWidth / 2;
        int iconHeight = background.getIconHeight();
        centerY = iconHeight / 2;
        setPreferredSize(new Dimension(iconWidth, iconHeight));
        new Thread(this).start();
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();// 转换为2D绘图上下文
        Composite composite = g2.getComposite();// 保存原有合成规则
        g2.setComposite(AlphaComposite.SrcOver.derive(0.6f));// 设置60%透明的合成规则
        Calendar calendar = Calendar.getInstance();
        drawClock(g2, calendar);// 绘制时钟
        g2.setComposite(composite);// 恢复原有合成规则
        g2.drawImage(background.getImage(), 0, 0, this);// 绘制背景图
        g2.dispose();
    }

    private void drawClock(Graphics2D g2, Calendar calendar) {
        int millisecond = calendar.get(Calendar.MILLISECOND);
        int sec = calendar.get(Calendar.SECOND);
        int minutes = calendar.get(Calendar.MINUTE);
        int hours = calendar.get(Calendar.HOUR);
        double secAngle = (60 - sec) * 6 - (millisecond / 150); // 秒针角度
        int minutesAngle = (60 - minutes) * 6;// 分针角度
        int hoursAngle = (12 - hours) * 360 / 12 - (minutes / 2);// 时针角度
        // 计算秒针、分针、时针指向坐标
        int secX = (int) (secLen * Math.sin(Math.toRadians(secAngle)));
        int secY = (int) (secLen * Math.cos(Math.toRadians(secAngle)));
        int minutesX = (int) (minuesLen * Math
                .sin(Math.toRadians(minutesAngle)));
        int minutesY = (int) (minuesLen * Math
                .cos(Math.toRadians(minutesAngle)));
        int hoursX = (int) (hoursLen * Math.sin(Math.toRadians(hoursAngle)));
        int hoursY = (int) (hoursLen * Math.cos(Math.toRadians(hoursAngle)));
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        // 分别绘制时针、分针、秒针
        g2.setColor(Color.BLACK);
        g2.setStroke(HOURS_POINT_WIDTH);
        g2.drawLine(centerX, centerY, centerX - hoursX, centerY - hoursY);
        g2.setStroke(MINUETES_POINT_WIDTH);
        g2.setColor(new Color(0x2F2F2F));
        g2.drawLine(centerX, centerY, centerX - minutesX, centerY - minutesY);
        g2.setColor(Color.RED);
        g2.setStroke(SEC_POINT_WIDTH);
        g2.drawLine(centerX, centerY, centerX - secX, centerY - secY);
        // 绘制3个指针的中心园
        g2.fillOval(centerX - 5, centerY - 5, 10, 10);
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (getRootPane() != null) {
                    JFrame main = (JFrame) getRootPane().getParent();
                    if (main != null && main.isVisible()) {
                        EventQueue.invokeLater(new Runnable() {
                            public void run() {
                                JClock.this.repaint();
                            }
                        });
                    }
                }
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

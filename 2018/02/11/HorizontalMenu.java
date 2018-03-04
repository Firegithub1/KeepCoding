import javax.swing.*;
import java.awt.*;

public class HorizontalMenu extends JMenu {

    private static final long serialVersionUID = 1943739671316999698L;

    public HorizontalMenu(String label) {
        super(label); // 调用父类的构造方法
        JPopupMenu popupMenu = getPopupMenu(); // 获得菜单对象的弹出菜单
        popupMenu.setLayout(new BoxLayout(popupMenu, BoxLayout.LINE_AXIS)); // 修改布局管理器
    }

    public Dimension getMinimumSize() {
        return getPreferredSize(); // 将控件的最小范围设置成显示控件的最佳范围
    }

    public void setPopupMenuVisible(boolean b) {
        if (b != isPopupMenuVisible()) {
            if ((b == true) && isShowing()) { // 如果菜单处于显示状态
                if (getParent() instanceof JPopupMenu) {
                    getPopupMenu().show(this, 0, getHeight()); // 修改弹出菜单的显示位置
                } else {
                    getPopupMenu().show(this, getWidth(), 0); // 修改弹出菜单的显示位置
                }
            } else {
                getPopupMenu().setVisible(false); // 设置弹出菜单不可见
            }
        }
    }
}

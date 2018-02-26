import java.awt.*;

public class LadderLayout implements LayoutManager {
    @Override
    public void removeLayoutComponent(Component comp) {

    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        return parent.getPreferredSize();
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return parent.getMinimumSize();
    }

    @Override
    public void layoutContainer(Container parent) {
        Insets insets = parent.getInsets(); // 获得容器默认边框对象
        int maxWidth = parent.getWidth() - (insets.left + insets.right); // 获得最大可用宽度
        int maxHeight = parent.getHeight() - (insets.top + insets.bottom); // 获得最大可用高度
        int count = parent.getComponentCount(); // 获得容器中控件的个数
        for (int i = 0; i < count; i++) { // 依次设置所有可见控件的位置和大小
            Component component = parent.getComponent(i);
            if (component.isVisible()) {
                Dimension size = component.getPreferredSize(); // 大小使用其最佳大小
                int x = maxWidth / count * i; // 将宽度分成 count 份根据 i 值调整 X 坐标
                int y = maxHeight / count * i; // 将高度分成 count 份根据 i 值调整 Y 坐标
                component.setBounds(x, y, size.width, size.height); // 重新设置控件的位置和大小
            }
        }
    }

    @Override
    public void addLayoutComponent(String name, Component comp) {

    }
}

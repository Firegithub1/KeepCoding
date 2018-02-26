import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;

public class CircleLayout implements LayoutManager {

    @Override
    public void addLayoutComponent(String name, Component comp) {

    }

    @Override
    public void layoutContainer(Container parent){
        double centerX=parent.getBounds().getCenterX(); // 获得容器中心的X坐标
        double centerY=parent.getBounds().getCenterY(); // 获得容器中心的Y坐标
        Insets insets=parent.getInsets(); // 获得容器默认边框对象
        double horizon=centerX-insets.left; // 获得水平可用长度的一半
        double vertical=centerY-insets.top; // 获得垂直可用长度的一半
        double radius=horizon>vertical?vertical:horizon; // 取小的为圆形半径
        int count=parent.getComponentCount(); // 获得容器中控件的个数
        for (int i = 0; i < count; i++) { // 依次设置所有可见控件的位置和大小
            Component component=parent.getComponent(i);
            if(component.isVisible()){
                Dimension size=component.getPreferredSize(); // 大小使用其最佳大小
                double angle=2*Math.PI*i/count; // 获得角度的大小
                double x=centerX+radius*Math.sin(angle); // 获得圆周点的X坐标
                double y=centerY-radius*Math.cos(angle); // 获得圆周点的Y坐标
                component.setBounds((int)x-size.width/2,(int )y-size.height/2,size.width,size.height); // 重新设置控件的位置和大小
            }
        }
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return parent.getMinimumSize();
    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        return parent.getPreferredSize();
    }

    @Override
    public void removeLayoutComponent(Component comp) {
    }

}

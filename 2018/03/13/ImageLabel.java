import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ImageLabel extends JLabel implements ChangeListener {
    private JSpinner spinner;
    private ImageIcon image;

    public ImageLabel(JSpinner spinner) {
        this.spinner = spinner;
        this.image = (ImageIcon) spinner.getValue(); // 获得微调控件模型中保存的图标
        spinner.addChangeListener(this); // 为微调控件增加监听
    }

    @Override
    public Icon getIcon() {
        return image; // 获得图标
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        image = (ImageIcon) spinner.getValue(); // 对微调控件的变化事件做出响应，更换图标
        setIcon(image);
    }
}

import javax.swing.*;
import java.awt.*;


public class IpField extends JPanel {
    private CText textField;
    private CText textField_1;
    private CText textField_2;
    private CText textField_3;

    public IpField(){
        setPreferredSize(new Dimension(141,25));
        setBorder(UIManager.getBorder("TextField.border"));
        setBackground(UIManager.getColor("TextField.background"));
        setSize(200,25);
        setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        textField=new CText();
        add(textField);
        JLabel label=new JLabel(".");
        add(label);
        textField_1=new CText();
        add(textField_1);
        JLabel label_3=

    }
}

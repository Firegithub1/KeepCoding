import javax.swing.*;
import java.awt.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpField extends JPanel {
    private CText textField;
    private CText textField_1;
    private CText textField_2;
    private CText textField_3;

    public IpField() {
        setPreferredSize(new Dimension(141, 25));
        setBorder(UIManager.getBorder("TextField.border"));
        setBackground(UIManager.getColor("TextField.background"));
        setSize(200, 25);
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        textField = new CText();
        add(textField);
        JLabel label = new JLabel(".");
        add(label);
        textField_1 = new CText();
        add(textField_1);
        JLabel label_3 = new JLabel(".");
        add(label_3);
        textField_2 = new CText();
        add(textField_2);
        JLabel label_2 = new JLabel(".");
        add(label_2);
        textField_3 = new CText();
        add(textField_3);
        setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]
                {textField, textField_1, textField_2, textField_3}));
    }

    public String getIpString() {
        String ipstr = textField + "." + textField_1 + "." + textField_2 + "." + textField_3;
        return ipstr;
    }

    public InetAddress getIpAddress() {
        InetAddress ia = null;
        try {
            ia = InetAddress.getByName(getIpString());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return ia;
    }
}

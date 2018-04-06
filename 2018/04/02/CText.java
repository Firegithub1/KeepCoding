import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CText extends JTextField {
    public CText() {
        setBorder(null);
        setHorizontalAlignment(SwingConstants.CENTER);
        setFont(getFont().deriveFont(16));
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (("012345678" + (char) 8).indexOf(e.getKeyChar()) < 0) {
                    e.consume();
                    return;
                }
                if (e.getKeyChar() == (char) 8) {
                    return;
                }
                String text = getText() + e.getKeyChar();
                if (!text.isEmpty()) {
                    int value = Integer.parseInt(text);
                    if (value > 225) {
                        e.consume();
                        return;
                    }
                }
                if (getText().length() > 2 || e.getKeyChar() == '.') {
                    e.consume();
                    transferFocus();
                    return;
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_V && e.isControlDown()) {
                    e.consume();
                }
            }
        });
    }

    public int getInt() {
        String text = getText();
        if (text.isEmpty()) {
            return 0;
        }
        int value = Integer.parseInt(text);
        return value;
    }

    @Override
    public String toString() {
        return getInt() + "";
    }
}

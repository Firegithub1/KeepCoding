import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import java.awt.*;

public class ColorPane extends JTextPane {
    public void append(Color color, String key) {
        StyleContext context = StyleContext.getDefaultStyleContext(); // 创建样式
        AttributeSet style = context.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, color);
        int length = getText().length(); // 获得文档的长度
        setCaretPosition(length); // 将光标定位与文档的末尾，这样新插入的文档总是从最后插入
        setCharacterAttributes(style, true); // 应用样式
        replaceSelection(key); // 设置文本的内容
    }
}

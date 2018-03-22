import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.util.Stack;

public class ParenthesisMatcher extends JTextPane {
    private AttributeSet mismatch; // 不匹配的样式
    private AttributeSet match; // 匹配的样式

    public ParenthesisMatcher() {
        StyleContext context = StyleContext.getDefaultStyleContext();
        mismatch = context.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, Color.RED); // 不匹配的设置成红色
        match = context.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, Color.BLUE); // 匹配的设置成蓝色
    }

    public void validate() {
        StyledDocument document = getStyledDocument();
        String text = null;
        try {
            text = document.getText(0, document.getLength()); // 获得文档中的内容
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
        Stack<String> stack = new Stack<>(); // 使用栈结构保存括号
        for (int i = 0; i < text.length(); i++) { // 遍历整个文档
            char c = text.charAt(i);
            if (c == '(' || c == '[' || c == '{') { // 如果是左括号就入栈
                stack.push("" + c + i);
                document.setCharacterAttributes(i, 1, match, false); // 设置文档的样式
            }
            if (c == ')' || c == ']' || c == '}') {
                String peek = stack.empty() ? "." : (String) stack.peek();
                if (match(peek.charAt(0), c)) { // 如果是右括号且和栈中的括号匹配就出栈
                    stack.pop();
                    document.setCharacterAttributes(i, 1, match, false); // 设置文档的样式
                } else {
                    document.setCharacterAttributes(i, 1, mismatch, false); // 设置文档的样式
                }
            }
        }
        while (!stack.empty()) { // 如果栈非空则剩下的全是为匹配的
            String pop = (String) stack.pop();
            int offset = Integer.parseInt(pop.substring(1));
            document.setCharacterAttributes(offset, 1, mismatch, false); // 设置文档的样式
        }
    }

    @Override
    public void replaceSelection(String content) { // 删除文档的文字颜色属性
        getInputAttributes().removeAttribute(StyleConstants.Foreground);
        super.replaceSelection(content);
    }

    public boolean match(char left, char right) { // 检查括号是否匹配
        if ((left == '(') && (right == ')')) {
            return true;
        }
        if ((left == '[') && (right == ']')) {
            return true;
        }
        if ((left == '{') && (right == '}')) {
            return true;
        }
        return false;
    }
}

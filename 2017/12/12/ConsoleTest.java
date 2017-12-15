/**
 * 203：从控制台输入密码（System 类的使用）
 */

import java.io.Console;
import java.util.Arrays;

public class ConsoleTest {
    public static void main(String[] args) {
        Console console = System.console();
        String username = console.readLine("请输入用户名：");
        char[] password = console.readPassword("请输入密码：");
        System.out.println("您的用户名是：" + username);
        System.out.println("您的密码是：");
        for (char c : password) {
            System.out.print(c);
        }
        Arrays.fill(password, 'a');
    }
}

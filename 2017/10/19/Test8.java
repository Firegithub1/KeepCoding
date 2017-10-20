/**
 * 107：使用字符串输出对象（重写 toString()）
 */

import java.awt.*;

public class Test8 {
    public static void main(String[] args) {
        Cat4 cat1 = new Cat4("Java", 12, 21, Color.black);
        Cat4 cat2 = new Cat4("C++", 12, 21, Color.white);
        Cat4 cat3 = new Cat4("Java", 12, 21, Color.black);
        System.out.println("猫咪 1 号：" + cat1);
        System.out.println("猫咪 2 号：" + cat2);
        System.out.println("猫咪 3 号：" + cat3);
    }
}

import java.awt.*;

/**
 * 108：简化 toString() 方法的重写（ToStringBuilder 类）
 */

public class Test9 {
    public static void main(String[] args) {
        Cat5 cat1 = new Cat5("Java", 12, 21, Color.black);
        Cat5 cat2 = new Cat5("C++", 12, 21, Color.white);
        Cat5 cat3 = new Cat5("Java", 12, 21, Color.black);
        System.out.println("猫咪 1 号：" + cat1);
        System.out.println("猫咪 2 号：" + cat2);
        System.out.println("猫咪 3 号：" + cat3);
    }
}

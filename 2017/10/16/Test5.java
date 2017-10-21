/**
 * 104：简化 equals() 方法的重写(EqualsBuilder 类)
 */

import java.awt.*;

public class Test5 {
    public static void main(String[] args) {
        Cat1 cat1 = new Cat1("Java", 12, 21, Color.BLACK);
        Cat1 cat2 = new Cat1("C++", 12, 21, Color.WHITE);
        Cat1 cat3 = new Cat1("Java", 12, 21, Color.BLACK);
        System.out.println("猫咪 1 号：" + cat1);
        System.out.println("猫咪 2 号：" + cat2);
        System.out.println("猫咪 3 号：" + cat3);
        System.out.println("猫咪 1 号是否与猫咪 2 号相同：" + cat1.equals(cat2));
        System.out.println("猫咪 1 号是否与猫咪 3 号相同：" + cat1.equals(cat3));
    }
}

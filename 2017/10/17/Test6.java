/**
 * 105：重新计算对象的哈希吗（重写hashCode()）
 */

import java.awt.*;

public class Test6 {
    public static void main(String[] args) {
        Cat2 cat1 = new Cat2("Java", 12, 21, Color.BLACK);
        Cat2 cat2 = new Cat2("C++", 12, 21, Color.WHITE);
        Cat2 cat3 = new Cat2("Java", 12, 21, Color.BLACK);
        System.out.println("猫咪 1 号的哈希吗：" + cat1.hashCode());
        System.out.println("猫咪 2 号的哈希吗：" + cat2.hashCode());
        System.out.println("猫咪 3 号的哈希吗：" + cat3.hashCode());
        System.out.println("猫咪 1 号是否与猫咪 2 号相同：" + cat1.equals(cat2));
        System.out.println("猫咪 1 号是否与猫咪 3 号相同：" + cat1.equals(cat3));
    }
}

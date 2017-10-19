/**
 * 103：两只完全相同的宠物
 */

import java.awt.*;

public class Test4 {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Java", 12, 21, Color.black);
        Cat cat2 = new Cat("Java", 12, 21, Color.white);
        Cat cat3 = new Cat("Java", 12, 21, Color.black);
        System.out.println("猫咪 1 号：" + cat1);
        System.out.println("猫咪 2 号：" + cat2);
        System.out.println("猫咪 3 号：" + cat3);
        System.out.println("猫咪 1 号是否与猫咪 2 号相同：" + cat1.equals(cat2));
        System.out.println("猫咪 1 号是否与猫咪 3 号相同：" + cat1.equals(cat3));
    }
}

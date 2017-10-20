import java.awt.*;

/**
 * 106：简化 hashCode() 方法的重写
 */


public class Test7 {
    public static void main(String[] args) {
        Cat3 cat1 = new Cat3("Java", 12, 21, Color.black);
        Cat3 cat2 = new Cat3("C++", 12, 21, Color.white);
        Cat3 cat3 = new Cat3("Java", 12, 21, Color.black);
        System.out.println("猫咪 1 号：" + cat1);
        System.out.println("猫咪 2 号：" + cat2);
        System.out.println("猫咪 3 号：" + cat3);
        System.out.println("猫咪 1 号是否与猫咪 2 号相同：" + cat1.equals(cat2));
        System.out.println("猫咪 1 号是否与猫咪 3 号相同：" + cat1.equals(cat3));
    }
}

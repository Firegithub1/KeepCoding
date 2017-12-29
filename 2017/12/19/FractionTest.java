/**
 * 220：分数的常见运算（Commons Lang 组件简介）
 */

import org.apache.commons.lang.math.Fraction;

public class FractionTest {
    public static void main(String[] args) {
        Fraction fraction1 = Fraction.getFraction(1, 3);
        Fraction fraction2 = Fraction.getFraction(1, 5);
        Fraction addition = fraction1.add(fraction2);
        System.out.println("1/3 + 1/5 = " + addition);
        Fraction subtraction = fraction1.subtract(fraction2);
        System.out.println("1/3 - 1/5 = " + subtraction);
        Fraction multiplication = fraction1.multiplyBy(fraction2);
        System.out.println("1/3 * 1/5 = " + multiplication);
        Fraction division = fraction1.divideBy(fraction2);
        System.out.println("1/3 / 1/5 = " + division);
        Fraction invert = fraction1.invert();
        System.out.println("1/3 的倒数：" + invert);
        Fraction pow = fraction1.pow(2);
        System.out.println("1/3 的平方：" + pow);
    }
}

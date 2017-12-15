/**
 * 210：高精度浮点运算（其他常用类的使用）
 */

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MathUtil5 {
    public static void main(String[] args) {
        BigDecimal number1 = new BigDecimal("1.2345");
        BigDecimal number2 = new BigDecimal("5.4321");
        BigDecimal addition = number1.add(number2);
        BigDecimal subtraction = number1.subtract(number2);
        BigDecimal multiplication = number1.multiply(number2);
        BigDecimal division = number1.divide(number2, RoundingMode.HALF_UP);
        System.out.println("高精度浮点数 number1：" + number1);
        System.out.println("高精度浮点数 number2：" + number2);
        System.out.println("高精度浮点数加法：" + addition);
        System.out.println("高精度浮点数减法：" + subtraction);
        System.out.println("高精度浮点数乘法：" + multiplication);
        System.out.println("高精度浮点数除法：" + division);
    }
}

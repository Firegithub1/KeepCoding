/**
 * 209：高精度整数运算（其他常用类的使用）
 */

import java.math.BigInteger;

public class MathUtil4 {
    public static void main(String[] args) {
        BigInteger number1 = new BigInteger("12345");
        BigInteger number2 = new BigInteger("54321");
        BigInteger addition = number1.add(number2);
        BigInteger subtraction = number1.subtract(number2);
        BigInteger multiplication = number1.multiply(number2);
        BigInteger division = number1.divide(number2);
        System.out.println("高精度整数 number1：" + number1);
        System.out.println("高精度整数 number2：" + number2);
        System.out.println("高精度整数加法：" + addition);
        System.out.println("高精度整数减法：" + subtraction);
        System.out.println("高精度整数乘法：" + multiplication);
        System.out.println("高精度整数除法：" + division);
    }
}

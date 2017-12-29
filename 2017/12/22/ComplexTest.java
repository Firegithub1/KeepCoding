/**
 * 226：复数的常见运算（Commons Math 组件简介）
 */

import org.apache.commons.math.complex.Complex;

public class ComplexTest {
    public static void main(String[] args) {
        Complex complex1 = new Complex(1.0, 3.0); // 复数的初始化
        System.out.println("复数 complex1 是：" + getComplex(complex1));
        Complex complex2 = new Complex(2.0, 4.0);
        System.out.println("复数 complex2 是：" + getComplex(complex2));
        Complex addition = complex1.add(complex2);
        System.out.println("加法运算的结果是：" + getComplex(addition));
        Complex subtraction = complex1.subtract(complex2);
        System.out.println("减法运算的结果是：" + getComplex(subtraction));
        Complex multiplication = complex1.multiply(complex2);
        System.out.println("乘法运算的结果是：" + getComplex(multiplication));
        Complex division = complex1.divide(complex2);
        System.out.println("除法运算的结果是：" + getComplex(division));

    }

    public static String getComplex(Complex complex) { // 自定义输出复数的方法
        return complex.getReal() + "+" + complex.getImaginary() + "i";
    }
}

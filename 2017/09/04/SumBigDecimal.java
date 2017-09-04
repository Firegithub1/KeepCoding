/**
 * 036：用while循环计算 1+1/2!+1/3!+…1/20!
 *
 * 使用BogDecimal类完成大数字与高精度运算。
 * 对于高精度要求或者运算数较大的计算，
 * 应该使用BogDecimal类实现，
 * 否则Java基本类型的数据无法保证浮点数的精度，
 * 也无法对超出其表示范围的数字进行运算。
 */

import java.math.BigDecimal;

public class SumBigDecimal {
    public static void main(String[] args) {
        BigDecimal sum = new BigDecimal(0.0); // 和
        BigDecimal factorial = new BigDecimal(1.0); // 阶乘项的计算结果
        int i = 1; // 循环增量
        while (i <= 20) {
            sum = sum.add(factorial); // 累加各项阶乘的和
            ++i;
            factorial = factorial.multiply(new BigDecimal(1.0 / i)); // 计算阶乘项
        }
        System.out.println("1+1/2!+1/3!+...1/20! 的计算结果是：\n" + sum); // 输出计算结果
    }
}

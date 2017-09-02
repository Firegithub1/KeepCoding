/**
 * 025：更精确地使用浮点数（BidDecimal）
 * <p>
 * 二进制无法精确地表达所有的小数，
 * 所以使用基本数据类型进行小数运算会有一些误差，
 * 本实例将通过BigDecimal类实现精确的小数运算。
 * <p>
 * 为什么我运算的结果都是：0.8999999999999999，并没有精确多少啊，结果相同！！！愁！
 */

import java.math.BigDecimal;

public class AccuratelyFloat {
    public static void main(String[] args) {
        double money = 2; // 现有金额
        double price = 1.1; // 商品价格
        double result = money - price;
        System.out.println("非精确计算");
        System.out.println("剩余金额：" + result); // 输出运算结果
        // 精确浮点数的解决方法
        BigDecimal money1 = new BigDecimal("2");
        BigDecimal price1 = new BigDecimal("1.1");
        BigDecimal result1 = money1.subtract(price1);
        System.out.println("精确计算");
        System.out.println("剩余金额：" + result); // 输出精确结果
    }
}

/*
加法：
public BigDecimal add(BigDecimal augend)

减法：
public BigDecimal subtract(BigDecimal subtrahend)

乘法：
public BigDecimal multiply(BigDecimal multiplicand)

除法：
public BigDecimal divide(BigDecimal divisor)
 */

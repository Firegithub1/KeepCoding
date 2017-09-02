/**
 * 027：不用乘法运算符实现 2×16
 * <p>
 * 一个整数每次执行位移运算中的左移运算n次，
 * 相当于这个整数乘以2的n次方。
 * 相反，如果右移n次运算，
 * 则相当于这个整数除以2的b次方
 */

import java.util.Scanner;

public class Multiply2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        long number = scan.nextLong();
        System.out.println("你输入的数字是：" + number);
        System.out.println("该数字乘以2的运算结果为：" + (number << 1));
        System.out.println("该数字乘以4的运算结果为：" + (number << 2));
        System.out.println("该数字乘以8的运算结果为：" + (number << 3));
        System.out.println("该数字乘以16的运算结果为：" + (number << 4));
    }
}

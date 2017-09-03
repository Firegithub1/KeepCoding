/**
 * 027：实现两个变量的互换（不借助第3个变量，用异或来互换）
 * <p>
 * 普通的变量互换需创建一个临时变量来共同完成互换，
 * 临时变量的创建增加了系统资源的消耗，
 * 如果需要交换的是两个整数类型的变量，
 * 那么可以使用更高效的方法。
 * 本实例演示了如何省略临时变量实现两个整数类型变量的高效互换。
 */

import java.util.Scanner;

public class VariableExchange {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); // 创建扫描器
        System.out.println("请输入变量A的值：");
        long A = scan.nextLong(); // 接收第一个变量的值
        System.out.println("请输入变量B的值：");
        long B = scan.nextLong(); // 接收第二个变量的值
        System.out.println("A=" + A + "\tB=" + B);
        System.out.println("执行变量互换……");
        A = A ^ B; // 用异或运算符执行变量互换
        B = B ^ A;
        A = A ^ B;
        System.out.println("A=" + A + "\tB=" + B);
    }
}

/*Notes：
刚开始看有点懵逼，异或还能这么用。。

详解：
a1=a^b
b=b^a1=b^a^b=a
//此时a1=a^b
a=a1^b=a^b^a=b

总结：同一变量与 另一变量和其异或值 异或 等于另一个数，如（a^b）^a=b。

再例如：
a = 9;
b = 11;

a=a^b; 1001^1011=0010
b=b^a; 1011^0010=1001
a=a^b; 0010^1001=1011

a = 11;
b = 9;
 */

/**
 * 028：判断某一年是否为闰年（if……else）
 * <p>
 * 很简单的一个程序
 */

import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入一个年份：");
        long year = scan.nextLong(); // 接收用户输入
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            System.out.println(year + "是闰年！");
        } else {
            System.out.println(year + "不是闰年！");
        }
    }
}

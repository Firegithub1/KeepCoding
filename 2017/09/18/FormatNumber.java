/**
 * 060：把数字格式化为货币字符串（NumberFormat）
 */

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class FormatNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入一个数字：");
        double number = scan.nextDouble();
        System.out.println("该数字用 Locale 类的以下常量作为格式化对象的构造参数，将获得不同的货币格式：");
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.CHINA);
        System.out.println("Locale.CHINA：" + format.format(number));
        format = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println(String.format("Locale.US：" + format.format(number)));
        format = NumberFormat.getCurrencyInstance(Locale.ENGLISH);
        System.out.println("Locale.ENGLISH：" + format.format(number));
        format = NumberFormat.getCurrencyInstance(Locale.TAIWAN);
        System.out.println("Locale.TAIWAN：" + format.format(number));
    }
}

/*运行结果：

请输入一个数字：
8982
该数字用 Locale 类的以下常量作为格式化对象的构造参数，将获得不同的货币格式：
Locale.CHINA：￥8,982.00
Locale.US：$8,982.00
Locale.ENGLISH：¤8,982.00
Locale.TAIWAN：NT$8,982.00

 */
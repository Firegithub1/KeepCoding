/**
 * 023：加密可以这样简单（位运算）
 * <p>
 * 创建一个Example类，
 * 在该类的方法中创建System类的标准输入流的扫描器对象，
 * 提示用户输入一个英文的字符串或者要解密的字符串，
 * 然后通过扫描器获取用户输入的字符串，
 * 经过加密或者解密后，
 * 把字符串通过错误流输出到控制台。
 * <p>
 * （感觉很无聊，这程序……）
 */

import java.util.Scanner;

public class Example {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入一个英文字符串或解密字符串"); // 获取用户输入
        String password = scan.nextLine(); // 获取字符数组
        char[] array = password.toCharArray(); // 遍历字符数组
        for (int i = 0; i < array.length; i++) // 对每个数组元素进行异或运算
        {
            array[i] = (char) (array[i] ^ 20000);
        }
        System.out.println("加密或解密结果如下：");
        System.err.println(new String(array)); //输出秘钥
    }
}

/**
 * 162：算数异常（ArithmeticException）
 */

public class ExceptionTest {
    public static void main(String[] args) {
        System.out.println("-1.0、0=" + (-1.0 / 0)); // 演示负浮点整除 0
        System.out.println("+1.0/0=" + (+1.0 / 0)); // 演示正浮点整除 0
        System.out.println("-1/0=" + (-1 / 0)); // 演示负整数除 0
        System.out.println("+1/0" + (+1 / 0)); // 演示正整数除 0
    }
}

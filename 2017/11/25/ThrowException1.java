/**
 * 170：方法中抛出异常
 */

public class ThrowException1 {
    public static void throwException1() {
        throw new UnsupportedOperationException("方法尚未实现"); // 抛出异常
    }

    public static void main(String[] args) {
        ThrowException1.throwException1(); // 调用抛出异常的方法
    }
}

/**
 * 157：动态调用类中的方法
 */

import java.lang.reflect.Method;

public class MethodTest {
    public static void main(String[] args) {
        try {
            System.out.println("调用 Math 类的静态方法 sin()");
            Method sin = Math.class.getDeclaredMethod("sin", Double.TYPE);
            Double sin1 = (Double) sin.invoke(null, new Integer(1));
            System.out.println("1 的正弦值：" + sin1);
            System.out.println("调用 String 类的非静态方法 equals()");
            Method equals = String.class.getDeclaredMethod("equals", Object.class);
            Boolean mrsoft = (Boolean) equals.invoke(new String("Java"), "Java");
            System.out.println("字符串是否是 Java：" + mrsoft);
        } catch (Exception e) {
            e.printStackTrace();
        } // 提示：由于这几行代码会抛出大量异常，因此采用捕获 Exception 代替。通常不推荐这种写法。
    }
}

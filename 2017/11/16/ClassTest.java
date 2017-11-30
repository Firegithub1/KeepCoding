/**
 * 150：实例化 Class 类的 5 种方法
 */

import java.util.Date;

public class ClassTest {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("第 1 种方法：Object.getClass()");
        Class c1 = new Date().getClass();
        System.out.println(c1.getName());
        System.out.println("第 2 种方法：.class 语法");
        Class c2 = boolean.class;
        System.out.println(c2.getName());
        System.out.println("第 3 种方法：Class.forName()");
        Class c3 = Class.forName("java.lang.String");
        System.out.println(c3.getName());
        System.out.println("第 4 种方法：包装类的 TYPE 域");
        Class c4 = Double.TYPE;
        System.out.println(c4.getName());
    }
}

/**
 * 155：查看内部类信息
 */

import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

public class NestedClassInformation {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> cls = Class.forName("java.awt.geom.Point2D");
        Class<?>[] classes = cls.getDeclaredClasses(); // 获得代表内部类的 Class 对象组成的数组
        for (Class<?> clazz : classes) { // 遍历 Class 对象的数组
            System.out.println("类的标准名称：" + clazz.getCanonicalName());
            System.out.println("类的修饰符：" + Modifier.toString(clazz.getModifiers()));
            Type[] interfaces = clazz.getGenericInterfaces(); // 获得所有泛型接口
            System.out.println("类所实现的接口：");
            if (interfaces.length != 0) { // 如果泛型接口个数不是 0 则输出
                for (Type type : interfaces) {
                    System.out.println("\t" + type);
                }
            } else {
                System.out.println("\t 空");
            }
            Type superClass = clazz.getGenericSuperclass(); // 获得直接父类
            System.out.println("类的直接继承关系：");
            if (superClass != null) { // 如果直接父类不是 Object 就输出
                System.out.println("\t" + superClass);
            } else {
                System.out.println("空");
            }
        }
    }
}

/**
 * 156：动态设置类的私有域
 */

import java.lang.reflect.Field;

public class Test1 {
    public static void main(String[] args) {
        Student student = new Student();
        Class<?> clazz = student.getClass();
        System.out.println("类的标准名称：" + clazz.getCanonicalName());
        try {
            Field id = clazz.getDeclaredField("id");
            System.out.println("设置前的 id：" + student.getId());
            id.setAccessible(true); // 对于私有域，一定要是用 setAccessible() 将其可见性设置为 true 才能设置新值。
            id.setInt(student, 10);
            System.out.println("设置后的 id：" + student.getId());

            Field name = clazz.getDeclaredField("name");
            System.out.println("设置前的 name：" + student.getName());
            name.setAccessible(true);
            name.set(student, "Java");
            System.out.println("设置后的 name：" + student.getName());

            Field male = clazz.getDeclaredField("male");
            System.out.println("设置前的 male：" + student.isMale());
            male.setAccessible(true);
            male.set(student, true);
            System.out.println("设置后的 male：" + student.isMale());

            Field account = clazz.getDeclaredField("account");
            System.out.println("设置前的 account：" + student.getAccount());
            account.setAccessible(true);
            account.setDouble(student, 12.34);
            System.out.println("设置后的 account：" + student.getAccount());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

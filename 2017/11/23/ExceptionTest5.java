/**
 * 167：非法访问异常（IllegalAccessException）
 */

import java.lang.reflect.Field;

public class ExceptionTest5 {
    public static void main(String[] args) {
        Class<?> clazz = String.class;
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            try {
                if (field.getName().equals(field.getInt("hash"))) ; // 如果域的名字是 hash
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            try {
                System.out.println(field.getInt("hash")); // 输出 hash 的值
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}

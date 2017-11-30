/**
 * 151：获得 Class 对象表示实体的名称
 */

import java.util.Date;

public class ClassNameTest {
    public static void main(String[] args) {
        String dateName = new Date().getClass().getName();
        System.out.println("非数组引用类型的名称：" + dateName);
        String byteName = byte.class.getName();
        System.out.println("基本类型的名称：" + byteName);
        String oneDimensionArray = new Date[4].getClass().getName();
        System.out.println("一维引用类型数组：" + oneDimensionArray);
        String twoDimensionArray = new int[4][4].getClass().getName();
        System.out.println("二维基本类型数组：" + twoDimensionArray);
    }
}

/**
 * 181：遍历枚举接口的元素
 */

import java.util.Enumeration;
import java.util.Vector;

public class EnumerationTest {
    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<Integer>(); // 定义一个向量保存测试用的数据
        for (int i = 0; i < 3; i++) {
            vector.add(i); // 在向量中存入数据
            System.out.println("在向量中增加元素：" + i);
        }
        Enumeration<Integer> e = vector.elements(); // 将向量转换成枚举接口类型
        while (e.hasMoreElements()) { // 输出枚举接口中的全部元素
            System.out.println("获得向量中的元素：" + e.nextElement());
        }
    }
}

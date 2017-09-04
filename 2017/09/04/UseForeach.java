/**
 * 038：foreach 循环优于 for 循环
 * <p>
 * foreach 循环是for循环的一种简写格式，只用于遍历数据集合或数组，语法格式如下：
 * for(Type e:collections) {
 * // 对变量 e 的使用
 * }
 * 参数说明：
 * e ： 其类型 Type 是集合或数组中元素值的类型，该参数是集合或数组collections中的一个元素。
 * collections ：要遍历的集合或数组，也可以是迭代器。
 */

import java.util.ArrayList;
import java.util.List;

public class UseForeach {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>(); // 创建List集合
        list.add("abc"); // 初始化List集合
        list.add("def");
        list.add("hij");
        list.add("klm");
        list.add("nop");
        list.add("qrs");
        System.out.print("foreach 遍历集合：\n\t");
        for (String string : list) { // 遍历List集合
            System.out.print(string); // 输出集合的元素值
        }
        System.out.println();
        String[] strs = new String[list.size()];
        list.toArray(strs); // 创建数组
        System.out.print("foreach 遍历数组：\n\t");
        for (String string : strs) { // 遍历数组
            System.out.print(string); // 输出数组元素值
        }
    }
}

/*运行结果：
foreach 遍历集合：
	abcdefhijklmnopqrs
foreach 遍历数组：
	abcdefhijklmnopqrs
 */
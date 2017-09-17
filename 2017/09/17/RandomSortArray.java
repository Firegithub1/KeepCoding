/**
 * 058：用 TreeSet 生成不重复自动排序随机数组
 */

import java.util.Random;
import java.util.TreeSet;

public class RandomSortArray {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<Integer>();
        Random ran = new Random();
        int count = 0;
        while (count < 10) {
            boolean succeed = set.add(ran.nextInt(100));
            if (succeed)
                count++;
        }
        int size = set.size();
        Integer[] array = new Integer[size];
        set.toArray(array);
        System.out.println("生成的不重复随机数组内容如下：");
        for (int value : array) {
            System.out.print(value + "  ");
        }
    }
}

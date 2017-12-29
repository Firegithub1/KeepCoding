import com.sun.org.apache.xpath.internal.SourceTree;
import org.apache.commons.lang.ArrayUtils;

import java.util.Arrays;

/**
 * 216：数组元素的增加（Commons Lang 组件简介）
 */

public class ArrayUtilsTest1 {
    public static void main(String[] args) {
        int[] array0 = new int[5];
        Arrays.fill(array0, 8);
        System.out.println("数组中的元素是：");
        System.out.println(Arrays.toString(array0));
        System.out.println("在数组的最后增加元素 10");
        int[] array1 = ArrayUtils.add(array0, 10);
        System.out.println("数组中的元素是：");
        System.out.println(Arrays.toString(array1));
        System.out.println("在数组的开头增加元素 10");
        int[] array2 = ArrayUtils.add(array0, 0, 10);
        System.out.println("数组中的元素是：");
        System.out.println(Arrays.toString(array2));
        System.out.println("将新生成的两个数组合并：");
        int[] array3 = ArrayUtils.addAll(array1, array2);
        System.out.println(Arrays.toString(array3));
    }
}

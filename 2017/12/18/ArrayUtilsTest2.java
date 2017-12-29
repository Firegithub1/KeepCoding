/**
 * 217：数组元素的删除（Commons Lang 组件简介）
 */

import org.apache.commons.lang.ArrayUtils;

import java.util.Arrays;

public class ArrayUtilsTest2 {
    public static void main(String[] args) {
        int[] array0 = {0, 1, 3, 4, 2, 9};
        System.out.println("数组中的元素是：");
        System.out.println(Arrays.toString(array0));
        System.out.println("删除最后一个元素");
        int[] array1 = ArrayUtils.remove(array0, 4);
        System.out.println("数组中的元素是：");
        System.out.println(Arrays.toString(array1));
        System.out.println("删除元素 2");
        int[] array2 = ArrayUtils.removeElement(array0, 2);
        System.out.println("数组中的元素是：");
        System.out.println(Arrays.toString(array2));
    }
}

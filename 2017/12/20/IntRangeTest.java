/**
 * 221：整数取值范围判断（Commons Lang 组件简介）
 */

import org.apache.commons.lang.math.IntRange;

import java.util.Arrays;

public class IntRangeTest {
    public static void main(String[] args) {
        IntRange range = new IntRange(-5, 5);
        System.out.println("区间中的全部整数是：");
        System.out.println(Arrays.toString(range.toArray()));
        System.out.println("0 是否在区间中：");
        System.out.println(range.containsInteger(0));
        System.out.println("区间的上限是：");
        System.out.println(range.getMaximumInteger());
        System.out.println("区间的下限是：");
        System.out.println(range.getMinimumInteger());
        System.out.println("区间的字符串表示是：");
        System.out.println(range.toString());
    }
}

/**
 * 179：高效的枚举元素集合
 */

import java.util.EnumSet;

public class EnumSetTest {
    public static void main(String[] args) {
        EnumSet<Weeks> week = EnumSet.noneOf(Weeks.class); // 创建一个 Weeks 类型的 EnumSet
        week.add(Weeks.MONDAY); // 向 EnumSet 中增加元素
        System.out.println("EnumSet 中的元素：" + week);
        week.remove(Weeks.MONDAY); // 删除 EnumSet 中的元素
        System.out.println("EnumSet 中的元素：" + week);
        week.addAll(EnumSet.complementOf(week)); // 向 EnumSet 中增加 week 中元素的补集
        System.out.println("EnumSet 中的元素：" + week);
        week.removeAll(EnumSet.range(Weeks.MONDAY, Weeks.THURSDAY)); // 删除 week 中的 Monday 到 Thursday 元素
        System.out.println("EnumSet 中的元素：" + week);
    }
}

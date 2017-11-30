/**
 * 180：高效的枚举元素映射
 */

import java.util.EnumMap;

public class EnumMapTest {
    public static void main(String[] args) {
        EnumMap<Weeks, String> weeks = new EnumMap<Weeks, String>(Weeks.class);
        weeks.put(Weeks.MONDAY, "星期一");
        weeks.put(Weeks.SUNDAY, "星期日");
        System.out.println("EnumMap 中的键值个数：" + weeks.size());
        System.out.println("EnumMap 中的键值对：" + weeks);
        System.out.println("EnumMap 中是否包含键 SATURADAY：" + weeks.containsKey(Weeks.SATURADAY));
        System.out.println("EnumMap 中是否包含值 星期日：" + weeks.containsValue("星期日"));
        weeks.remove(Weeks.MONDAY);
        System.out.println("EnumMap 中的键值对：" + weeks);
        System.out.println("EnumMap 中键 MONDAY 对应的值：" + weeks.get(Weeks.MONDAY));
    }
}

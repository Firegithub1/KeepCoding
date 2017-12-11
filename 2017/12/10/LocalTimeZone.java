/**
 * 198：查看本地时区（SimpleDateFormat 与 TimeZone 类的使用）
 */

import java.util.TimeZone;

public class LocalTimeZone {
    public static void main(String[] args) {
        TimeZone zone = TimeZone.getDefault(); // 获得当前时区
        System.out.println("当前注记所在时区：" + zone.getDisplayName()); // 获得时区的名字
        zone = TimeZone.getTimeZone("Asia/Taipei"); // 获得中国台北时区
        System.out.println("中国台北所在时区：" + zone.getDisplayName());
        System.out.println("时区的完整名称：" + zone.getDisplayName(true, TimeZone.LONG));
        System.out.println("时区的缩写名称：" + zone.getDisplayName(true, TimeZone.SHORT));
    }
}

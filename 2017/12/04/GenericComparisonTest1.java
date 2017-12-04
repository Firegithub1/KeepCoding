/**
 * 188：泛型化接口与最大值
 */

public class GenericComparisonTest1 {
    public static void main(String[] args) {
        String[] books = {"Java 从入门到放弃", "Java 编程规范", "Java 视频", "细说 Java"};
        System.out.println("这些书很不错哦：");
        for (String book : books) {
            System.out.println(book);
        }
        GenericComparison1<String> gc = new GenericComparison1<>();
        String max = gc.getMax(books); // 获得字符串数组中的最大元素
        System.out.println("按名称排序最后一本书：");
        System.out.println(max);
    }
}

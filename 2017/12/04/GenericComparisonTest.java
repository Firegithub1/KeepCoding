/**
 * 187：泛型化方法与最小值
 */

public class GenericComparisonTest {
    public static void main(String[] args) {
        String[] books = {"Java 从入门到放弃", "Java 编程规范", "Java 视频", "细说 Java"};
        System.out.println("这些书都很棒哦：");
        for (String book : books) {
            System.out.println(book);
        }
        String min = GenericComparison.getMin(books);
        System.out.println("按名称排序的第一本书：");
        System.out.println(min);
    }
}

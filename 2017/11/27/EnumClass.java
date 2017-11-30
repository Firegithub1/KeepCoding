/**
 * 176：枚举类型的基本特性
 */

public class EnumClass {
    public static void main(String[] args) {
        for (Size size : Size.values()) {
            System.out.println(size + " 的序数是：" + size.ordinal()); // 查看枚举元素的顺序
            System.out.println(size.compareTo(Size.SMALL) + " "); // 将枚举元素与 Size.SMALL 比较
            System.out.println(size.equals(Size.SMALL) + " "); // 将枚举元素与 Size.SMALL 比较
            System.out.println(size == Size.SMALL); // 将枚举元素与 Size.SMALL 比较
            System.out.println(size.name()); // 获得枚举元素的名称
            System.out.println("************************"); // 优雅的分隔线-_-!
        }
    }
}

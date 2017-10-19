/**
 * 101：提高产品质量的方法（封装）
 */

public class Test3 {
    public static void main(String[] args) {
        Box box = new Box();
        System.out.println("将箱子的长度设置成 -1");
        box.setLength(-1);
        System.out.println("将箱子的宽度设置成 -1");
        box.setWidth(-1);
        System.out.println("将箱子的高度设置成 -1");
        box.setHeight(-1);
        System.out.println("箱子的长度是：" + box.getLength());
        System.out.println("箱子的长度是：" + box.getWidth());
        System.out.println("箱子的长度是：" + box.getHeight());
    }
}

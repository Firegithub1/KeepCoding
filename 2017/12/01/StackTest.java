/**
 * 183：自定义非泛型栈结构
 */

public class StackTest {
    public static void main(String[] args) {
        Stack stack = new Stack();
        System.out.println("向栈中增加字符串：");
        System.out.println("视频学 Java");
        System.out.println("细说 Java");
        System.out.println("Java 从入门到放弃");
        stack.push("视频学 Java"); // 向栈中增加字符串
        stack.push("细说 Java"); // 向栈中增加字符串
        stack.push("Java 从入门到放弃"); // 向栈中增加字符串
        System.out.println("从栈中取出字符串：");
        while (!stack.empty()) {
            System.out.println((String) stack.pop()); // 删除栈中的全部元素并进行输出
        }
    }
}

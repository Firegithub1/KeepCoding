/**
 * 184：使用泛型实现栈结构
 */

public class StackTest1 {
    public static void main(String[] args) {
        Stack1<String> stack = new Stack1<String>(); // 在创建栈对象的时候就指明该栈中只能保存字符串l
        System.out.println("向栈中增加字符串：");
        System.out.println("视频学 Java");
        System.out.println("细说 Java");
        System.out.println("Java 从入门到放弃");
        stack.push("视频学 Java");
        stack.push("细说 Java");
        stack.push("Java 从入门到放弃");
        System.out.println("从栈中取出字符串：");
        while (!stack.empty()) {
            System.out.println((String) stack.pop());
        }
    }
}

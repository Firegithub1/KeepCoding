/**
 * 019：输出错误信息与调试信息
 * <p>
 * 疑问：很奇怪居然不是按顺序输出的！！搞不懂！
 */

public class PrintErrorAndDebug {
    public static void main(String[] args) {
        System.out.println("main()方法开始运行了。");
        // 输出错误信息
        System.err.println("在运行期间手动输出一个错误信息：");
        System.err.println("\t该软件没有买保险，请注意安全");
        System.out.println("PrintErrorAndDebug.main()");
        System.out.println("main()方法运行结束。");

    }
}

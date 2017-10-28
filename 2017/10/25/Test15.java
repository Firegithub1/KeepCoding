/**
 * 114：transient 关键字的应用
 */

public class Test15 {
    public static void main(String[] args) {
        Login login1 = new Login("mingrisoft", "mr");
        System.out.println("输出原始对象的信息：");
        System.out.println(login1);
        System.out.println("输出克隆对象的信息：");
        Login login2 = login1.clone(); // 克隆 login1 对象
        System.out.println(login2);
    }
}

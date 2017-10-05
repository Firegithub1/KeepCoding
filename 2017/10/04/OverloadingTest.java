/**
 * 086：编写同名方法（即方法的重载）
 */

public class OverloadingTest {
    public void info() {
        System.out.println("普通方法：1 岁了");
    }

    public void info(int age) {
        System.out.println("重载方法：" + age + "岁了！");
    }

    public static void main(String[] args) {
        OverloadingTest ot = new OverloadingTest();
        ot.info();
        for (int i = 0; i < 5; i++) {
            ot.info(i);
        }
    }
}
/*
运行结果：

普通方法：1 岁了
重载方法：0岁了！
重载方法：1岁了！
重载方法：2岁了！
重载方法：3岁了！
重载方法：4岁了！
 */
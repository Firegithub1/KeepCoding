/**
 * 088：单例模式的应用
 */

public class EmperorTest {
    public static void main(String[] args) {
        System.out.println("创建皇帝 1 对象");
        Emperor emperor1 = Emperor.getInstance();
        emperor1.getName();
        System.out.println("创建皇帝 2 对象");
        Emperor emperor2 = Emperor.getInstance();
        emperor2.getName();
        System.out.println("创建皇帝 3 对象");
        Emperor emperor3 = Emperor.getInstance();
        emperor3.getName();
    }
}
/*
运行结果：

创建皇帝 1 对象
我是皇帝！！！
创建皇帝 2 对象
我是皇帝！！！
创建皇帝 3 对象
我是皇帝！！！
 */
/**
 * 161：反射与动态代理
 */

import java.lang.reflect.Proxy;

public class Test2 {
    public static void main(String[] args) {
        Seller seller = new HouseSeller();
        System.out.println("不使用代理方式：");
        seller.sell(); // 普通当时调用 sell() 方法
        System.out.println("使用代理方式：");
        ClassLoader loader = Seller.class.getClassLoader(); // 获得 Seller 类的类加载器
        seller = (Seller) Proxy.newProxyInstance(loader, new Class[]{Seller.class}, new Agency());
        seller.sell(); // 代理方式调用 sell() 方式
    }
}

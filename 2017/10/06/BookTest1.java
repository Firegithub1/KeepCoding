/**
 * 090：统计图书的销售量（static 修饰的方法可以通过类名直接调用）
 */

import java.util.Random;

public class BookTest1 {
    public static void main(String[] args){
        String[] titles={"《Java 从入门到放弃》","《Java 编程词典》","《Java 核心技术》"};
        for(int i=0;i<5;i++){
            new Book1(titles[new Random().nextInt(3)]);
        }
        System.out.println("总计销售了"+Book1.getCounter()+"本书！");
    }
}
/*
运行结果：

售出图书：《Java 编程词典》
售出图书：《Java 从入门到放弃》
售出图书：《Java 核心技术》
售出图书：《Java 编程词典》
售出图书：《Java 从入门到放弃》
总计销售了5本书！
 */
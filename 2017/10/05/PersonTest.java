/**
 * 087：构造方法的应用（有无参）
 */

public class PersonTest {
    public static void main(String[] args) {
        Person person1 = new Person();
        Person person2 = new Person("renkai", "男", 11);
        System.out.println("员工 1 的信息");
        System.out.println("员工姓名：" + person1.getName());
        System.out.println("员工性别：" + person1.getGender());
        System.out.println("员工年龄：" + person1.getAge());
        System.out.println("员工 2 的信息");
        System.out.println("员工姓名：" + person2.getName());
        System.out.println("员工性别：" + person2.getGender());
        System.out.println("员工年龄：" + person2.getAge());
    }
}

/*
运行结果：

使用无参构造方法创建对象
使用有参构造方法创建对象
员工 1 的信息
员工姓名：null
员工性别：null
员工年龄：0
员工 2 的信息
员工姓名：renkai
员工性别：男
员工年龄：11
 */
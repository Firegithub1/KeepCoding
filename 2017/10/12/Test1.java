/**
 * 099：重写父类中的方法（Overriding）
 */

public class Test1 {
    public static void main(String[] args) {
        Employee1 employee = new Employee1();
        System.out.println(employee.getInfo());
        Manager1 manager = new Manager1();
        System.out.println(manager.getInfo());
    }
}

/*

运行结果：

父类：我是Java的员工
子类：我是Java的经理！
 */
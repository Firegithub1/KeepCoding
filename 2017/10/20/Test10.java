/**
 * 109：Java对象的假克隆（错误的克隆方法）
 */

public class Test10 {
    public static void main(String[] args) {
        System.out.println("克隆之前：");
        Employee2 employee1 = new Employee2(); // 创建 Employee2 对象 employee1
        employee1.setName("Java");
        employee1.setAge(12);
        System.out.println("员工 1 的信息：");
        System.out.println(employee1);
        System.out.println("克隆之后：");
        Employee2 employee2 = employee1; // 将 employee1 赋值给 employee2
        employee2.setName("hahah");
        employee2.setAge(113);
        System.out.println("员工 2 的信息：");
        System.out.println(employee2);
        System.out.println("员工 1 的信息：");
        System.out.println(employee1);
    }
}

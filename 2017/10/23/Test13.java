/**
 * 112：序列化与对象克隆（对象写入流中，实现 Serializable 接口）
 */

public class Test13 {
    public static void main(String[] args) {
        System.out.println("克隆之前：");
        Address2 address = new Address2("中国", "江苏", "南京");
        Employee5 employee1 = new Employee5("Java", 12, address);
        System.out.println("员工 1 的信息：");
        System.out.println(employee1);
        System.out.println("克隆之后：");
        Employee5 employee2 = employee1.clone();
        employee2.getAddress().setState("中国");
        employee2.getAddress().setProvince("陕西");
        employee2.getAddress().setCity("西安");
        employee2.setName("西北农林科技大学");
        employee2.setAge(82);
        System.out.println("员工 2 的信息：");
        System.out.println(employee2);
        System.out.println("员工 1 的信息：");
        System.out.println(employee1);
    }
}

/**
 * 116：简化 compareTo() 方法的重写（CompareToBuilder 类）
 */

import java.util.Arrays;

public class Test17 {
    public static void main(String[] args) {
        Employee8 employee1 = new Employee8(3, "Java", 1);
        Employee8 employee2 = new Employee8(2, "C++", 2);
        Employee8 employee3 = new Employee8(1, "JavaScript", 3);
        Employee8[] employees = new Employee8[3];
        employees[0] = employee1;
        employees[1] = employee2;
        employees[2] = employee3;
        System.out.println("排序前：");
        for (Employee8 employee : employees) {
            System.out.println(employee);
        }
        System.out.println("排序后：");
        Arrays.sort(employees);
        for (Employee8 employee : employees) {
            System.out.println(employee);
        }
    }
}

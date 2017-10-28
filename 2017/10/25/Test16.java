/**
 * 115：使用 sort() 方法排序（Arrays.sort()）
 */

import java.util.Arrays;

public class Test16 {
    public static void main(String[] args) {
        Employee7 employee1 = new Employee7(3, "Java", 1);
        Employee7 employee2 = new Employee7(2, "C++", 2);
        Employee7 employee3 = new Employee7(1, "JavaScript", 3);
        Employee7[] employees = new Employee7[3];
        employees[0] = employee1;
        employees[1] = employee2;
        employees[2] = employee3;
        System.out.println("排序前：");
        for (Employee7 employee : employees) {
            System.out.println(employee);
        }
        System.out.println("排序后：");
        Arrays.sort(employees);
        for (Employee7 employee : employees) {
            System.out.println(employee);
        }
    }
}

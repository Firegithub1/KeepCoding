/**
 * 237：动态排序 JavaBean（Commons BeanUtils 组件简介）
 */

import org.apache.commons.beanutils.BeanComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test4 {
    public static void main(String[] args) {
        Employee4 employee1 = new Employee4();
        employee1.setId(1);
        employee1.setName("IBM");
        employee1.setSalary(10000);
        Employee4 employee2 = new Employee4();
        employee2.setId(2);
        employee2.setName("Oracle");
        employee2.setSalary(1000);
        Employee4 employee3 = new Employee4();
        employee3.setId(3);
        employee3.setName("Sun");
        employee3.setSalary(100);
        List<Employee4> list = new ArrayList<>(); // 创建 list 对象并保存全部员工对象
        list.add(employee1);
        list.add(employee2);
        list.add(employee3);
        System.out.println("排序前：");
        for (Employee4 employee : list) {
            System.out.println(employee); // 输出所有对象
        }
        Collections.<Employee4>sort(list, new BeanComparator("salary")); // 进行排序
        System.out.println("按工资排序后：");
        for (Employee4 employee : list) {
            System.out.println(employee);
        }

    }
}

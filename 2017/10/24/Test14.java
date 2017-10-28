/**
 * 113：深克隆效率的比较
 */

import java.util.ArrayList;
import java.util.List;

public class Test14 {
    public static void main(String[] args) {
        List<Worker> workerList = new ArrayList<Worker>();
        List<Employee6> employeeList = new ArrayList<Employee6>();
        Worker worker = new Worker("Java", 12);
        Employee6 employee = new Employee6("Java", 12);
        long currentTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            workerList.add(worker.clone());
        }
        System.out.println("使用复制域的方式实现克隆所花费的时间：");
        System.out.println(System.currentTimeMillis() - currentTime + "毫秒");
        currentTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            employeeList.add(employee.clone());
        }
        System.out.println("使用序列化的方式实现克隆所花费的时间：");
        System.out.println(System.currentTimeMillis() - currentTime + "毫秒");
    }
}

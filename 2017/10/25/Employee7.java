public class Employee7 implements Comparable<Employee7> {
    private int id;
    private String name;
    private int age;

    public Employee7(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int compareTo(Employee7 o) { // 利用编号实现对象间的比较
        if (id > o.id) {
            return 1;
        } else if (id < o.id) {
            return -1;
        }
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("编号：" + id + "，");
        sb.append("姓名：" + name + "，");
        sb.append("年龄：" + age);
        return sb.toString();
    }
}

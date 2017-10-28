import org.apache.commons.lang.builder.CompareToBuilder;

public class Employee8 implements Comparable<Employee8> {
    private int id;
    private String name;
    private int age;

    public Employee8(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int compareTo(Employee8 o) { // 依次利用 id、name、age 域进行比较
        return new CompareToBuilder().append(id, o.id).append(name, o.name).append(age, o.age).toComparison();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("编号：" + id + "，");
        sb.append("姓名：" + name + "，");
        sb.append("年龄：" + age);
        return sb.toString();
    }
}

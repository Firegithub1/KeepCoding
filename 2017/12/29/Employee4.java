public class Employee4 {
    private int id;
    private String name;
    private double salary;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return "员工编号：" + id + "，员工姓名：" + name + "，员工工资：" + salary;
    }
}

public class Employee3 implements Cloneable {
    private String name;
    private int age;
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Employee3(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("姓名：" + name + "，");
        sb.append("年龄：" + age + "\n");
        sb.append("地址：" + address);
        return sb.toString();
    }

    public Employee3 clone() {
        Employee3 employee = null;
        try {
            employee = (Employee3) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return employee;
    }
}

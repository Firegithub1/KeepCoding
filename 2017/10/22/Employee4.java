public class Employee4 implements Cloneable {
    private String name;
    private int age;
    private Address1 address;

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

    public Address1 getAddress() {
        return address;
    }

    public void setAddress(Address1 address) {
        this.address = address;
    }

    public Employee4(String name, int age, Address1 address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("姓名：" + name + "，");
        sb.append("年龄：" + age + "\n");
        sb.append("地址" + address);
        return sb.toString();
    }

    public Employee4 clone() {
        Employee4 employee = null;
        try {
            employee = (Employee4) super.clone();
            employee.address = address.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return employee;
    }
}

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import java.io.*;

public class Employee5 implements Cloneable, Serializable {
    //private static final long SerialVersionUID=2222222L;
    private String name;
    private int age;
    private Address2 address;

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

    public Address2 getAddress() {
        return address;
    }

    public void setAddress(Address2 address) {
        this.address = address;
    }

    public Employee5(String name, int age, Address2 address) {
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

    public Employee5 clone() { // 使用序列化实现深克隆
        Employee5 employee = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this); // 将对象写入到字节数组中
            oos.close(); // 关闭输出流
        } catch (IOException e) {
            e.printStackTrace();
        }
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        try {
            ObjectInputStream ois = new ObjectInputStream(bais); // 从字节数组中读取对象
            employee = (Employee5) ois.readObject();
            ois.close(); // 关闭输入流
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return employee;
    }
}

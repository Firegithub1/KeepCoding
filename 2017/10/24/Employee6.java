import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Employee6 implements Cloneable, Serializable {
    private String name;
    private int age;

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

    public Employee6(String name, int age){
        this.name=name;
        this.age=age;
    }
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append("姓名："+name+"，");
        sb.append("年龄："+age+"\n");
        return sb.toString();
    }
    public Employee6 clone(){
        Employee6 employee=null;
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        try{
            ObjectOutputStream oos=new ObjectOutputStream(baos);
            oos.writeObject(this);
            oos.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        return employee;
    }

}

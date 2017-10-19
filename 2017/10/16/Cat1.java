import org.apache.commons.lang.builder.EqualsBuilder;

import java.awt.*;

public class Cat1 {
    private String name;
    private int age;
    private double weight;
    private Color color;

    public Cat1(String name, int age, double weight, Color color) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Cat1 cat = (Cat1) obj;
        return new EqualsBuilder().append(name, cat.name).append(age, cat.age).append(weight, cat.weight).append(color, cat.color).isEquals();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("姓名：" + name + "\n");
        sb.append("年龄：" + age + "\n");
        sb.append("体重：" + weight + "\n");
        sb.append("颜色：" + color + "\n");
        return sb.toString();
    }
}

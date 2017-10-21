import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.awt.*;

public class Cat3 {
    private String name;
    private int age;
    private double weight;
    private Color color;

    public Cat3(String name, int age, double weight, Color color) {
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
        if (getClass() != obj.getClass()) { // 如果两个猫咪的类型不同则不同
            return false;
        }
        Cat3 cat = (Cat3) obj;
        return new EqualsBuilder().append(name, cat.name).append(age, cat.age).append(weight, cat.weight).append(color, cat.color).isEquals();
        // 比较猫咪的属性
    }

    public int hashCode() { // 利用 equals() 方法中使用的属性重写 hashCode() 方法
        return new HashCodeBuilder().append(name).append(age).append(weight).append(color).toHashCode();
    }

}

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.awt.*;

public class Cat5 {
    private String name;
    private int age;
    private double weight;
    private Color color;

    public Cat5(String name, int age, double weight, Color color) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;
    }

    public String toString() { // 重写 toString() 方法
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append(name).append(age).append(weight).append(color).toString();
    }
}

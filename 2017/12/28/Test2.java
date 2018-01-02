/**
 * 235：动态生成 JavaBean（Commons BeanUtils 组件简介）
 */

import org.apache.commons.beanutils.BasicDynaClass;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaProperty;

import java.util.HashMap;
import java.util.Map;

public class Test2 {
    public static void main(String[] args) {
        DynaProperty[] properties = new DynaProperty[3]; // 声明保存 3 个属性值的数组
        // 指定属性名称和类型
        properties[0] = new DynaProperty("name", String.class);
        properties[1] = new DynaProperty("phoneNumber", String[].class, String.class);
        properties[2] = new DynaProperty("address", Map.class, String.class);
        BasicDynaClass dynaClass = new BasicDynaClass("employee", null, properties);
        DynaBean employee = null;
        try {
            employee = dynaClass.newInstance(); // 获得 DynaBean 的实例
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        // 为属性赋值
        employee.set("name", "Java");
        employee.set("phoneNumber", new String[10]); // 索引类型要先初始化
        employee.set("phoneNumber", 0, "1234567");
        employee.set("address", new HashMap<String, String>()); // 映射类型要先初始化
        employee.set("address", "home", "中国");
        String name = (String) employee.get("name");
        String phoneNumber = (String) employee.get("phoneNumber", 0);
        String address = (String) employee.get("address", "home");

        // 输出属性值
        System.out.println("新建的 JavaBean 的 name 属性：" + name);
        System.out.println("新建的 JavaBean 的 phoneNumber 属性的第一个值：" + phoneNumber);
        System.out.println("新建的 JavaBean 的 address 属性 home 键所对应的值：" + address);
    }
}

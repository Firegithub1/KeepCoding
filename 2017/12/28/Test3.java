/**
 * 236：复制 JavaBean 属性（Commons BeanUtils 组件简介）
 */

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.InvocationTargetException;

public class Test3 {
    public static void main(String[] args) {
        Employee3 employee1 = new Employee3();
        Employee3 employee2 = new Employee3();
        try {
            // 为 employee1 赋值
            PropertyUtils.setSimpleProperty(employee1, "name", "Java");
            PropertyUtils.setIndexedProperty(employee1, "phoneNumber", 0, "1234567");
            PropertyUtils.setMappedProperty(employee1, "address", "home", "中国");
            BeanUtils.copyProperties(employee2, employee1); // 将 employee1 的值复制到 employee2

            // 获得 employee2 的属性值
            String name = (String) PropertyUtils.getSimpleProperty(employee2, "name");
            String phoneNumber = (String) PropertyUtils.getIndexedProperty(employee2, "phoneNumber", 0);
            String address = (String) PropertyUtils.getMappedProperty(employee2, "address", "home");

            // 输出 employee2 的属性值
            System.out.println("复制属性值之后：");
            System.out.println("name 属性：" + name);
            System.out.println("phoneNumber 属性的第一个值：" + phoneNumber);
            System.out.println("address 属性 home 键所对应的值：" + address);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}

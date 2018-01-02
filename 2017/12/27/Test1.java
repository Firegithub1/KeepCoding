/**
 * 234：设置 JavaBean 级联属性（Commons BeanUtils 组件简介）
 */

import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.InvocationTargetException;

public class Test1 {
    public static void main(String[] args) {
        Company1 company = new Company1();
        try { // 设置级联属性并输出
            PropertyUtils.setNestedProperty(company, "employee.name", "Java");
            PropertyUtils.setNestedProperty(company, "employee.phoneNumber[0]", "1234567");
            PropertyUtils.setNestedProperty(company, "employee.address(home)", "中国");
            System.out.println("获得设置的级联属性：");
            String name = (String) PropertyUtils.getNestedProperty(company, "employee.name");
            String phoneNumber = (String) PropertyUtils.getNestedProperty(company, "employee.phoneNumber[0]");
            String address = (String) PropertyUtils.getNestedProperty(company, "employee.address(home)");
            System.out.println("employee.name = " + name);
            System.out.println("employee.phoneNumber[0] = " + phoneNumber);
            System.out.println("employee.address(home) = " + address);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}

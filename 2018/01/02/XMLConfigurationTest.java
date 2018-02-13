/**
 * 245：读取 XML 文件属性（其他 Commons 组件简介）
 */

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;

import java.net.URL;

public class XMLConfigurationTest {
    public static void main(String[] args) throws ConfigurationException {
        URL resource = new XMLConfigurationTest().getClass().getResource("Book.xml");
        XMLConfiguration config = new XMLConfiguration(resource);
        String bookName = config.getString("Java图书.书名");
        String author = config.getString("Java图书。作者");
        String press = config.getString("Java图书.出版社");
        String ISBN = config.getString("Java图书.ISBN");
        double price = config.getDouble("Java图书.价格");
        int pages = config.getInt("Java图书.页数");
        String time = config.getString("Java图书.出版时间");
        System.out.println("图书信息");
        System.out.println("书名：" + bookName);
        System.out.println("作者：" + author);
        System.out.println("出版社：" + press);
        System.out.println("ISBN：" + ISBN);
        System.out.println("价格：" + price);
        System.out.println("页数：" + pages);
        System.out.println("出版时间：" + time);
    }
}

/**
 * 232：简化文件的读写操作（Commons IO 组件简介）
 */

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.RandomStringUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class IOUtilsTest {
    public static void main(String[] args) {
        FileOutputStream out = null; // 创建文件输出流对象
        FileInputStream in = null;
        try {
            out = new FileOutputStream("d:\\desktop\\Java.txt");  // 创建文件输出流对象
            System.out.println("向文件中写入 5 个随机字符串");
            in = new FileInputStream("d:\\desktop\\Java.txt"); // 创建文件输入流对象
            for (int i = 0; i < 5; i++) { // 向文本中写入 5 个随机字符串
                IOUtils.write(RandomStringUtils.randomAlphanumeric(5) + "\n", out);
            }
            System.out.println("输出文件中的随机字符串");
            List<String> list = IOUtils.readLines(in); // 从文本中读取字符串
            for (String string : list) {
                System.out.println(string);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(out); // 释放资源
            IOUtils.closeQuietly(in); // 释放资源
        }
    }
}

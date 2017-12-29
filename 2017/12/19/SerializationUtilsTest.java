/**
 * 219：序列化与反序列化（Commons Lang 组件简介）
 */

import org.apache.commons.lang.SerializationUtils;

import java.io.*;
import java.util.Arrays;

public class SerializationUtilsTest {
    public static void main(String[] args) {
        Student student = new Student(); // 创建 student 对象
        student.setId(10); // 初始化 id 属性
        student.setName("Java课程"); // 初始化 name 属性
        System.out.println("将 student 对象序列化为 byte 数组");
        byte[] studentByte = SerializationUtils.serialize(student); // 将对象转换成 byte 数组
        System.out.println("输出序列化数组：");
        System.out.println(Arrays.toString(studentByte)); // 输出 byte 数组
        System.out.println("将 student 对象序列化到本地文件");
        FileOutputStream out = null; // 创建文件输出流对象
        try {
            out = new FileOutputStream(new File("d:\\desktop\\java.txt").getAbsoluteFile());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        SerializationUtils.serialize(student, out); // 将对象写入到 java。txt 对象
        System.out.println("文件生成成功！");
        System.out.println("从本地文件反序列化 student 对象");
        FileInputStream in = null; // 创建文件输入流对象
        try {
            in = new FileInputStream(new File("d:\\desktop\\java.txt").getAbsoluteFile());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Student newStudent = (Student) SerializationUtils.deserialize(in); // 读入对象
        System.out.println("查看 student 对象的属性");
        System.out.println(newStudent);
    }
}

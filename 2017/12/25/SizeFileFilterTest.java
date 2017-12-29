/**
 * 231：简化文件（夹）过滤（Commons IO 组件简介）
 */

import org.apache.commons.io.filefilter.SizeFileFilter;

import java.io.File;

public class SizeFileFilterTest {
    public static void main(String[] args) {
        File dir = new File("d:\\desktop\\Java7"); // 创建一个文件夹对象
        System.out.println("过滤前文件夹中的文件");
        File[] files = dir.listFiles(); // 获得该文件夹中所有的文件和子文件夹
        for (File file : files) {
            System.out.println(file.getName() + " 的大小是： " + file.length());
        }
        System.out.println("过滤后文件夹中的文件：");
        String[] fileNames = dir.list(new SizeFileFilter(1024 * 1024)); // 过滤掉小于 1M 的文件
        for (int i = 0; i < fileNames.length; i++) {
            System.out.println(fileNames[i]);
        }
    }
}

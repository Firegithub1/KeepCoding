/**
 * 228：简化文件（夹）删除（Commons IO 组件简介）
 */

import org.apache.commons.io.FileDeleteStrategy;

import java.io.File;
import java.io.IOException;

public class FileDeleteStrategyTest {
    public static void main(String[] args) {
        File rootFile = new File("d:\\desktop\\Java1"); // 创建要删除的文件夹对象
        System.out.println("获得所有文件的绝对路径：");
        File[] list = rootFile.listFiles();
        for (File file : list) {
            System.out.println(file.getAbsolutePath()); // 输出文件夹中的所有文件的绝对路径
        }
        FileDeleteStrategy strategy = FileDeleteStrategy.NORMAL; // 使用普通删除策略
        System.out.println("以普通策略删除非空文件夹 d:\\desktop\\Java1");
        try {
            strategy.delete(new File("d:\\desktop\\Java1"));
            System.out.println("文件夹删除成功！");
        } catch (IOException e) {
            System.out.println("文件夹删除失败！");
        }
        strategy = FileDeleteStrategy.FORCE; // 使用强制删除策略
        System.out.println("以普通策略删除非空文件夹 d:\\desktop\\Java2");
        try {
            strategy.delete(new File("d:\\desktop\\Java2"));
            System.out.println("文件夹删除成功！");
        } catch (IOException e) {
            System.out.println("文件夹删除失败！");
        }
    }
}

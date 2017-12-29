/**
 * 229：简化文件（夹）复制（Commons IO 组件简介）
 */

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtilsTest {
    public static void main(String[] args) throws IOException {
        File srcDir = new File("d:\\desktop\\Java3");
        File destDir = new File("d:\\desktop\\Java4");
        List<String> list = new ArrayList<>();
        System.out.println("复制之前文件夹中的文件：");
        getFilePath(list, srcDir);
        for (String string : list) {
            System.out.println(string); // 输出复制钱文件夹中的所有文件
        }
        System.out.println();
        System.out.println("复制之后文件夹中的文件：");
        FileUtils.copyDirectory(srcDir, destDir);
        getFilePath(list, destDir);
        for (String string : list) {
            System.out.println(string); // 输出复制后文件夹中的所有文件
        }
    }

    // 获得 rootFile 文件夹中所有文件的绝对路径并将其保存在 list 中
    public static List<String> getFilePath(List<String> list, File rootFile) {
        File[] files = rootFile.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                getFilePath(list, file);
            } else {
                list.add(file.getAbsolutePath().replace("\\", File.separator));
            }
        }
        return list;
    }
}

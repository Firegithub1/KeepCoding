/**
 * 230：简化文件（夹）排序（Commons IO 组件简介）
 */

import org.apache.commons.io.comparator.SizeFileComparator;

import java.io.File;
import java.util.Arrays;

public class SizeFileComparatorTest {
    public static void main(String[] args) {
        File rootFile = new File("d:\\desktop\\Java5");
        File[] files = rootFile.listFiles();
        System.out.println("文件（夹）的原始排序：");
        for (File file : files) {
            System.out.println(file.getName() + "\t");
        }
        System.out.println();
        Arrays.sort(files, SizeFileComparator.SIZE_COMPARATOR);
        System.out.println("文件（夹）的 SIZE_COMPARATOR 排序：");
        for (File file : files) {
            System.out.println(file.getName() + "\t");
        }
        System.out.println();
        Arrays.sort(files, SizeFileComparator.SIZE_REVERSE);
        System.out.println("文件（夹）的 SIZE_REVERSE 排序：");
        for (File file : files) {
            System.out.println(file.getName() + "\t");
        }
        System.out.println();
        Arrays.sort(files, SizeFileComparator.SIZE_SUMDIR_COMPARATOR);
        System.out.println("文件（夹）的 SIZE_SUMDIR_COMPARATOR 排序：");
        for (File file : files) {
            System.out.println(file.getName() + "\t");
        }
        System.out.println();
        Arrays.sort(files, SizeFileComparator.SIZE_SUMDIR_REVERSE);
        System.out.println("文件（夹）的 SIZE_SUMDIR_REVERSE 排序：");
        for (File file : files) {
            System.out.println(file.getName() + "\t");
        }
    }
}

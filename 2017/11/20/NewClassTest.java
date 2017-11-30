/**
 * 158：动态实例化类
 */

import java.io.File;
import java.lang.reflect.Constructor;

public class NewClassTest {
    public static void main(String[] args) {
        try {
            // 获得 File 类的 Constructor 对象
            Constructor<File> constructor = File.class.getDeclaredConstructor(String.class);
            System.out.println("使用反射创建 File 对象");
            File file = constructor.newInstance("d://Java.txt");
            System.out.println("使用 File 对象在 D 盘创建文件：Java.txt");
            file.createNewFile(); // 创建新的文件
            System.out.println("文件是否创建成功：" + file.exists());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

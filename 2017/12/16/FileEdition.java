/**
 * 214：启动默认文本工具（其他常用类的使用）
 */

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FileEdition {
    public static void main(String[] args) {
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.edit(new File("d:\\desktop\\Java.txt"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

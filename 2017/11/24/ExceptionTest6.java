/**
 * 168：文件未发现异常（FileNotFoundException）
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionTest6 {
    public static void main(String[] args){
        FileInputStream fis=null;
        try{
            File file=new File("d:\\Java.txt");
            fis=new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * 201：重定向标准输出（System 类的使用）
 */

import java.io.*;

public class OutputRedirect {
    public static void main(String[] args) throws IOException {
        File file = new File("d:\\desktop\\java.txt");
        PrintStream out = new PrintStream(file);
        PrintStream cloneout = System.out;
        System.setOut(out);
        System.out.println("蝴蝶眨几次眼镜，");
        System.out.println("才学会飞行；");
        System.out.println("夜空洒满了星星，");
        System.out.println("但几颗会落地。");
        out.close();
        System.setOut(cloneout);
        BufferedReader read = new BufferedReader(new FileReader(file));
        String line = null;
        while ((line = read.readLine()) != null) {
            System.out.println(line);
        }
        read.close();
    }
}

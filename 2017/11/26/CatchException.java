/**
 * 173：捕获单个异常
 */

public class CatchException {
    public static void main(String[] args) {
        try {
            System.out.println("进入 try 块");
            Class<?> clazz = Class.forName("");
            System.out.println("离开 try 块");
        } catch (ClassNotFoundException e) {
            System.out.println("进入 catch 块");
            e.printStackTrace();
            System.out.println("离开 catch 块");
        } finally {
            System.out.println("进入 finally 块");
        }
    }
}

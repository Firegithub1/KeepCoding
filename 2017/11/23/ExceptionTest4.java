/**
 * 166：类未发现异常（ClassNotFoundException）
 */

public class ExceptionTest4 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

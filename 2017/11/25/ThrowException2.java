/**
 * 171：方法上抛出异常
 */

public class ThrowException2 {
    public static void throwsException() throws ClassNotFoundException {
        Class.forName("con.mysql.jdbc.Driver");
    }

    public static void main(String[] args) {
        try {
            ThrowException2.throwsException();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

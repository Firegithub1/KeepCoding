/**
 * 174：捕获多个异常
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CatchExceptions {
    private static String URL = "jdbc:mysql://3306/db_database18";
    private static String DRIVER = "com.mysql.jdbc.Driver";
    private static String USERNAME = "mr";
    private static String PASSWORD = "renkai";
    private static Connection connection;

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        CatchExceptions.getConnection();
    }
}

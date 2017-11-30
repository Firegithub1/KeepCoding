/**
 * 169：数据库操作异常（SQLException）
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ExceptionTest7 {
    public static void main(String[] args) {
        String URL = "jdb:mysql://localhost:3306/db_database";
        String DRIVER = "com.mysql.jdbc.Driver";
        String USERNAME = "mr";
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, "");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

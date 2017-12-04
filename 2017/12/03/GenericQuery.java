import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;


public class GenericQuery { // 定义 JDBC 参数
    private static String URL = "jdbc:mysql://localhost:3306/db_database";
    private static String DRIVER = "com.mysql.jdbc.Driver";
    private static String USERNAME = "renkai";
    private static String PASSWORD = "renkai123";
    private static Connection conn;

    public static Connection getConnection() {
        DbUtils.loadDriver(DRIVER); // 加载数据库驱动
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD); // 获得数据库连接
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static <T> List<T> query(String sql, Class<T> type) {
        QueryRunner qr = new QueryRunner();
        List<T> list = null; // 定义泛型参数类型的列表
        try { // 将 ResultSet 转换成类型为 T 的参数类型的列表
            list = qr.query(getConnection(), sql, new BeanListHandler<>(type));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(conn); // 释放连接
        }
        return list;
    }
}

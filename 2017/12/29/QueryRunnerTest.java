/**
 * 238：优雅的 JDBC 代码（其他 Commons 组件简介）
 */

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class QueryRunnerTest {
    // 定义 JDBC 相关参数
    private static String URL = "jdbc:mysql://localhost:3306/renkai01";
    // MySQL的JDBC URL编写方式：
    // jdbc:mysql://localhost:3306/renkai01
    // 主机名称：连接端口/数据库的名称
    private static String DRIVER = "com.mysql.jdbc.Driver";
    private static String USERNAME = "root";
    private static String PASSWORD = "";
    private static Connection conn;

    public static Connection getConnection() { // 用于获得数据库连接的工具方法
        DbUtils.loadDriver(DRIVER); // 加载曲东
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD); // 建立连接
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    private static int operate(String sql, Object... params) { // 用于执行有参数的 SQL 语句
        int result = 0;
        QueryRunner runner = new QueryRunner();
        try {
            result = runner.update(getConnection(), sql, params); // 执行 SQL 语句
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(conn); // 关闭连接
        }
        return result;
    }

    public static void main(String[] args) {
        String sql = "insert into users(username,password) values(?,?)";
        Object[] params = {"mrsoft", "Java"};
        operate(sql, params); // 向数据库中插入一条数据
    }
}

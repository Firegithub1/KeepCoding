/**
 * 239：结果集与 Bean 列表（其他 Commons 组件简介）
 */

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class QueryRunnerTest1 {
    private static String URL = "jdbc:mysql://localhost:3306/renkai01";
    private static String DRIVER = "com.mysql.jdbc.Driver";
    private static String USERNAME = "root";
    private static String PASSWORD = "";
    private static Connection conn;

    public static Connection getConnection() {
        DbUtils.loadDriver(DRIVER);
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static List<User> query(String sql) { // 用来将查询结果转换成 bean 列表的工具方法
        QueryRunner qr = new QueryRunner();
        List<User> list = null;
        try {
            list = qr.query(getConnection(), sql, new BeanListHandler<User>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println("表 users 中的全部数据如下：");
        List<User> list = query("select * from users");
        for (User user : list) {
            System.out.println(user);
        }
    }
}

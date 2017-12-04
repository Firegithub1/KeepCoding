/**
 * 186：泛型方法与数据查询
 */

import java.util.List;

public class GenericQueryTest {
    public static void main(String[] args) {
        String sql = "select * from books"; // 简单的查询语句
        List<Books> list = GenericQuery.query(sql, Books.class); // 获得 Bean 列表
        System.out.println("这是一本好书：");
        for (Books books : list) { // 输出 Bean 列表中的全部对象
            System.out.println(books);
        }
    }
}

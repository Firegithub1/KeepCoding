/**
 * 178：选择合适的枚举元素
 */

public enum JDBCInfo {
    DRIVER, URL, USERNAME, PASSWORD;

    public String getJDBCInfo(JDBCInfo info) {
        switch (info) {
            case DRIVER:
                return "com.mysql.jdbc.Driver";
            case URL:
                return "jdbc:mysql://localhost:3360/db_database";
            case USERNAME:
                return "renkai";
            case PASSWORD:
                return "renkai123";
            default:
                return null;
        }
    }

    public static void main(String[] args) {
        for (JDBCInfo info : JDBCInfo.values()) { // 遍历输出枚举元素的名称和对应的字符串
            System.out.println(info + ":" + info.getJDBCInfo(info));
        }
    }
}

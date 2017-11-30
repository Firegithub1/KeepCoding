/**
 * 177：增加枚举元素的信息
 */

public enum Size1 {
    SMALL("我是小马"), MEDIUM("我是中马"), LARGE("我是大马");
    private String description;

    private Size1(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static void main(String[] args) {
        for (Size1 size : Size1.values()) {
            System.out.println(size + ":" + size.getDescription()); // 输出所有枚举元素的信息
        }
    }
}

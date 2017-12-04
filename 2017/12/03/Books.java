public class Books {
    private int id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return id + ":" + name; // 重写 toString() 方法方便输出 Books 类的对象
    }
}

public abstract class Shape {
    public String getName() { // 获取图形的名称
        return this.getClass().getSimpleName();
    }

    public abstract double getArea();
}
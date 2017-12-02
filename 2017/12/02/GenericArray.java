import java.lang.reflect.Array;

public class GenericArray<T> {
    private T[] array; // 声明一个类型为 T 的数组 array
    private int size; // 声明一个整型变量保存数组的长度

    @SuppressWarnings("unchecked")
    public GenericArray(Class<T> type, int size) {
        this.size = size;
        array = (T[]) Array.newInstance(type, size); // 利用反射根据指定的类型和长度创建泛型数组
    }

    public void put(int index, T item) { // 向数组中增加元素的方法
        if (size > index) {
            array[index] = item;
        }
    }

    public T get(int index) { // 获得数组中元素的方法
        if (size > index) {
            return array[index];
        } else {
            return null;
        }
    }
}

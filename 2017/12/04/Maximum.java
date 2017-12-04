public interface Maximum<T extends Comparable<T>> {
    // 编写一个接口，其泛型参数类型是 Comparable 接口的子集
    T getMax(T[] array);
}

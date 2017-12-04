public class GenericComparison1<T extends Comparable<T>> implements Maximum<T> {
    @Override
    public T getMax(T[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        T max = array[0]; // 假设最大的元素是 array[0]
        for (int i = 1; i < array.length; i++) { // 遍历整个数组，如果某个元素比 max 大，则赋值给 max
            if (max.compareTo(array[i]) < 0) {
                max = array[i];
            }
        }
        return max;
    }
}

public class GenericComparison {
    public static <T extends Comparable<T>> T getMin(T[] array) {
        if (array == null || array.length == 0) { // 如果数组 array 是空则返回 null
            return null;
        }
        T min = array[0];
        for (int i = 1; i < array.length; i++) { //　遍历整个数组，如果比 min 小，则赋值给 min
            if (min.compareTo(array[i]) > 0) {
                min = array[i];
            }
        }
        return min;
    }
}

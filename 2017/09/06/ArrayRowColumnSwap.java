/**
 * 043：将二维数组中的行列互换
 * <p>
 * Java 中定义数组变量时，不能声明其长度，
 * 只能在 new 关键字创建数组时指定。
 * 例如，int[9] array=…… 是错误的写法，
 * 应该是 int[] array=new int[9];
 */


public class ArrayRowColumnSwap {
    public static void main(String[] args) {
        // 创建二维数组
        int arr[][] = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("行列互调前：");
        // 输出二维数组
        printArray(arr);
        int arr2[][] = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) { // 调整数组行列数据
            for (int j = 0; j < arr[i].length; j++) {
                arr2[i][j] = arr[j][i];
            }
        }
        System.out.println("行列互调后：");
        // 输出二维数组
        printArray(arr2);  // 原书代码这里有误，写的是输出arr
    }

    public static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) { // 遍历数组
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " "); // 输出数组元素
            }
            System.out.println();
        }
    }
}

/*运行结果：

行列互调前：
1 2 3
4 5 6
7 8 9
行列互调后：
1 4 7
2 5 8
3 6 9

 */

/**
 * 225：实数矩阵的运算（Commons Math 组件简介）
 */

import org.apache.commons.math.linear.Array2DRowRealMatrix;
import org.apache.commons.math.linear.RealMatrix;

import java.util.Arrays;

public class RealMatrixTest {
    public static void main(String[] args) {
        double[][] data1 = {{1, 2}, {3, 4}};
        RealMatrix m = new Array2DRowRealMatrix(data1); // 利用二维数组初始化矩阵
        System.out.println("矩阵 m 中的元素：");
        System.out.println(Arrays.deepToString(m.getData())); // 利用工具类输出矩阵中的元素
        double[][] data2 = {{1, 2}, {3, 4}};
        RealMatrix n = new Array2DRowRealMatrix(data2);
        System.out.println("矩阵 n 中的元素：");
        System.out.println(Arrays.deepToString(n.getData()));
        RealMatrix addition = m.add(n); // 矩阵加法
        RealMatrix subtraction = m.subtract(n); // 矩阵减法
        RealMatrix multiplication = m.multiply(n); // 矩阵乘法
        RealMatrix transposition = m.transpose(); // 矩阵转置
        System.out.println("矩阵 addition 中的元素：");
        System.out.println(Arrays.deepToString(addition.getData()));
        System.out.println("矩阵 subtraction 中的元素：");
        System.out.println(Arrays.deepToString(subtraction.getData()));
        System.out.println("矩阵 multiplication 中的元素：");
        System.out.println(Arrays.deepToString(multiplication.getData()));
        System.out.println("矩阵 m 转置后的新矩阵中的元素：");
        System.out.println(Arrays.deepToString(transposition.getData()));
    }
}

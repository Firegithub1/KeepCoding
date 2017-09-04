/**
 * 034：使用for循环输出杨辉三角
 */

public class YanghuiTriangle {
    public static void main(String[] args) {
        int triangle[][] = new int[8][]; // 创建二维数组
        for (int i = 0; i < triangle.length; i++) {
            triangle[i] = new int[i + 1]; // 初始化二维数组的大小
            for (int j = 0; j < triangle[i].length-1; j++) {
                if (i == 0 || j == 0 || j == triangle[i].length - 1) {
                    triangle[i][j] = 1;
                } else {
                    triangle[i][j] = triangle[i - 1][j] + triangle[i - 1][j - 1];
                }
                System.out.print(triangle[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
/*输出结果：
1
1	1
1	2	1
1	3	3	1
1	4	6	4	1
1	5	10	10	5	1
1	6	15	20	15	6	1
 */
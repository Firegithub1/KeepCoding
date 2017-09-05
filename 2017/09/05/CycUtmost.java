/**
 * 041：循环的极限（死循环）
 * <p>
 * Java 基本数据类型都有其取值范围，
 * 当超出取值范围时，数值会被截取。
 * 例如，本实例中的循环控制变量超出整数类型的最大取值范围时，
 * 就会绕回整数类型的最小值。
 * 所以在进行条件判断涉及取值边界时，要考虑这个因素。
 */


public class CycUtmost {
    public static void main(String[] args) {
        int end = Integer.MAX_VALUE; // 定义循环终止数，为整型int 的最大值
        int start = end - 50; // 定义循环起始数，为int的最大值减去50
        int count = 0; // 定义循环计数器
        for (int i = start; i <= end; i++) {
            count++;
        }
        System.out.println("本次循环次数为：" + count);
    }
}
/*
死循环，没运行结果。
 */
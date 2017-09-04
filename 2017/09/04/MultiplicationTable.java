/**
 *035：使用嵌套循环在控制台上输出九九乘法表
 */

public class MultiplicationTable {
    public static void main(String [] args){
        for(int i=0;i<=9;i++){ // 循环控制变量从1遍历到9
            for(int j=0;j<=i;j++){ // 第二层循环控制变量与第一层最大索引相等
                System.out.print(i+"*"+j+"="+i*j+"\t");
            }
            System.out.println(); // 在外层循环中换行
        }
    }
}

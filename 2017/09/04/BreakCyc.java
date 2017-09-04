/**
 * 039：终止循环体（break）
 * <p>
 * break 不仅可以结束其所在的循环，还可以直接结束其外层循环。
 * 此时需要在break后紧跟一个标签，这个标签用于标识一个外层循环。
 * Java 中的标签就是一个紧跟这英文冒号（:）的标识符。
 * 与其他语言不同的是，Java 中的标签只有放在循环语句之前才有作用。
 * 例如下面的 No1
 */

public class BreakCyc {
    public static void main(String[] args) {
        System.out.println("\n-----中断单层循环的例子。-----");
        String[] array = new String[]{"白鹭", "丹顶鹤", "黄鹂", "鹦鹉", "乌鸦", "喜鹊", "老鹰", "布谷鸟", "老鹰", "灰纹鸟", "老鹰", "百灵鸟"};
        System.out.println("在你发现第一只老鹰之前，告诉我都有什么鸟。");
        for (String string : array) {
            if (string.equals("老鹰"))
                break;
            System.out.print("有：" + string + "    ");
        }
        System.out.println("\n\n-----中断双层循环的例子。-----");
        int[][] myScore = new int[][]{{67, 78, 63, 22, 66}, {55, 68, 78, 35, 90}, {78, 89, 23, 43, 67}};
        System.out.println("宝宝这次考试成绩：\n数学\t语文\t英语\t美术\t历史");
        No1:
        for (int[] is : myScore) { // 遍历成绩表格
            for (int i : is) {
                System.out.print(i + "\t");
                if (i < 60) { // 如果中途遇见不及格，立刻中断所有输出
                    System.out.println("\n等等，" + i + "分的是什么？这个为什么不及格");
                    break No1;
                }
            }
        }
        System.out.println();
    }
}
/*运行结果：

-----中断单层循环的例子。-----
在你发现第一只老鹰之前，告诉我都有什么鸟。
有：白鹭    有：丹顶鹤    有：黄鹂    有：鹦鹉    有：乌鸦    有：喜鹊

-----中断双层循环的例子。-----
宝宝这次考试成绩：
数学	语文	英语	美术	历史
67	78	63	22
等等，22分的是什么？这个为什么不及格

 */

/**
 * 033：使用while与自增运算符循环遍历数组
 */

public class ErgodicArray {
    public static void main(String[] args) {
        String[] aves = new String[]{"白鹭", "丹顶鹤", "黄鹂", "鹦鹉", "乌鸦", "喜鹊", "布谷鸟", "灰纹鸟", "百灵鸟"};
        int index = 0;
        System.out.println("我的花园里有很多鸟，种类大约包括：");
        while (index < aves.length) { // 遍历数组
            System.out.println(aves[index++]); // 自增索引值
        }
    }
}

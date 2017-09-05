/**
 * 040：循环体的过滤器（continue语句）
 *
 * break 语句和 continue 语句都是对循环体的控制语句，
 * 它们不仅应用于 for 循环，
 * 在任何循环体中都可以使用这些语句，
 * 灵活使用可以让循环实现更加复杂的运算和业务处理。
 */

public class CycFilter {
    public static void main(String[] args) {
        String[] array = new String[]{"白鹭", "丹顶鹤", "黄鹂", "鹦鹉", "乌鸦", "喜鹊", "老鹰", "布谷鸟", "老鹰", "灰纹鸟", "老鹰", "百灵鸟"};
        System.out.println("在我的花园里有很多鸟类，但是最近来了几只老鹰，请帮我赶走它。");
        int eagleCount = 0;
        for (String string : array) {
            if(string.equals("老鹰")){ // 如果遇到老鹰
                System.out.println("发现一只老鹰，已经抓到笼子里了。");
                eagleCount++;
                continue; // 中断循环
            }
            System.out.println("搜索鸟类，发现了："+string); //　否则输出数组元素
        }
        System.out.println("一共捉到了："+eagleCount+"只老鹰。");
    }
}

/*运算结果：

在我的花园里有很多鸟类，但是最近来了几只老鹰，请帮我赶走它。
搜索鸟类，发现了：白鹭
搜索鸟类，发现了：丹顶鹤
搜索鸟类，发现了：黄鹂
搜索鸟类，发现了：鹦鹉
搜索鸟类，发现了：乌鸦
搜索鸟类，发现了：喜鹊
发现一只老鹰，已经抓到笼子里了。
搜索鸟类，发现了：布谷鸟
发现一只老鹰，已经抓到笼子里了。
搜索鸟类，发现了：灰纹鸟
发现一只老鹰，已经抓到笼子里了。
搜索鸟类，发现了：百灵鸟
一共捉到了：3只老鹰。

 */
/**
 * 223：绘制简单直方图（Commons Math 组件简介）
 */

import org.apache.commons.math.stat.Frequency;

import java.util.Random;

public class FrequencyTest {
    public static void main(String[] args) {
        Frequency frequency = new Frequency();
        for (int i = 0; i < 100; i++) {
            frequency.addValue(new Random().nextInt(10));
        }
        System.out.println("频度分布直方图");
        for (int i = 0; i < 10; i++) {
            System.out.print("数值" + i + "的频度：");
            for (int j = 0; j < frequency.getCount(i); j++) {
                System.out.print("*");
            }
            System.out.println("\t" + frequency.getCumFreq(i));
        }
    }
}

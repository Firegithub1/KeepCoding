/**
 * 227：T 分布常用运算（Commons Math 组件简介）
 */

import org.apache.commons.math.MathException;
import org.apache.commons.math.distribution.TDistributionImpl;

public class TDistributionImplTest {
    public static void main(String[] args) throws MathException {
        TDistributionImpl t = new TDistributionImpl(5); // 新建一个自由度为 5 的 T 分布
        System.out.println("当前 T 分布的自由度：" + t.getDegreesOfFreedom());
        double upperTail = t.cumulativeProbability(0.7267);
        System.out.println("计算域大于 0.7267 的置信度" + upperTail);
        System.out.println("计算 0 点的概率密度：" + t.density(0));
        double domain = t.inverseCumulativeProbability(0.75);
        System.out.println("计算置信度大于 0.75 的域值：" + domain);
    }
}

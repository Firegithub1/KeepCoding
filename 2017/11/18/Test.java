/**
 * 154：按继承层次对类排序
 */

import javax.swing.*;
import java.awt.*;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        TreeSet<Class<?>> treeSet = new TreeSet<Class<?>>(new ClassComparator());
        System.out.println("向树集中添加 JPanel.class");
        treeSet.add(JPanel.class); // 向树集中添加 JPanel.class
        System.out.println("向树集中添加 JComponent.class");
        treeSet.add(JComponent.class);
        System.out.println("向树集中添加 Container.class");
        treeSet.add(Container.class);
        System.out.println("获得树集的最后一个元素：");
        System.out.println(treeSet.last());
    }
}

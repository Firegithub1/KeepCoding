/**
 * 091：汉诺塔问题求解（讲真，没怎么看懂！）
 */

public class HanoiTower {
    public static void moveDish(int level, char from, char inter, char to) {
        if (level == 1) { // 如果只有 1 个盘子就退出迭代
            System.out.println("从 " + from + " 移动盘子 1 号到 " + to);
        } else { // 如果有大于 1 个盘子就继续迭代
            moveDish(level - 1, from, to, inter);
            System.out.println("从 " + from + " 移动盘子 " + level + " 号到 " + to);
            moveDish(level - 1, inter, from, to);
        }
    }

    public static void main(String[] args) {
        int nDisks = 3; // 设置汉诺塔为 3 阶
        moveDish(nDisks, 'A', 'B', 'C'); // 实现移动算法
    }
}

/*
运行结果：

从 A 移动盘子 1 号到 C
从 A 移动盘子 2 号到 B
从 C 移动盘子 1 号到 B
从 A 移动盘子 3 号到 C
从 B 移动盘子 1 号到 A
从 B 移动盘子 2 号到 C
从 A 移动盘子 1 号到 C
 */
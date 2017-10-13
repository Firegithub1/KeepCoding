/**
 * 097：Double 类型的比较
 */

public class DoubleTest {
    public static void main(String[] args) {
        Double number1 = 12.3;
        Double number2 = 12.3;
        System.out.println("number1：" + number1);
        System.out.println("number2：" + number2);
        switch (number1.compareTo(number2)) {
            case -1:
                System.out.println("number1<number2");
                break;
            case 0:
                System.out.println("number1==number2");
                break;
            case 1:
                System.out.println("number1>number2");
                break;
        }
    }
}

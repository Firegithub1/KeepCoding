/**
 * 163：数组存值异常（ArrayStoreException）
 */

public class ExceptionTest1 {
    public static void main(String[] args) {
        Object[] array = new String[3];
        array[0] = new Integer(1);
        System.out.println(array[0]);
    }
}

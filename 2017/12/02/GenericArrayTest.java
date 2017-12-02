/**
 * 185：自定义泛型化数组类
 */

public class GenericArrayTest {
    public static void main(String[] args){
        System.out.println("创建 String 类型的数组并向其添加元素：Java教程");
        GenericArray<String> stringArray=new GenericArray<>(String.class,10);
        stringArray.put(0,"Java教程");
        System.out.println("String 类型的数组元素："+stringArray.get(0));
        System.out.println("创建 Integer 类型的数组并向其添加元素：123456789");
        GenericArray<Integer> integerArray=new GenericArray<>(Integer.class,10);
        integerArray.put(0,123456789);
        System.out.println("Integer 类型的数组元素：" +integerArray.get(0));
    }
}

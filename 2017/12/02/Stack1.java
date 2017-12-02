import java.util.LinkedList;

public class Stack1<T> { // 定义参数类型为 T 的类
    private LinkedList<T> container = new LinkedList<T>(); // 使用 T 类型的链表保存入栈的元素

    public void push(T t) { // 实现了向栈中增加元素的功能
        container.addFirst(t);
    }

    public T pop() { // 实现了从栈中删除元素的功能
        return container.removeFirst();
    }

    public boolean empty() { // 判断链表中是否有可用元素
        return container.isEmpty();
    }
}

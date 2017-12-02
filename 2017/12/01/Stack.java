public class Stack {
    private Object[] container = new Object[10]; // 使用 Object 类型的数组保存入栈的元素
    private int index = 0; // 使用整数作为指针来表示数组的使用情况

    public void push(Object o) { // 实现了向栈中增加元素的功能
        if (index != container.length) { // 如果数组中还有可用空间，则增加元素
            container[index++] = o; // 在增加完一个元素后将指针后移一位
        }
    }

    public Object pop() { // 实现了从栈中删除元素的功能
        if (index != -1) { // 如果数组中还有可用元素，则删除一个元素
            return container[--index]; // 在删除完一个元素后指针前移一位
        }
        return null; // 如果数组中没有元素，则返回 null
    }

    public boolean empty() { // 判断数组中是否有可用元素
        if (index == 0) {
            return true;
        } else {
            return false;
        }
    }
}

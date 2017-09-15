# 用动态数组保存学生姓名

Java 中提供了各种数据集合类，这些类主要用于保存复杂结构的数据，其中 ArrayList 集合可以看作动态数组。它突破普通数组固定长度的限制，可以随时向数组中添加和移除元素，这将使数组更加灵活，如果要获取普通数组，还可以通过该类的 toArray() 方法获得。

### 添加元素

add() 方法可以为数组集合添加元素，其中元素类型任意。该方法声明如下：

```java
public boolean add(E element)
```

参数说明：

- element：要添加到集合中的任意类型的元素值或对象。

- 返回值：是否成功添加数据。

### 移除元素

remove() 方法可以移除集合中的指定元素，其中只包含 Object 类型参数的此方法的重载格式可以从集合中移除首次出现指定值的元素。该方法的声明如下：

```java
public boolean remove(Object object)
```

参数说明：

- object：要从集合中移除的对象。

- 返回值：是否成功移除数据。

**核心代码：**<a href="https://github.com/renkaigis/KeepCoding/tree/master/2017/09/15" target="_blank">转到github查看源码</a>

1）编写“添加学生”按钮的事件处理方法，在该方法中获取用户在文本框的输入字符串，然后将这个字符串添加到 ArrayList 集合中，再调用 replaceModel() 方法把集合中的数据显示到窗体的列表控件中。

```java
protected void do_button_actionPerformed(ActionEvent e) {
    textField.requestFocusInWindow(); 
    textField.selectAll(); // 选择文本框文本准备下次输入
    String text = textField.getText(); // 获取用户输入姓名
    if (text.isEmpty()) { // 过滤为输入姓名的情况
        return;
    }
    arraylist.add(text); // 把姓名添加到数组集合中
    replaceModel(); // 把数组集合中的内容显示到界面列表控件中
}
```

2）编写“删除学校”按钮的事件处理方法，在该方法中获取列表控件的当前选择项，然后从 ArrayList 集合中移除这个选择项的值，最后调用 replaceModel() 方法把集合中的数据显示到窗体的列表控件中。

```java
protected void do_button_1_actionPerformed(ActionEvent e) {
    Object value = list.getSelectedValue(); // 获取列表控件的选择项
    arraylist.remove(value); // 从数组集合中移除用户的选择项
    replaceModel(); // 把数组集合中的内容显示到界面列表的控件中
}
```

3）编写 replaceModel() 方法，在该方法中重新设置列表控件的模型，然后读取 ArrayList 集合的元素并显示到列表控件中。

```java
private void replaceModel() {
    // 为列表控件设置数据模型显示数组集合中的数据
    list.setModel(new AbstractListModel() {
        public int getSize() { // 获取数组大小
            return arraylist.size();
        }

        public Object getElementAt(int index) { // 获取指定索引元素
            return arraylist.get(index);
        }
    });
}
```

运行结果：

<div align="center"><img src="http://image.renkaigis.com/keepcoding/2017091501.png"></div><br>
<div align="center"><img src="http://image.renkaigis.com/keepcoding/2017091502.png"></div>
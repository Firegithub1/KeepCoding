# 直接插入排序

插入排序是将一个记录插入到有序数列中，使得到的新的数列仍然有序。

**插入排序算法思想：** 将 n 个有序数存放在数组 a 中，要插入的数为 x，首先确定 x 插在数组中的位置 p，数组中 p 之后的元素都向后移一个位置，空出 a(p)，将 x 放入 a(p)。这样即可实现插入后数列仍然有序。

**核心代码：**<a href="https://github.com/renkaigis/KeepCoding/tree/master/2017/09/13" target="_blank">转至 github 查看源码</a>

1）编写 `随机生成数组` 按钮的事件处理方法，在该方法中利用 `Random` 类的实例对象的 `nextInt()` 方法生成随机数，并为数组设置初始值。

```java
private int[] array = new int[10];

protected void do_button_actionPerformed(ActionEvent e) {
    Random random = new Random(); // 创建随机数对象
    textArea1.setText("");
    for (int i = 0; i < array.length; i++) { // 初始化数组元素
        array[i] = random.nextInt(90); // 生成90以内的随机数
        textArea1.append(array[i] + "\n"); // 把数组元素显示在文本域控件中
    }
}
```

2）编写 `插入排序法` 按钮的事件处理方法，在该方法中使用插入排序算法对数组进行排序，并把排序后的数组显示到界面中。

```java
protected void do_button_1_actionPerformed(ActionEvent e) {
    int tmp; // 定义临时变量
    int j;
    for (int i = 1; i < array.length; i++) {
        tmp = array[i]; // 保存临时变量
        for (j = i - 1; j >= 0 && array[j] > tmp; j--) {
            array[j + 1] = array[j]; // 数组元素交换
        }
        array[j + 1] = tmp; // 在排序位置插入数据
    }
    textArea2.setText("");
    for (int i = 0; i < array.length; i++) { // 初始化数组元素
        textArea2.append(array[i] + "\n"); // 把数组元素显示在文本域控件中
    }
}
```

**运行结果：**

<div align="center"><img src="http://image.renkaigis.com/keepcoding/2017091301.png"></div>

# 用 Arrays 类中的 sort 方法对数组进行排序

`Arrays` 类位于 `java.util` 包中，它是数组的一个工具类，包含很多方法，其中 `sort()` 方法就是 `Arrays` 类提供的对数组进行排序的方法，它有很多重载格式，可以接收任何数据类型的数组并执行不同类型的排序。

其 `int` 重载实现方法声明如下：

```java
public static void sort(int[] array)
```

参数说明：

`array`：要排序的 `int` 类型的一维数组。

> 代码中的 `(char)8` 指的是`退格键`

**核心代码：**<a href="https://github.com/renkaigis/KeepCoding/tree/master/2017/09/13" target="_blank">转至 github 查看源码</a>

1）为 `排序` 按钮编写事件处理方法，在该方法中要接收用户的输入字符串，并以字符串中的空格字符分割字符串为数组，再把字符串数组转换为整数数组，然后调用 `Arrays` 类的 `sort()` 方法对其进行排序，最后显示到窗体中。

```java
protected void do_button_actionPerformed(ActionEvent e) {
    String text = arrayField.getText(); // 获取用户输入
    String[] arrayStr = text.split(" {1,}"); // 拆分输入为数组
    int[] array = new int[arrayStr.length]; // 创建整数类型数组
    sortArea.setText("数组原有内容：\n");
    for (String string : arrayStr) { // 输出原有数组内容
        sortArea.append(string + "  ");
    }
    for (int i = 0; i < array.length; i++) { // 初始化整型数组
        array[i] = Integer.parseInt(arrayStr[i]);
    }
    sortArea.append("\n");
    Arrays.sort(array);
    sortArea.append("数组排序后的内容：\n"); // 使用 sort() 方法对整型数组进行排序
    for (int value : array) {
        sortArea.append(value + "  "); // 输出排序后的数组内容
    }
}
```

2）编写文本框的事件处理方法，通过该方法的编写来限制文本框可输入的字符，当用户按下非数字与空格字符时，取消本次输入的有效性。

```java
protected void do_arrayField_keyPressed(KeyEvent e) {
    char key = e.getKeyChar(); // 获取用户按键字符
    String mask = "0123456789 " + (char) 8; // (char)8 指的是退格键 // 定义规范化字符模板
    if (mask.indexOf(key) == -1) { // 判断按键字符是否属于规范化字符范围
        e.consume(); // 取消非规范化字符的输入有效性
    }
}
```

**运行结果：**

<div align="center"><img src="http://image.renkaigis.com/keepcoding/2017091302.png"></div>
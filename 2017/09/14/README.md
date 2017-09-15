# 反转数组中的元素

*本来我以为是一种排序方法，后来发现只是反转过来，并没有排序，这么智障的算法！*

数组反转算法实现思路是：

把数组最后一个元素与第一个元素替换，倒数第二个元素与第二个元素替换，依次类推，直至把所有数组元素反转替换。

反转排序是对数组两边的元素进行替换，所以只需要循环数组长度的半数。

例如，数组长度为 7，那么 for 循环只需要循环 7/2 也就是 3 次，具体例子如下：

初始数据：12 23 34 45 56 67 78 89 90

第一趟：90 【23 34 45 56 67 78 89】 12

第二趟：90 89 【34 45 56 67 78】 23 12

第三趟：90 89 78 【45 56 67】 34 23 12

第四趟：90 89 78 67 【56】 45 34 23 12

最后反转的数：90 89 78 67 56 45 34 23 12


**核心代码：**<a href="https://github.com/renkaigis/KeepCoding/tree/master/2017/09/14">转到github查看源码</a>

```java
protected void do_button_actionPerformed(ActionEvent e) {
    String inText = textField.getText(); // 获取用户输入
    String[] array = inText.split(" {1,}"); // 把字符串分割为数组
    int len = array.length; // 获取数组长度
    textArea.setText(""); // 清空文本域控件内容
    for (int i = 0; i < len / 2; i++) { // 反转数组元素
        String temp = array[i];
        array[i] = array[len - 1 - i];
        array[len - 1 - i] = temp;
        for (String string : array) { // 在文本域控件显示数组排序过程
            textArea.append(string + "  ");
        }
        textArea.append("\n");
    }
}
```

运行结果：

<div align="center"><img src="http://image.renkaigis.com/keepcoding/2017091401.png"></div>


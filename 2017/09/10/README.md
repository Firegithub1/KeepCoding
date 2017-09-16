# 快速排序法

其是对冒泡排序的一种改进，排序速度相对较快。

**基本思想：** 通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据比另外一部分的所有数据都要小，然后再按照此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此使整个数据变成有序序列。

假设要排序的数组是a[1]……a[n]，首先任意选取一个数据（通常选择第一个数据）作为关键数据，然后将所有比它小的数都放在它前面，所有比它大的书都放在它的后面，这个过程称为一趟排序，递归调用此过程，即可实现数组的快速排序。

### 例如：

初始

｛49 86 57 34 62 15 78 44｝

第一趟：

｛34 15 44｝49｛86 57 62 78｝

序列左排序：

｛15 34 44｝49｛86 57 62 78｝

序列右排序：

15 34 44 49｛57 62 78｝86

继续：

15 34 44 49 57 62 78 86

（上面是最终结果）

**核心代码：**<a href="https://github.com/renkaigis/KeepCoding/tree/master/2017/09/12" target="_blank">转至 github 查看源码</a>

1）编写 `生成随机数` 按钮的事件处理方法，在该方法中创建 `Random` 随机数对象，初始化数组元素值时，通过该对象为每个数组元素生成随机数。

```java
private int[] array = new int[10];

protected void do_button_1_actionPerformed(ActionEvent e) {
    Random random = new Random(); // 创建随机数对象
    String text = "";
    for (int i = 0; i < array.length; i++) {
        array[i] = random.nextInt(90);
        text += (array[i] + "  ");
    }
    textField.setText(text);
}
```

2）编写 `快速排序法` 按钮的事件处理方法，在该方法中利用快速排序算法对生成的随机数组进行排序，并将排序过程输出到文本域控件中。

```java
protected void do_button_actionPerformed(ActionEvent e) {
    textArea.setText(""); // 清空文本域
    quickSort(array, 0, array.length - 1); // 调用快速排序算法
}
```

3）编写快速排序方法 `quickSort()` ，这个方法将被按钮的事件处理方法调用，该方法在实现快速排序的同时，把排序过程显示到文本域控件中。

```java
private void quickSort(int sortarray[], int lowIndex, int highIndex) {
    int lo = lowIndex; // 记录最小索引
    int hi = highIndex; // 记录最大索引
    int mid; // 记录分界点元素
    if (highIndex > lowIndex) {
        mid = sortarray[(lowIndex + highIndex) / 2]; // 确定中间分界点元素值
        while (lo <= hi) {
            while ((lo < highIndex) && (sortarray[lo] < mid))
                ++lo; // 确定不大于分解元素值的最小索引
            while ((hi > lowIndex) && (sortarray[hi] > mid))
                --hi; // 确定大鱼分解元素之的最大索引
            if (lo <= hi) { // 如果最小和最大索引没有重叠
                swap(sortarray, lo, hi); // 交换两个索引的元素
                ++lo; // 递增最小索引
                --hi; // 递减最大索引
            }
        }
        if (lowIndex < hi) // 递归排序没有未分解元素
            quickSort(sortarray, lowIndex, hi);
        if (lo < highIndex) // 递归排序没有未分解元素
            quickSort(sortarray, lo, highIndex);
    }
}
```

4）由于快速排序方法中频繁地交换数组元素，而且在程序代码中出现的位置较多，所以应该把数组元素交换单独提炼为一个 `swap()` 方法，以实现代码重用，并且在该方法中掌握排序过程并显示到文本域控件中。 

```java
private void swap(int swapArray[], int i, int j) {
    int temp = swapArray[i]; // 交换数组元素
    swapArray[i] = swapArray[j];
    swapArray[j] = temp;
    for (int k = 0; k < array.length; k++) { // 把数组元素显示到文本域控件中
        textArea.append(array[k] + "  ");
    }
    textArea.append("\n"); // 追加换行符
}
```

**运行结果：**

<div align="center"><img src="http://image.renkaigis.com/keepcoding/2017091201.png"></div>


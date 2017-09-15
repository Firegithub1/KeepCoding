# 快速排序法

其是对冒泡排序的一种改进，排序速度相对较快。

基本思想是：通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据比另外一部分的所有数据都要小，然后再按照此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此使整个数据变成有序序列。

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

**核心代码：**<a href="https://github.com/renkaigis/KeepCoding/tree/master/2017/09/12">转到github查看源码</a>

```java
protected void do_button_1_actionPerformed(ActionEvent e) {
    Random random = new Random();
    String text = "";
    for (int i = 0; i < array.length; i++) {
        array[i] = random.nextInt(90);
        text += (array[i] + "  ");
    }
    textField.setText(text);
}

protected void do_button_actionPerformed(ActionEvent e) {
    textArea.setText("");
    quickSort(array, 0, array.length - 1);
}

private void quickSort(int sortarray[], int lowIndex, int highIndex) {
    int lo = lowIndex;
    int hi = highIndex;
    int mid;
    if (highIndex > lowIndex) {
        mid = sortarray[(lowIndex + highIndex) / 2];
        while (lo <= hi) {
            while ((lo < highIndex) && (sortarray[lo] < mid))
                ++lo;
            while ((hi > lowIndex) && (sortarray[hi] > mid))
                --hi;
            if (lo <= hi) {
                swap(sortarray, lo, hi);
                ++lo;
                --hi;
            }
        }
        if (lowIndex < hi)
            quickSort(sortarray, lowIndex, hi);
        if (lo < highIndex)
            quickSort(sortarray, lo, highIndex);
    }
}

private void swap(int swapArray[], int i, int j) {
    int temp = swapArray[i];
    swapArray[i] = swapArray[j];
    swapArray[j] = temp;
    for (int k = 0; k < array.length; k++) {
        textArea.append(array[k] + "  ");
    }
    textArea.append("\n");
}
```

运行结果：

<div align="center"><img src="http://image.renkaigis.com/keepcoding/2017091201.png"></div>


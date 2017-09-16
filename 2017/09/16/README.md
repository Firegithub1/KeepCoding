# 用 List 集合传递学生信息

集合在程序开发中经常用到。例如，在业务方法中将学生信息、商品信息等存储到集合中，然后作为方法的返回值返回给调用者，以此传递大量的有序数据。

本实例使用 `List` 集合在方法之间传递学生信息。

**核心代码：**<a href="https://github.com/renkaigis/KeepCoding/tree/master/2017/09/15" target="_blank">转至 github 查看源码</a>

1）编写 `getTable` 方法。在该方法中创建表格对象并设置表格的数据模型，然后调用 `getStudents()` 方法获取保存学信息的集合对象，在遍历该集合对象的同时把每个元素添加到表格模型的行，并显示到表格控件中。

```java
private JTable getTable() {
    if (table == null) {
        table = new JTable(); // 创建表格控件
        table.setRowHeight(23); // 设置行高度
        String[] columns = {"姓名", "性别", "出生日期"}; // 创建列名数组
        // 创建表格模型
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        table.setModel(model); // 设置表格模型
        List<String> students = getStudents(); // 调用方法传递list集合对象
        for (String info : students) { // 遍历学生集合对象
            String[] args = info.split(","); // 把学生信息拆分为数组
            model.addRow(args); // 把学生信息添加到表格的行
        }
    }
    return table;
}
```

2）编写 `getStudents()` 方法。该方法将向调用者传递 `List` 集合对象，并为集合对象添加多个元素，每个元素值都是一个学生信息，其中包括姓名、性别、出生日期。

```java
private List<String> getStudents() {
    // 创建List集合对象
    List<String> list = new ArrayList<String>();
    list.add("李刚,男,1990-1-1"); // 添加数据到集合对象
    list.add("陈胜,男,1993-2-3");
    list.add("王一,女,1995-8-10");
    list.add("小李,男,1992-5-7");
    list.add("小张,女,1993-9-26");
    list.add("小徐,女,1994-4-16");
    list.add("小江,男,1992-8-20");
    return list;
}
```

**运行结果：**

<div align="center"><img src="http://image.renkaigis.com/keepcoding/2017091601.png"></div>
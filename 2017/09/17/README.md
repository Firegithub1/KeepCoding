# 用 TreeSet 生成不重复自动排序随机数组

> 随机数组就是在指定长度的数组中用随机数字为每个元素赋值，这常用于需要不确定数值的环境，如拼图游戏需要随机数组来打乱图片排序。可是同时也存在问题，就是随机数的重复问题，这个问题也常常被忽略，本实例利用 `TreeSet` 集合实现不重复数列，并自动完成元素的排序然后生成数组。

本实例使用了 `TreeSet` 集合对象的 API 实现元素的添加以及数组的提取。

### 添加元素

`TreeSet` 类的 `add()` 方法可以为集合添加元素，`TreeSet` 集合属于 `Set` 集合的子类，`Set` 集合不允许有重复的元素存在，所以重复数据是不允许添加到 `Set` 集合中的，而 `add()` 方法的返回值可以确定添加操作是否成功完成。

该方法的声明如下：

```java
public boolean add(E e)
```

- e：要添加到集合中的任意类型的数据。

- 返回值：如果 `Set` 集合没有重复值并成功添加数据则返回 `true`，否则返回 `false`。

### 提取集合中的数组

`Java` 的集合对象可以调用 `toArray` 方法把集合中的所有数据提取到一个新的数组中。声明如下：

```java
public <T> T[] toArray(T[] array)
```

- array：保存集合数据的数组。

- 返回值：如果参数 `array` 指定的数组长度小于 `Set` 集合元素的数量，则返回新的可以容纳 `Set` 集合所有元素的数组。否则返回参数指定的数组对象。

**核心代码：**<a href="https://github.com/renkaigis/KeepCoding/tree/master/2017/09/17" target="_blank">转至 github 查看源码</a>

在类的主方法中创建 `TreeSet` 集合对象，在创建 `Random` 随机对象，然后通过计数器控制循环生成随机数并添加到集合对象中，最后通过集合对象提取数组并显示在控制台中。

```java
import java.util.Random;
import java.util.TreeSet;

public class RandomSortArray {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<Integer>();
        Random ran = new Random();
        int count = 0;
        while (count < 10) {
            boolean succeed = set.add(ran.nextInt(100));
            if (succeed)
                count++;
        }
        int size = set.size();
        Integer[] array = new Integer[size];
        set.toArray(array);
        System.out.println("生成的不重复随机数组内容如下：");
        for (int value : array) {
            System.out.print(value + "  ");
        }
    }
}
```

**运行结果：**

<div align="center"><img src="http://image.renkaigis.com/keepcoding/2017091701.png"></div>

# Map 映射集合实现省市级联选择框

> `Map` 集合可以保存键值映射关系。本实例利用 `Map` 集合实现了省市级联选择框，当选择省份信息时，将改变城市下拉列表框对应的内容。

本实例关键技术是使用了 `Map` 集合保存键值对数据，这样可以根据指定的键名称来获取值数据。

### 添加映射键值对

本实例通过 `Map` 集合保存省市系你想，省份作为映射的键，城市数组作为键对应的值。Map 映射提供了 `put()` 方法来为集合添加数据。

该方法的声明如下：

```java
V put(K key,V value)
```

- key：与指定值关联的键。

- value：与指定键关联的值。

- 返回值：以前与 key 关联的值，如果没有针对 key 的映射关系，则返回 null。

### 获取键对应的值

Map 集合 `get()` 方法返回指定键所映射的值，如果此映射不包含该键的映射关系，则返回 null 值。声明如下：

```java
V get(Boject key)
```

- key：要返回其关联值的键。

- 返回值：指定键所映射的值；如果此映射不包含该键的映射关系，则返回 null。

### 获取键的 Set 集合

Map 集合可以获取所有键的 Set 集合，这个集合中包含 Map 中的所有键，本实例通过 `keySet()` 方法获取所有键的信息来为下拉列表框添加内容。声明如下：

```java
Set<K> keySet()
```

**核心代码：**<a href="https://github.com/renkaigis/KeepCoding/tree/master/2017/09/17" target="_blank">转至 github 查看源码</a>

1）创建一个类 `CityMap` ，在该类中创建并初始化 Map 集合对象，在该对象中保存各省市中的关联信息。

```java
class CityMap {
    public static Map<String,String[]> model=new LinkedHashMap();
    static {
        model.put("北京", new String[] {"北京"});
        model.put("上海", new String[]{"上海"});
        model.put("天津", new String[]{"天津"});
        model.put("重庆", new String[]{"重庆"});
        model.put("黑龙江", new String[]{"哈尔滨","齐齐哈尔","牡丹江","大庆","伊春","双鸭山","鹤岗","鸡西","佳木斯","七台河","黑河","绥化","大兴安岭"});
        model.put("吉林", new String[]{"长春","延边","吉林","白山","白城","四平","松原","辽源","大安","通化"});
        // 忽略下面的省份
    }
}
```

2）编写 `getProvince()` 方法，获取 Map 集合的键映射，也就是省份信息的 Set 集合，然后将该集合转换为数组，并作为方法的返回值，这个方法将在省份下拉列表框的初始化代码时调用。

```java
public Object[] getProvince() {
    Map<String, String[]> map = CityMap.model; // 获取省份信息保存到Map中
    Set<String> set = map.keySet(); // 获取Map集合中的键，并以Set集合返回
    Object[] province = set.toArray(); // 转换为数组
    return province; // 返回获取的省份信息
}
```

3）编写选择省份的下拉列表框的事件处理方法，该方法在省份下拉列表框改变选项时被调用，方法首先获取下拉列表框的选项值，然后把该值作为键到 Map 集合中查找对应该键的值，返回结果是对应省份的所有城市名称组成的数组。最后用这个数组创建一个数据模型添加到城市下拉列表框控件中。

```java
public void itemChange() {
    String selectProvince = (String) comboBox.getSelectedItem();
    cityComboBox.removeAllItems(); // 清空市/县列表
    String[] arrCity = getCity(selectProvince); // 获取市/县
    cityComboBox.setModel(new DefaultComboBoxModel(arrCity)); // 重新添加市/县列表的值
}
```

4）编写 `getCity()` 方法，该方法主要负责获取对应省份的城市数组，它将在省份下拉列表框控件的事件处理方法中被调用。

```java
public String[] getCity(String selectProvince) {
    Map<String, String[]> map = CityMap.model; // 获取省份信息保存到Map中
    String[] arrCity = map.get(selectProvince); // 获取指定键的值
    return arrCity; // 返回获取的市/县
}
```

**运行结果：**

<div align="center"><img src="http://image.renkaigis.com/keepcoding/2017091702.png"></div>
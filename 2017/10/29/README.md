# 局部内部类的简单应用

Java 中可以将类定义在方法的内部，称为局部内部类。这种类不能使用 public、private 修饰，它的作用域被限定在声明这个类的方法中。局部内部类和其他内部类相比还有一个优点，可以访问参数。

一个最简单的局部内部类代码如下：

```java
public void book(){
    public class JavaBook{
        
    }
}
```

**注意：** 被局部内部类使用的方法参数必须是 final 的。

运行结果：

<img src="http://image.renkaigis.com/keepcoding/2017102902.png">

# 匿名内部类的简单应用

当只需要创建类的一个对象时，可以使用匿名内部类。ActionListener 是 Swing 中动作事件的监听器，如果创建该接口的匿名内部类。代码如下：

```java
ActionListener listener=new ActionListener(){
    public void actionPerformed(ActionEvent e){
        
    }
};
```

**注意：** 不要忘记写最后的那个 “;”，这是语句结束的标识，和内部类无关。

运行结果：

<img src="http://image.renkaigis.com/keepcoding/2017102901.png">
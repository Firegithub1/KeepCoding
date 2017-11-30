# 152：查看类的声明

<img src="http://image.renkaigis.com/keepcoding/2017111701.png">

运行结果：

```java
类的标准名称：java.util.ArrayList
类的修饰符：public
类的泛型参数：E	
类所实现的接口：
	java.util.List<E>
	interface java.util.RandomAccess
	interface java.lang.Cloneable
	interface java.io.Serializable
类的直接继承类：java.util.AbstractList<E>
类的注解：空
```

# 153：查看类的成员

<img src="http://image.renkaigis.com/keepcoding/2017111702.png">

运行结果：

```java
类的标准名称：java.util.ArrayList
类的构造方法：
	public java.util.ArrayList(java.util.Collection)
	public java.util.ArrayList()
	public java.util.ArrayList(int)
类的非继承域变量：
	private static final long java.util.ArrayList.serialVersionUID
	private static final int java.util.ArrayList.DEFAULT_CAPACITY
	private static final java.lang.Object[] java.util.ArrayList.EMPTY_ELEMENTDATA
	private static final java.lang.Object[] java.util.ArrayList.DEFAULTCAPACITY_EMPTY_ELEMENTDATA
	transient java.lang.Object[] java.util.ArrayList.elementData
	private int java.util.ArrayList.size
	private static final int java.util.ArrayList.MAX_ARRAY_SIZE
类的非继承方法：
public boolean java.util.ArrayList.add(java.lang.Object)
public void java.util.ArrayList.add(int,java.lang.Object)
public boolean java.util.ArrayList.remove(java.lang.Object)
public java.lang.Object java.util.ArrayList.remove(int)
public java.lang.Object java.util.ArrayList.get(int)
public java.lang.Object java.util.ArrayList.clone()
public int java.util.ArrayList.indexOf(java.lang.Object)
public void java.util.ArrayList.clear()
public boolean java.util.ArrayList.contains(java.lang.Object)
public boolean java.util.ArrayList.isEmpty()
public java.util.Iterator java.util.ArrayList.iterator()
public int java.util.ArrayList.lastIndexOf(java.lang.Object)
public void java.util.ArrayList.replaceAll(java.util.function.UnaryOperator)
public int java.util.ArrayList.size()
public java.util.List java.util.ArrayList.subList(int,int)
public java.lang.Object[] java.util.ArrayList.toArray(java.lang.Object[])
public java.lang.Object[] java.util.ArrayList.toArray()
public java.util.Spliterator java.util.ArrayList.spliterator()
static int java.util.ArrayList.access$100(java.util.ArrayList)
public boolean java.util.ArrayList.addAll(int,java.util.Collection)
public boolean java.util.ArrayList.addAll(java.util.Collection)
private void java.util.ArrayList.readObject(java.io.ObjectInputStream) throws java.io.IOException,java.lang.ClassNotFoundException
private void java.util.ArrayList.writeObject(java.io.ObjectOutputStream) throws java.io.IOException
public void java.util.ArrayList.forEach(java.util.function.Consumer)
public java.lang.Object java.util.ArrayList.set(int,java.lang.Object)
public void java.util.ArrayList.ensureCapacity(int)
public void java.util.ArrayList.trimToSize()
private void java.util.ArrayList.ensureCapacityInternal(int)
private static int java.util.ArrayList.hugeCapacity(int)
java.lang.Object java.util.ArrayList.elementData(int)
private void java.util.ArrayList.grow(int)
public java.util.ListIterator java.util.ArrayList.listIterator()
public java.util.ListIterator java.util.ArrayList.listIterator(int)
public boolean java.util.ArrayList.removeAll(java.util.Collection)
public boolean java.util.ArrayList.removeIf(java.util.function.Predicate)
protected void java.util.ArrayList.removeRange(int,int)
public boolean java.util.ArrayList.retainAll(java.util.Collection)
public void java.util.ArrayList.sort(java.util.Comparator)
private java.lang.String java.util.ArrayList.outOfBoundsMsg(int)
private void java.util.ArrayList.rangeCheckForAdd(int)
private boolean java.util.ArrayList.batchRemove(java.util.Collection,boolean)
private void java.util.ArrayList.ensureExplicitCapacity(int)
private void java.util.ArrayList.fastRemove(int)
private void java.util.ArrayList.rangeCheck(int)
static void java.util.ArrayList.subListRangeCheck(int,int,int)
```


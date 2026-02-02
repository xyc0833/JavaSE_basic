# 继续记录

## Map

### 使用Properties
 
Properties用于读取配置
 
* .properties文件只能使用ASCII编码 * 可以从文件系统和ClassPath读取
* 读取多个.properties文件，后读取的Key-Value会覆盖已读取的Key-Value
 
Properties实际上是从Hashtable派生，但只需调用`getProperty`和`setProperty`


### Set
 
Set用于存储不重复的元素集合：
 
* boolean add(E e)
* boolean remove(Object o)
* boolean contains(Object o)
* int size()
 
利用Set可以去除重复元素
 
放入Set的元素要正确实现equals()和hashCode()
 
Set不保证有序：
 
* HashSet是无序的
* TreeSet是有序的
 
实现了SortedSet接口的是有序Set

### Queue
 
队列（Queue）是一种先进先出（FIFO）的数据结构
 
实现类：ArrayDeque，LinkedList
 
操作Queue的元素的方法：
 * 添加至队尾压栈：add() / offer() * 获取队列头部元素并删除：E remove() / E poll()
* 获取队列头部元素但不删除：E element() / E peek()
 
两组方法的区别：是否抛出Exception
 
避免把null添加到队列
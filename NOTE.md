# 继续记录

## Map

### 使用Properties
 
Properties用于读取配置
 
* .properties文件只能使用ASCII编码* 可以从文件系统和ClassPath读取
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
* 添加至队尾压栈：add() / offer()* 获取队列头部元素并删除：E remove() / E poll()
* 获取队列头部元素但不删除：E element() / E peek()
 
两组方法的区别：是否抛出Exception
 
避免把null添加到队列



### PriorityQueue

PriorityQueue的出队顺序与元素的优先级有关：

从队首获取元素时，总是获取优先级最高的元素

默认按元素比较的顺序排序（必须实现Comparable接口）

可以通过Comparator自定义排序算法（不必实现Comparable接口


PriorityQueue<E>具有Queue<E>接口：
• 添加元素到队尾：boolean add (E e) / boolean offer (E e) 
• 获取队列头部元素并删除：E remove () /E poll () 
• 获取队列头部元素但不删除：E element () / E peek () 

默认情况下，优先队列按照元素的自然顺序排序（例如数值或字典顺序），但我们也可以自定义优先级排序规则。

自定义对象的优先级需要实现 

自定义对象的优先级实现 Comparable 接口，来确定队列的优先级


你提供的这个代码片段实现了一个自定义的 `Comparator`，它按照 `Person` 对象的名字 **倒叙排序**。我们可以将这个代码转换为 **Lambda 表达式** 来简化写法。

### 原始代码（匿名内部类写法）

```java
Queue<Person> queue03 = new PriorityQueue<>(new Comparator<Person>() {
    @Override
    public int compare(Person o1, Person o2) {
        // 按照名字的顺序倒叙排序
        return -o1.getName().compareTo(o2.getName());
    }
});
```

### 转换为 Lambda 表达式

Lambda 表达式可以直接用来代替匿名内部类的实现，尤其是当你实现的是 **函数式接口**（如 `Comparator`）时。

```java
Queue<Person> queue03 = new PriorityQueue<>((o1, o2) -> -o1.getName().compareTo(o2.getName()));
```

### 解释

1. **匿名内部类写法**：
   `new Comparator<Person>() { ... }` 是一个匿名类，它实现了 `compare` 方法。在这个方法中，我们使用 `o1.getName().compareTo(o2.getName())` 来比较两个 `Person` 对象的名字，并通过 `-` 实现倒叙排序。

2. **Lambda 表达式写法**：
   `(o1, o2) -> -o1.getName().compareTo(o2.getName())` 这个 Lambda 表达式就是对 `Comparator` 接口的简洁实现：

   * `(o1, o2)` 是两个参数，表示队列中需要比较的两个 `Person` 对象。
   * `->` 后面的部分是实现了 `Comparator` 接口的 `compare` 方法的具体逻辑。
   * `-o1.getName().compareTo(o2.getName())` 完成倒序排序。

### 优点

* **简洁性**：Lambda 表达式减少了冗余的代码，不需要显示声明 `Comparator` 接口的实现类。
* **可读性**：Lambda 表达式用非常简洁的方式表达了排序逻辑，使代码更加紧凑和易于理解。

---

## 总结

* **匿名内部类写法**：

  ```java
  new Comparator<Person>() {
      @Override
      public int compare(Person o1, Person o2) {
          return -o1.getName().compareTo(o2.getName());
      }
  }
  ```

* **Lambda 表达式写法**：

  ```java
  (o1, o2) -> -o1.getName().compareTo(o2.getName())
  ```

**Lambda 表达式**是 Java 8 引入的一个重要特性，它极大地简化了代码，尤其是在处理像 `Comparator` 这样接口时。

---




o1和o2前面为什么不用加person对象

这个问题非常好！让我们深入探讨一下为什么在 Lambda 表达式中的 `o1` 和 `o2` 不需要显式地加上 `Person` 类型。

### 1. **Lambda 表达式的参数类型推断**

在 Lambda 表达式中，参数的类型是 **由上下文推断出来的**。也就是说，你不需要显式地声明参数类型，编译器会根据你传递给 Lambda 表达式的接口类型来推断。

在你的代码中：

```java
Queue<Person> queue03 = new PriorityQueue<>((o1, o2) -> -o1.getName().compareTo(o2.getName()));
```

#### **关键点：**

* `PriorityQueue<>` 是一个泛型类，它接收一个 `Comparator<Person>`，即 **比较 `Person` 对象的大小**。
* 由于 `Comparator` 是 `PriorityQueue` 的构造参数，编译器知道你传入的 `Comparator` 需要比较 `Person` 对象。所以，Lambda 表达式中的 `o1` 和 `o2` 自动被推断为 `Person` 类型。

---

### 2. **编译器如何推断类型**

在 Lambda 表达式 `(o1, o2) -> -o1.getName().compareTo(o2.getName())` 中：

* `o1` 和 `o2` 的类型是由 `Comparator<Person>` 接口的签名决定的。具体来说，`Comparator` 的 `compare` 方法是：

```java
int compare(T o1, T o2);
```

* 由于你使用的是 `PriorityQueue<>(new Comparator<Person>())`，编译器知道 `Comparator` 要比较的是 `Person` 类型。所以，`o1` 和 `o2` 被自动推断为 `Person` 类型。

---

### 3. **为什么不需要显式声明类型？**

Lambda 表达式的参数类型可以由编译器根据上下文自动推断，因此在大多数情况下，你不需要显式声明类型。这是 **Java 8 引入的类型推断**，使得代码更加简洁。

如果我们明确声明类型，代码会变成这样：

```java
Queue<Person> queue03 = new PriorityQueue<>((Person o1, Person o2) -> -o1.getName().compareTo(o2.getName()));
```

不过，Java 编译器能够从 `Comparator<Person>` 自动推断出 `o1` 和 `o2` 的类型，所以你可以省略类型声明，使代码更简洁。

---

### 4. **回顾泛型的类型推断**

这就像是你在使用泛型时，不需要每次都写出具体类型：

```java
List<String> list = new ArrayList<>();
```

Java 编译器会自动推断出 `ArrayList` 的泛型类型为 `String`，所以你不需要显式地写：

```java
List<String> list = new ArrayList<String>();
```

---

## 总结

* **Lambda 表达式中的参数类型**：编译器根据上下文自动推断，无需显式声明类型。
* **`o1` 和 `o2` 的类型**：由 `Comparator<Person>` 自动推断为 `Person` 类型。
* **简洁性**：省略类型使代码更简洁，但如果需要，可以显式声明类型。

---

### Deque
 
Deque实现一个双端队列（Double Ended Queue）：
 
* 既可以添加到队尾，也可以添加到队首
* 既可以从队首获取，又可以从队尾获取
 
* 添加元素到队尾：addLast(E e) / offerLast(E e)
* 取队首元素并删除：E removeFirst() / E pollFirst()
* 取队首元素但不删除：E getFirst() / E peekFirst()
 
总是调用xxxFirst / xxxLast以便与Queue的方法区分开

| 操作类型                  | Queue                           | Deque                           |
|------------------------|--------------------------------|--------------------------------|
| 添加元素到队尾            | add(E e) / offer(E e)          | addLast(E e) / offerLast(E e)  |
| 取队首元素并删除          | E remove() / E poll()          | E removeFirst() / E pollFirst()|
| 取队首元素但不删除        | E element() / E peek()         | E getFirst() / E peekFirst()   |


### Stack
 
栈（Stack）是一种后进先出（LIFO）的数据结构
 
操作栈的元素的方法：
* push(E e)：压栈* pop()：出栈* peek()：取栈顶元素但不出栈
 
Java使用Deque实现栈的功能，注意只调用push/pop/peek，避免调用Deque的其他方法
 
不要使用遗留类Stack



peek() 方法是 Stack 类中的一个常用方法，它的作用是 查看栈顶的元素，但 不移除 该元素。


### Iterator 迭代
 
for...each循环是编译器实现的Iterator模式
 
适用于for...each循环的类：
 
* 实现Iterable接口
* 返回Iterator实例
 
好处：
 
* 对任何集合都采用同一种访问模型
* 调用者对集合内部结构一无所知
* 集合类返回的Iterator对象知道如何迭代
* Iterator是一种抽象的数据访问模型

### Collections
 
Collections是JDK提供的集合工具类
 
创建空集合：emptyList / emptySet / emptyMap
 
创建单元素集合：singleton / singletonList / singletonMap
 
对List排序：sort
 
洗牌：suffle
 
创建不可变集合：unmodifiableList / unmodifiableSet / unmodifiableMap
 
创建线程安全的集合：synchronizedList / synchronizedSet / synchronizedMap（已不推荐使用）






# JavaSE_Basic - Java 基础学习项目  
**（日本語 / English / 中文）**  

---

## 日本語  
### プロジェクト概要  
このプロジェクトは、Java 標準エディション（JavaSE）の基礎知識を学ぶためのサンプルコード集です。  

### 学習内容  
- 変数とデータ型  
- 制御構文（`if`/`for`/`while`）  
- メソッドとクラス  
- オブジェクト指向プログラミング（継承、多態性）  
- 例外処理  
- コレクションフレームワーク（`List`/`Set`/`Map`）  

## 问题记录

[git无法连接的问题](https://blog.csdn.net/zdl177/article/details/119514646?spm=1001.2101.3001.6650.3&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7ERate-3-119514646-blog-84947403.235%5Ev43%5Epc_blog_bottom_relevance_base7&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7ERate-3-119514646-blog-84947403.235%5Ev43%5Epc_blog_bottom_relevance_base7&utm_relevant_index=5)


![调试报错提示](img-1.png)

这是调试器的一个警告提示，不是程序本身的报错。简单解释如下：

这个弹窗在说什么？

标题： Obsolete Methods on the Stack（调用栈中存在“过期方法”）

核心意思：

当前程序的调用栈里，还存在旧版本代码的方法
虚拟机（JVM）无法把这些旧方法从调用栈中移除
如果你继续单步调试，可能会有风险

## switch

switch语句可以做多重选择
switch的计算结果必须是整型、字符串或枚举类型
注意千万不要漏写break, 建议打开fall-through警告
总是写上default, 建议打开missing default警告
尽量少用switch语句

## for

for循环通过计数器进行循环
for循环可以遍历数组
最佳实践：计数器变量定义在for循环内部, 循环体内部不修改计数器
for each循环可以更简单地遍历数组

### break continue

![break](img-2.png)

break语句可以跳出当前循环
break语句通常配合if, 在满足条件时提前结束循环
break语句总是跳出最近的一层循环
continue语句可以提前结束本轮循环
continue语句通常配合if, 在满足条件时提前结束本轮循环

## 数组

	Arrays.toString(ns);
	该方法可以快速打印数组

- 遍历数组可以使用for循环
- for (；) 循环可以访问数组索引
- for each循环直接迭代每个数组元素, 无法直接访问索引
- Arrays.toString () 用于快速打印数组内容

	deeptostring 方法
	把“嵌套对象 / 多维数组”的内容，递归地转换成字符串
	
- 多维数组是数组的数组
- 多维数组的每个数组元素长度不要求相同
- 打印多维数组可以使用Arrays.deepToString () 
- 最常见的多维数组是二维数组
- 访问二维数组的一个元素使用array［row］［col］

### 命令行参数

public static void main(String[] args）
中的String[] args
	命令行参数是一个String［］数组
	•由JVM接收用户输入并传给main
	
java Arr_xyc -version -s -t "hello xyc"

```shell
MacBook-Air:bin xuyaochen$ java Arr_xyc -version -s -t "hello xyc"
[I@15db9742
[1, 1, 2, 3, 5, 8]
[28, 12, 89, 73, 65, 18, 96, 50, 8, 36]
[96, 89, 73, 65, 50, 36, 28, 18, 12, 8]
[8, 12, 18, 28, 36, 50, 65, 73, 89, 96]
5
[[I@6d06d69c, [I@7852e922, [I@4e25154f, [I@70dea4e, [I@5c647e05]
[[68, 79, 95, 81], [91, 89, 53, 72], [77, 90, 87, 83], [92, 98, 89, 85], [94, 75, 73, 80]]
Average score: 80
Average score: 76
Average score: 84
Average score: 91
Average score: 80
Average Chinese: 84
Average Math: 86
Average English: 79
Average Physical: 80
Number of args: 4
-version
-s
-t
hello xyc
MacBook-Air:bin xuyaochen$ 
```

- 命令行参数是String［］
- 命令行参数由JVM接收用户输入并传给main方法
- 如何解析命令行参数由程序自己实现

## OOP

面向对象编程：Object-Oriented Programming
对现实世界建立计算机模型的一种编程方法

问题：
No enclosing instance of type OOP_xyc is accessible.
Must qualify the allocation with an enclosing instance of type OOP_xyc 
(e.g. x.new A() where x is an instance of OOP_xy 

你正在 new 一个“非静态内部类”，
但你没有提供它所属的外部类 OOP_xyc 的对象。

class和instance是“模版"和“实例”的关系
class是数据类型, instance是数据
class定义了field, 
每个instance都会拥有各自的field
变量指向instance, ；
并通过变量.字段名访问field
指向instance的变量都是引用变量

## 方法

方法可以让外部代码安全地访问实例字段
方法是一组执行语句
方法内部遇到return时返回
void表示不返回任何值 (注意和返回null不同) 
外部代码通过public方法操作实例
内部代码可以调用private方法

## 方法重载

方法重载 (Overload) 是指：
• **多个方法的方法名相同**
• 但各自的参数不同：
•参数个数不同
• 参数类型不同
• 参数位置不同
• 方法返回值类型通常都是相同的

 string 中 indexOf() 方法
 在字符串中查找某个字符或子串，返回“第一次出现的位置”
```java
 String s = "hello";
int idx = s.indexOf('e');
System.out.println(idx);
 
 String s = "hello world";
int idx = s.indexOf("world");
System.out.println(idx);
 
 String s = "banana";
int idx = s.indexOf("a", 2);
System.out.println(idx);
```

## 继承

• Student可以从Person继承
• 继承使用关键字extends
• Student获得了Person的所有功能
• Student只需要编写新增的功能
 
 
• Person类定义的private字段无法被子类访问
- 用protected修饰的字段可以被子类访问
- protected把字段和方法的访问权限控制在继承树内部

### super

- super关键字表示父类 (超类) 
- 构造方法的第一行语句必须调用super () 
- 没有super () 时编译器会自动生成super () 
- 如果父类没有默认构造方法, 子类就必须显式调用super () 

### 向上转型

![向上转型](img-3.png)

把子类安全的转为更加抽象的类型

### 向下转型

可以对实例变量进行向下转型 (downcasting) 
向下转型把抽象的类型变成一个具体的子类型
向下转型很可能报错：ClassCastException


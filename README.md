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

总结

继承是面向对象编程的一种代码复用方式
Java只允许单继承
protected允许子类访问父类的字段和方法
子类的构造方法可以通过 super () 调用父类的构造方法
可以安全地向上转型为更抽象的类型
可以强制向下转型, 最好借助 instanceof 判断
子类和父类的关系是is, has关系不能用继承

## 多态

- Java的实例方法调用是基于运行时实际类型的动态调用
- 多态是指针对某个类型的方法调用, 其真正执行的方法取决于运行时期实际类型的方法
- 对某个类型调用某个方法, 执行的方法可能是某个子类的覆写方法
- 利用多态, 允许添加更多类型的子类实现功能扩展


super 可以调用父类的方法

```java
	public String hello() {
		return super.hello()+"我是学生";
	}
```

### final方法

final与访问权限不冲突
用final修饰class可以阻止被继承
用final修饰method可以阻止被覆写

被 final 修饰的方法，不能被子类重写（override）
二、为什么要用 final 方法？


主要有 3 个目的：
1️⃣ 防止子类“乱改”核心逻辑
class Parent {
    public final void rule() {
        System.out.println("核心规则");
    }
}
class Child extends Parent {
    // ❌ 编译错误，不能重写
    public void rule() {}
}
👉 保证行为不被破坏
2️⃣ 设计上“不希望被扩展”
工具方法
安全相关逻辑
模板方法中的关键步骤 


子类可以覆写父类的方法 (Override) 
覆写在子类中改变了父类方法的行为
多态：Java的方法调用总是作用于对象的实际类型
final修饰的方法可以阻止被覆写
final修饰的class可以阻止被继承
final修饰的field必须在创建对象时初始化


## 抽象类

**抽象方法**是 Java OOP 里一个**非常核心、但一开始容易“抽象过头”**的概念。

---
## 一、一句话理解抽象方法

> **抽象方法：只规定“要做什么”，不规定“怎么做”**

---

## 二、什么是抽象方法？

### 定义特点

```java
public abstract void pay();
```

* 有方法声明
* **没有方法体**
* 用 `abstract` 修饰

---

### 抽象方法所在位置

👉 **只能在抽象类中**

```java
public abstract class Payment {
    public abstract void pay();
}
```

---

## 三、基本规则（必考）

### ✅ 必须遵守的规则

1️⃣ 含有抽象方法的类 **必须是抽象类**

2️⃣ 子类 **必须实现所有抽象方法**
（除非子类本身也是抽象类）

```java
class AliPay extends Payment {
    @Override
    public void pay() {
        System.out.println("支付宝支付");
    }
}
```

---

### ❌ 不允许的

```java
abstract class A {
    public abstract void test() {} // ❌ 抽象方法不能有方法体
}
```

```java
abstract final class A {} // ❌ 抽象类不能是 final
```

---

## 四、抽象方法在实际业务中的应用（重点）
### 🌰 业务场景：支付系统（非常经典）

#### 1️⃣ 抽象父类（定义规范）

```java
public abstract class Payment {

    // 抽象方法：每种支付方式必须实现
    public abstract void pay(int amount);

    // 公共逻辑
    public void log() {
        System.out.println("记录支付日志");
    }
}
```

---

#### 2️⃣ 子类实现不同业务

```java
class AliPay extends Payment {
    @Override
    public void pay(int amount) {
        System.out.println("支付宝支付：" + amount);
    }
}
```

```java
class WeChatPay extends Payment {
    @Override
    public void pay(int amount) {
        System.out.println("微信支付：" + amount);
    }
}
```

---

#### 3️⃣ 业务方调用（解耦关键）

```java
public void doPay(Payment payment) {
    payment.pay(100);
}
```

👉 **业务层不关心具体实现**

---

## 五、为什么业务中一定要用抽象方法？

### 1️⃣ 解耦（最重要）

* 新增支付方式
* 不改原代码
* 只加新子类

👉 **符合开闭原则**

---

### 2️⃣ 强制规范

> “你要接入支付？那你必须实现 `pay()`”

---

### 3️⃣ 更利于维护 & 扩展

* 删除 if-else
* 少改老代码
* 风险更低

---

## 六、抽象方法 vs 接口（简单对比）

| 对比点  | 抽象方法    | 接口                 |
| ---- | ------- | ------------------ |
| 所在位置 | 抽象类     | 接口                 |
| 成员变量 | 可以有普通字段 | 只能是常量              |
| 方法实现 | 可以有普通方法 | Java 8+ 可有 default |
| 适用场景 | 有共性实现   | 只定义能力              |

---

## 七、一个生活类比（超好记）

> **抽象方法 = 菜谱
> 具体类 = 厨师**

菜谱告诉你做什么菜，不教你具体怎么炒。

---

## 八、一句话总结（面试用）

> **抽象方法定义规范，子类实现细节，用于业务解耦和扩展**


## 接口

如果一个抽象类没有字段, 所有方法全部是抽象方法,
就可以把该抽象类改写为接口 (interface) 

使用interface声明一个接口

| 对比项 | abstract class | interface |
|------|---------------|-----------|
| 继承 | 只能 extends 一个 class | 可以 implements 多个 interface |
| 字段 | 可以定义实例字段 | 不能定义实例字段 |
| 抽象方法 | 可以定义抽象方法 | 可以定义抽象方法 |
| 非抽象方法 | 可以定义非抽象方法 | 可以定义 default 方法 |


• 接口定义了纯抽象规范
• 类可以实现多个接口
• 接口也是数据类型, 适用于向上转型和向下转型
• 接口不能定义实例字段
• 接口可以定义default方法 (JDK>=1.8) 

## 静态字段 static

所有实例共享一个静态字段
不推荐用实例变量访问静态字段
推荐用类名访问静态字段
可以把静态字段理解为描述class
本身的字段 (非实例字段) 

静态方法经常用于工具类
• Arrays.sort () 
• Math.random () 
静态方法经常用于辅助方法
Java程序的入口main () 也是静态方法

## 包 package

JVM只看完整类名, 因此, 只要包名不同, 类就不同：
• xiaoming.Person
• xiaohong.Person
包可以是多层结构
• java.util.Arrays
包没有父子关系

Java内建的package机制是为了避免class命名冲突
JDK的核心类使用java.lang包
JDK的其它常用类定义在java.util.*, 
, Java.math.*
, java.text.* …..
包名推荐使用倒置的域名, 例如 org.apache


## 访问权限

1️⃣ private（私有）
作用范围：仅在当前类中可访问

3️⃣ protected（受保护）
作用范围：同包 + 不同包的子类

4️⃣ public（公共）
作用范围：任何地方都可访问

package 访问权限（Package-Private） 指的是：
> 只允许同一个 package（包）中的类访问

## classpath 

• classpath是一个环境变量
•classpath指示JVM如何搜索class
•classpath设置的搜索路径与操作系统相关：
• C:worklproject1\bin;C:Ishared；"D：\My Documentlproject2\bin"
• /usr/shared:/usr/local/bin:/home/feiyangedu/bin

• 假设classpath是.；C：：\worklproject1\bin;C：|shared
• JVM在加载com.feiyangedu.Hello这个类时, 依次查找：
• ＜当前目录>lcomlfeiyangedu\Hello.class
• C:lworklproject1\binlcomlfeiyangedu\Hello.class
• C:sharedlcomlfeiyangedu\Hello.class
• 在某个路径下找到了, 就不再继续搜索
•如果都没有找到, 报错

classpath的设定方法：
• 直接在系统环境中设置classpath环境变量 (不推荐) 
• 在启动JVM时设置classpath变量 (推荐) ：
• java -classpath C:lworklbin;C:Ishared com.feiyangedu.Hello
• java -cp C: worklbin;C:shared com.feiyangedu.Hello
•没有设置环境变量, 也没有设置-Cp参数, 默认的classpath为•, 即当前目录
• 在Eclipse中运行Java程序, 
Eclipse自动传入的-cp参数是当前工程的bin目录和引入的jar

## jar包

jar包是zip格式的压缩文件, 包含若干.class文件
jar包相当于目录
classpath可以包含jar文件：C:lworklbinlall.jar
查找com.feiyangedu.Hello类将在C:Wworklbinlall.jar文件中搜索
com/feiyangedu/Hello.class
使用jar包可以避免大量的目录和.class文件

如何创建jar包：
• 使用JDK自带的jar命令
• 使用构建工具如Maven等

• jar包可以包含一个特殊的/META-INF/MANIFEST.MF文件
• MANIFEST.MF是纯文本, 可以指定Main-Class和其它信息
•jar包还可以包含其它jar包

• JVM运行时会自动加载JDK自带的class
• JDK自带的class被打包在rt.jar
• 不需要在classpath中引用rt,jar


**可以先压缩成zip文件 然后 重命名为 .jar**

find . -name testxyc.jar

```shell
MacBook-Air:src xuyaochen$ java -cp testxyc.jar com.xyc.Abstract_xyc
180.0
36.31681107549801
Hello, World!
MacBook-Air:src xuyaochen$ 
```

-cp（或 -classpath）

📌 作用：
告诉 JVM：到哪里去找要运行的 class
也就是把 testxyc.jar 加入 类加载路径（Classpath）

打jar包是遇到的问题 

正确的 jar 结构应该长这样
META-INF/
└── MANIFEST.MF
com/
└── xyc/
    ├── Abstract_xyc.class
    ├── Circle.class
    ├── Hello.class
    ├── Rect.class
    ├── Shape.class
    └── ShapeUtil.class
    
    
运行一定要是 .class文件 而不是 .java文件

要在bin目录下 用class打jar包

MacBook-Air:src xuyaochen$ java -jar testmani.jar 
180.0
36.31681107549801
Hello, World!
MacBook-Air:src xuyaochen$ 

## MANIFEST

一、MANIFEST 文件是什么？
MANIFEST.MF 是 JAR 包的元数据说明文件。
固定位置：
META-INF/MANIFEST.MF

本质：纯文本文件
JVM / 工具通过它了解：
这个 jar 是干嘛的
从哪开始执行
依赖和版本信息
📌 可以把它理解为：
jar 包的“说明书 / 入口配置文件”

• JVM通过环境变量classpath决定搜索class的路径和顺序
• 不推荐设置系统环境变量classpath, 始终建议通过-cp命令传入
• jar包相当于目录, 可以包含很多class文件, 方便下载和使用
• META-INF/MANIFEST.MF可以提供jar包的信息, 如Main-Class
• 不需要在classpath中引用包含Java核心类的rt.jar




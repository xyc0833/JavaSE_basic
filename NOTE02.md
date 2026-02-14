java 数据安全
### 数据安全
 
* 防窃听
* 防篡改
* 防伪造
 
现代计算机加密是建立在严格的数学理论基础上的。

### URL编码
 
URL编码是编码算法，不是加密算法
 
URL编码的目的是把任意文本数据编码为%前缀表示的文本

URL编码是浏览器发送数据给服务器时使用的编码：
• keyl=value1&key2=value2&key3=value3
• 9=%E4%B8%AD%E6%96%87

URL编码规则：
•A~Z, a-Z, 0-9以及一
.*保持不变
•其它字符以%XX表示：
•<：%3C
• 中：%E4%B8%AD (UTF-8: 0xe4b8ad) 

URL编码是编码算法, 不是加密算法
URL编码的目的是把任意文本数据编码为%前缀表示的文本, 
编码后的文本仅包含A~Z, a~Z, 0~9, -_*, %, 
便于浏览器和服务器处理

### Base64编码
 
Base64是编码算法，不是加密算法
 
Base64编码的目的是把任意二进制数据编码为文本（长度增加1/3）
 
其它编码：Base32，Base48，Base58

什么是Base64：
• 一种把二进制数据用文本表示的编码算法
• String base64Encode (bytel］ data) 
• bytel [] {Oxe4, 0xb8, Oxad} -> "5Lit"

![alt text](image-12.png)

目的：
•一种用文本 (A-Z, a-Z, 0-9, +/=) 表示二进制内容的方式
•适用于文本协议
•效率下降
应用：
•电子邮件协议

### 摘要算法
 
摘要算法 / 哈希算法 / 数字指纹 / Hash / Digest
 
计算任意长度数据的摘要，输出固定长度
 
相同的输入始终得到相同的输出
 
不同的输入尽量得到不同的输出
 
### 碰撞
 
两个不同的输入得到了相同的输出
 
### Hash算法的安全性：
 
* 碰撞率低
* 不能猜测输出
* 输入的任意一个bit的变化会造成输出完全不同
* 很难从输出反推输入（只能依靠暴力穷举）
 
### MD5摘要算法
 
* 验证原始数据是否被篡改
 
* 存储用户口令
 
* 需要防止彩虹表攻击

摘要算法 (哈希算法 / Hash / Digest / 数字指纹) ：
•计算任意长度数据的摘要 (固定长度) 
• 相同的输入数据始终得到相同的输出
• 不同的输入数据尽量得到不同的输出
目的：
• **验证原始数据是否被篡改**

Java的Object.hashCode () 方法就是一个摘要算法：
• 输入：任意数据
•输出：固定长度数据 (int, byte［4］) 
• 相同的输入得到相同的输出：
equals / hashCode

碰撞：
**两个不同的输入得到了相同的输出**
hash ("abc") =0×12345678
hash ("xyz") = 0x12345678

Hash算法的安全性：
• 碰撞率低
•不能猜测输出
• 输入的任意一个bit的变化会造成输出完全不同
• 很难从输出反推输入 (只能依靠暴力穷举) 

![alt text](image-13.png)

MD5的用途：
• **验证文件完整性**

MD5存储用户口令
• 系统不存储用户原始口令
• 系统存储用户原始口令的MD5
如何判断用户口令是否正确：
• 系统计算用户输入的原始口令的MD5并与数据库存储的MD5对比
•相同：口令正确
•不相同：口令错误

salt值的由来：
https://www.bilibili.com/video/BV134411T7rq?spm_id_from=333.788.player.switch&vd_source=4fd29620ab97a080af7ee392e19b0fcb&p=4

黑客有一个彩虹表（常用密码和对应的md5值）

如果加入一个随机数（也就是盐值）在生成md5值 就不容易被攻击

• MD5是一种常用的哈希算法
输出128 bits / 16 oytes
• 常用于验证数据完整性
• 用于存储口令时要考虑彩虹表攻击

### SHA1
 
SHA-1摘要算法：输出160bits，20bytes
 
其它摘要算法：
 
* SHA-256
* SHA-512
* RipeMD160
 
查询JDK摘要算法名称：
 
http://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#MessageDigest

![alt text](image-14.png)


SHA-1算法是比MD5更安全的哈希算法
其它哈希算法：
SHA-256 / SHA-512/ RipeMD-160


### Bouncy Castle
 
Bouncy Castles是第三方算法提供商
 
提供JDK没有提供的算法：例如：RipeMD160哈希算法
 
使用第三方算法前需要通过Security.addProvider()注册


### Hmac
 
Hmac：Hash-based Message Authentication Code
 
基于密钥的消息认证码算法
 
HmacMD5 ≈ md5(secure_random_key, data)
 
Hmac是把Key混入摘要的算法
 
可以配合MD5、SHA-1等摘要算法
 
摘要长度和原摘要算法长度相同

### 对称加密算法
 
使用同一个密钥进行加密和解密

![alt text](image-15.png)

常用的对称加密算法：
![alt text](image-16.png)
 
常用算法：DES／AES／IDEA等
 
密钥长度由算法设计决定，AES的密钥长度是128／192／256
 
使用256位加密需要修改JDK的policy文件
 
使用对称加密算法需要指定：算法名称／工作模式(ECB, CBC, PCBC...)／填充模式(NoPadding, PKCS5Padding, PKCS7Padding...)

### PBE算法
 
PBE：Password Based Encryption
 
由用户输入口令，采用随机数杂凑计算出密钥再进行加密
 
Key通过口令和随机salt计算得出，提高了安全性
 
PBE算法内部使用的仍然是标准对称加密算法（例如AES）

常用于压缩包的加密？

•如果把随机salt存储在U盘, 就得到了一个“口令"+USB Key加密软件

好处：
•即使用户使用非常弱的口令, 没有USB Key仍然无法解密


### eclipse 外部导入 jar包


# 🚀 方法：推荐项目规范做法（更专业）

适合长期项目，而不是临时测试。

### ① 在项目里建文件夹

```
项目名/
 └── lib/
```

把 jar 拖进去

---

### ② 右键这个 jar 文件 → 选：

```
Build Path → Add to Build Path
```

✔ jar 路径变成相对路径
✔ 项目发给别人不会丢依赖
✔ Git 提交也方便

---

# ❗ 常见错误

| 问题                       | 原因                            |
| ------------------------ | ----------------------------- |
| `ClassNotFoundException` | jar 没加到 Build Path            |
| 代码能编译但运行报错               | 加到了 Module Path 而不是 Classpath |
| 红叉还在                     | 需要 **Project → Clean**        |

---

### 密钥交换算法
Diffie-Hellman算法
 
DH算法是一种密钥交换协议，通信双方通过不安全的信道协商密钥，然后进行对称加密传输
 
DH算法没有解决中间人攻击

如何在不安全的信道上安全地传输密钥？
•密钥交换算法
Diffie-Hellman算法
DH算法

DH算法是一种密钥交换协议, 通信双方通过不安全的信道协商密钥, 
然后进行对称加密传输
DH算法没有解决中间人攻击

### 非对称加密算法
 
RSA（Ron Rivest，Adi Shamir，Leonard Adleman）
 
非对称加密就是加密和解密使用的不是相同的密钥
 
只有同一个公钥／私钥对才能正常加密／解密
 
公钥公开，私钥保密
 
只使用非对称加密算法不能防止中间人攻击

非对称加密就是加密和解密使用的不是相同的密钥：
加密：用自己的私钥加密, 然后发送给对方
encrypt (privateKeyA, message) -> encrypted
解密：对方用自己的公钥解密
decrypt (publicKeyA, encrypted) -> message

非对称加密就是加密和解密使用的不是相同的密钥：
加密：用对方的公钥加密, 然后发送给对方
encrypt (publicKeyB, message) -> encrypted
解密：对方用自己的私钥解密
decrypt (privateKeyB, encrypted) -> message

非对称加密的优点：
•对称加密需要协商密钥, 而非对称加密可以安全地公开各自的公钥
• N个人之间通信：
**使用非对称加密只需要N个密钥对每个人只管理自己的密钥对**

**使用对称加密需要N* (N-1) /2个密钥每个人需要管理N-1个密钥**


### 数字签名
 
用发送方的私钥对原始数据进行签名
 
只有用发送方公钥才能通过签名验证
 
防止伪造发送方
 
防止抵赖发送过信息
 
防止信息在传输过程中被修改
 
常用算法：MD5withRSA／SHA1withRSA／SHA256withRSA

数字签名就是发送方用自己的私钥对消息进行签名：
sig = signature (privateKey, "message") 
接收方用发送方的公钥验证签名是否有效：
bodlean valid = verity (publicKey. sig, "message") 
数字签名~混入了私钥/公钥的摘要

常用数字签名算法：
MD5withRSA
SHA1withRSA
SHA256withRSA

### DSA签名算法
 
DSA：Digital Signature Algorithm
 
使用ElGamal数字签名算法
 
算法包括：
 
* SHA1withDSA
 
* SHA256withDSA
 
* SHA512withDSA
 
其它数字签名算法：
 
ECDSA：Elliptic Curve Digital Signature Algorithm (Bouncy Castle)


### 数字证书
 
数字证书就是集合了多种密码学算法，用于实现数据加解密、身份认证、签名等多种功能的一种网络安全标准。
 
数字证书采用链式签名管理，顶级CA证书已内置在操作系统中。
 
常用算法：MD5／SHA1／SHA256／RSA／DSA／...
 
应用：https等

数字证书：
• 非对称加密算法：对数据进行加密/解密
• 签名算法：确保数据完整性和抗否认性
• 摘要算法：确保证书本身没有被篡改


数字证书的应用：
• https:HTTP over SSL
• 服务器发送证书给客户端 (发送公钥 /签名/ CA) 
•客户端验证服务器证书 (确认服务器身份) 
• 客户端用证书加密随机口令并发送给服务器端 (公钥加密) 
• 服务器端解密获得口令 (私钥解密) 
• 双方随后使用AES加密进行通信 (对称加密) 

### Java多线程
 
进程和线程的概念
 
进程和线程的区别
 
Java语言内置多线程支持
 
多线程编程的特点：
 
* 多线程需要读写共享数据
* 多线程经常需要同步
* 多线程编程的复杂度高，调试更困难

### 创建新线程
 
1. 从Thread派生
2. 实现Runnable接口
 
必须调用`start()`方法才能启动新线程
 
`Thread.sleep()`可以把当前线程暂停一段时间

![alt text](image-17.png)

### 线程的状态

 
一个线程对象只能调用一次start()
 
Java线程对象Thread的状态包括：
New / Runnable / Blocked / Waiting / Timed Waiting / Terminated
 
通过对另一个线程对象调用join()方法可以等待其执行结束
 
可以指定等待时间，超过等待时间线程仍然没有结束就不再等待
 
对已经运行结束的线程调用join()方法会立刻返回


### 中断线程
 
调用interrupt()方法可以中断一个线程
 
通过检测isInterrupted()标志获取当前线程是否已中断
 
如果线程处于等待状态，该线程会捕获InterruptedException
 
isInterrupted()为true或者捕获了InterruptedException都应该立刻结束
 
通过标志位判断需要正确使用volatile关键字
 
volatile关键字解决了共享变量在线程间的可见性问题

## 简单介绍一下volatile

可以的，这个点**对并发初学者超级关键**，而且很多人一开始都会误解 👍
我用**“标志位控制线程停止”**这个经典场景给你讲透。

---

## 🎯 场景：用“标志位”让线程停下来

我们想让一个线程一直工作，直到主线程通知它停止。

### ❌ 不加 `volatile` 的写法

```java
class Worker extends Thread {
    private boolean running = true;  // 标志位

    public void run() {
        while (running) {
            // 一直干活
        }
        System.out.println("线程结束");
    }

    public void stopWork() {
        running = false;   // 主线程修改标志位
    }
}
```

主线程：

```java
Worker w = new Worker();
w.start();

Thread.sleep(1000);
w.stopWork();   // 想让线程停下来
```

### 🤔 结果可能是什么？

**线程可能永远停不下来。**

---

## 🧠 为什么会这样？（可见性问题）

Java 内存模型里每个线程都有：

```
主内存（共享）
   ↑      ↓
线程工作内存（线程私有缓存）
```

执行流程可能是：

1. 线程启动时，把 `running = true` 从主内存拷贝到自己的**工作内存**
2. `while(running)` 每次循环都只读**自己缓存里的 running**
3. 主线程把 `running = false` 写到**主内存**
4. 但是工作线程 **根本没去读主内存！**

👉 所以它看到的永远是 `true`

这就是：

> **共享变量在线程之间不可见**

---

## ✅ 正确做法：使用 `volatile`

```java
class Worker extends Thread {
    private volatile boolean running = true;  // 加 volatile！

    public void run() {
        while (running) {
            // 干活
        }
        System.out.println("线程结束");
    }

    public void stopWork() {
        running = false;
    }
}
```

---

## 🚀 `volatile` 到底做了什么？

当变量被 `volatile` 修饰后，JVM 做了两件关键的事：

### ① 保证可见性

**线程每次读这个变量，都必须去主内存读！**

```
不加 volatile:
线程A 改了 → 线程B 看不见 ❌

加 volatile:
线程A 改了 → 线程B 立刻能看见 ✅
```

---

### ② 禁止指令重排序（进阶但很重要）

JVM 和 CPU 会优化代码顺序，比如：

```java
running = true;
init();
```

可能变成：

```java
init();
running = true;
```

在多线程下会出大问题。
`volatile` 会在读写时插入**内存屏障**，阻止这种乱序影响结果。

---

## ⚠️ 但 volatile **不能**解决所有并发问题！

很多初学者以为：

> “用了 volatile 就线程安全了”

❌ 错！

看这个例子：

```java
volatile int count = 0;

public void inc() {
    count++;   // 不是原子操作！
}
```

`count++` 实际是：

```
1. 读 count
2. +1
3. 写回
```

多个线程可能同时执行，结果还是错。

👉 这种情况要用：

* `synchronized`
* `Lock`
* `AtomicInteger`

---

## 🧩 总结（记住这三点就够了）

| 问题                | volatile 能解决吗 |
| ----------------- | ------------- |
| 线程之间看不到变量修改       | ✅ 能           |
| 标志位控制线程停止         | ✅ 非常适合        |
| 复合操作（count++）线程安全 | ❌ 不能          |
| 替代 synchronized   | ❌ 不行          |

---

## 🪄 一句话理解

> **volatile = “这个变量是公共广播栏，谁改了所有线程马上能看到”**
> 但它**不负责排队**，只负责“消息同步”。

---

### 守护线程
 
守护线程是为其他线程服务的线程
 
所有非守护线程都执行完毕后，虚拟机退出
 
守护线程不能持有资源（如打开文件等）
 
创建守护线程：
 
```
setDaemon(true)
```

### 线程同步
 
多线程同时修改变量，会造成逻辑错误
 
需要通过synchronized同步
 
同步的本质就是给指定对象加锁
 
注意加锁对象必须是同一个实例
 
对JVM定义的单个原子操作不需要同步

### synchronized方法
 
用synchronized修饰方法可以把整个方法变为同步代码块
 
synchronized方法加锁对象是this
 
通过合理的设计和数据封装可以让一个类变为“线程安全”
 
一个类没有特殊说明，默认不是thread-safe
 
多线程能否访问某个非线程安全的实例，需要具体问题具体分析


### 死锁
 
死锁产生的条件：
 
多线程各自持有不同的锁，并互相试图获取对方已持有的锁，双方无限等待下去：导致死锁
 
如何避免死锁：
 
多线程获取锁的顺序要一致

### wait / notify
 
wait / notify用于多线程协调运行：
 
在synchronized内部可以调用wait()使线程进入等待状态
 
必须在已获得的锁对象上调用wait()方法
 
在synchronized内部可以调用notify / notifyAll()唤醒其他等待线程
 
必须在已获得的锁对象上调用notify / notifyAll()方法

### threadlocal

调用Thread.currentThread()获取当前线程。
 
JDK提供了ThreadLocal，在一个线程中传递同一个对象。
 
ThreadLocal表示线程的“局部变量”，它确保每个线程的ThreadLocal变量都是各自独立的。
 
ThreadLocal适合在一个线程的处理流程中保持上下文（避免了同一参数在所有方法中传递）
 
使用ThreadLocal要用try … finally结构。

ThreadLocal的使用
既然每个线程都有一个自己的工作内存，那么能否只在自己的工作内存中创建变量仅供线程自己使用呢？

我们可以使用ThreadLocal类，来创建工作内存中的变量，它将我们的变量值存储在内部（只能存储一个变量），不同的线程访问到ThreadLocal对象时，都只能获取到当前线程所属的变量。

我们发现在线程中创建的子线程，无法获得父线程工作内存中的变量：
我们可以使用InheritableThreadLocal来解决
```java
public static void main(String[] args) {
    ThreadLocal<String> local = new InheritableThreadLocal<>();
    Thread t = new Thread(() -> {
       local.set("lbwnb");
        new Thread(() -> {
            System.out.println(local.get());
        }).start();
    });
    t.start();
}
```
在InheritableThreadLocal存放的内容，会自动向子线程传递。

## 处理线程的定时任务
```java
Timer timer = new Timer();//创建一个定时器对象
//注意这个是一个抽象类，不是接口，无法使用lambda表达式简化，只能使用匿名内部类
timer.schedule(new TimerTask() {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());    //打印当前线程名称
        System.out.println("123123");
        timer.cancel();//一定要在这里 cancel
    }//执行一个延时任务
}, 1000,10);//延迟一秒
```

## 守护线程

注意： 不要把操作系统中的守护进程和守护线程相提并论。

操作系统中的守护进程在后台运行，不需要和用户交互，本质和普通进程类似。
而守护线程就不一样了，当其他所有的非守护线程结束之后，守护线程自动结束，
也就是说，Java中所有的线程都执行完毕后，守护线程自动停止，
因此守护线程不适合进行IO操作，只适合打打杂

## (Java 8) 并行流

集合类中有一个东西是Java8新增的Spliterator接口，翻译过来就是：可拆分迭代器（Splitable Iterator）和Iterator一样，Spliterator也用于遍历数据源中的元素，但它是为了并行执行而设计的。Java 8已经为集合框架中包含的所有数据结构提供了一个默认的Spliterator实现。在集合跟接口Collection中提供了一个spliterator()方法用于获取可拆分迭代器。


并行流，其实就是一个多线程执行的流，它通过默认的ForkJoinPool实现（这里不讲解原理），它可以提高你的多线程任务的速度。

 这个方法挺有意思，算是 **函数式 + 并行计算** 的结合 👇

## 🧩 `Arrays.parallelSetAll` 是干嘛的？

一句话：
**用你提供的“生成规则”，并行地给数组每个位置赋值。**

它在 `java.util.Arrays` 里，从 **Java 8** 开始有。

---

## 📌 方法长这样

以 `int[]` 为例：

```java
static void parallelSetAll(int[] array, IntUnaryOperator generator)
```

其他类型也有（long、double、泛型 T[]）。

---

## 🔧 参数啥意思？

| 参数          | 说明                           |
| ----------- | ---------------------------- |
| `array`     | 你要填充的数组                      |
| `generator` | 一个函数：**输入是索引 i，返回这个位置该放什么值** |

也就是：

> **数组[i] = generator.applyAsInt(i)**
> 只不过是 **多线程并行执行的**

---

## 🧠 它和 `setAll` 区别？

| 方法                        | 是否并行                  |
| ------------------------- | --------------------- |
| `Arrays.setAll()`         | ❌ 单线程                 |
| `Arrays.parallelSetAll()` | ✅ 多线程并行（ForkJoinPool） |

数组大、计算复杂时，并行版本更快。

---

## ✨ 基础例子

### 例1：把数组填成下标的平方

```java
int[] arr = new int[10];

Arrays.parallelSetAll(arr, i -> i * i);

System.out.println(Arrays.toString(arr));
```

结果：

```
[0, 1, 4, 9, 16, 25, 36, 49, 64, 81]
```

执行逻辑是：

```
arr[0] = 0*0
arr[1] = 1*1
arr[2] = 2*2
...
```

---

### 例2：初始化对象数组

```java
String[] arr = new String[5];

Arrays.parallelSetAll(arr, i -> "index=" + i);
```

---

## ⚙️ 底层怎么并行？

它用的是：

> **ForkJoinPool.commonPool()**

自动把数组拆块，多线程算。

你不用管线程。

---

## 🚨 注意点（很重要）

### ❗ 1. generator 里别写有副作用的代码

这是错的示范：

```java
int sum = 0;
Arrays.parallelSetAll(arr, i -> sum += i); // ❌ 线程不安全
```

因为多个线程会同时改 `sum`，结果乱。

---

### ❗ 2. 小数组别用

并行是有开销的，小数组反而更慢。

---

### ❗ 3. 适合这种场景

✔ 大数组
✔ 每个元素计算互不影响
✔ 计算逻辑较重

比如：图像处理、数值计算、矩阵运算。

---

## 🧠 总结一句人话

`parallelSetAll` 就是：

> “**你告诉我规则，我帮你并行把整个数组造出来**”

等价于：

```java
for (int i = 0; i < arr.length; i++) {
    arr[i] = f(i);
}
```

只不过它是 **多线程版本** 🚀

---

要不要我再画个「线程分块执行示意图」帮你彻底理解它怎么拆任务？



你这个问题问得特别好，这正是 **Java 8 之后代码风格突变的核心点** 😄

你这句：

```java
new Thread(Producter_and_Consumer::add);
```

里面的 `::` 叫：

> 🎯 **方法引用（Method Reference）**

---

## 🌰 先说人话

这句代码 **等价于**：

```java
new Thread(() -> Producter_and_Consumer.add());
```

也等价于更早的写法：

```java
new Thread(new Runnable() {
    @Override
    public void run() {
        Producter_and_Consumer.add();
    }
});
```

👉 也就是说：

**`::` 是 Lambda 的“极简写法”**

---

## 🧠 背后的原理

`Thread` 构造器需要的是：

```java
public Thread(Runnable target)
```

而 `Runnable` 是个函数式接口：

```java
@FunctionalInterface
public interface Runnable {
    void run();
}
```

它只需要一个：

```
无参 → 无返回值 的方法
```

而你这个：

```java
private static void add()
```

刚好签名匹配：

```
() -> void
```

所以 Java 看到：

```java
Producter_and_Consumer::add
```

就理解为：

> “把这个方法当成 Runnable.run() 来用”

---

## 📌 方法引用本质

方法引用就是：

> **把“已经存在的方法”当成函数传进去**

语法：

```
类名::方法名
对象::方法名
类名::new   （构造器引用）
```

---

## 🔍 你这个属于哪种？

```java
Producter_and_Consumer::add
```

属于：

> **类名::静态方法**

因为 `add()` 是 `static`

---

## ✨ 再举几个对比（秒懂）

### ① 普通 lambda

```java
i -> i * 2
```

### 方法引用版

```java
Integer::valueOf
```

---

### ② 线程例子

```java
new Thread(() -> System.out.println("hello")).start();
```

方法引用版：

```java
new Thread(System.out::println).start();
```

---

## 🚨 你代码里有个隐藏 bug

你写了：

```java
new Thread(Producter_and_Consumer::add);
```

⚠️ **线程根本没启动！！**

应该是：

```java
new Thread(Producter_and_Consumer::add).start();
```

否则只是创建线程对象，没有运行。

---

## 🧠 总结一句

`::` 方法引用 = **把一个现成的方法，当成 Lambda 传给函数式接口**

你这句的意思就是：

> “创建一个线程，让它去执行 add() 方法”



# 🧩 `DecimalFormat` 是干嘛的？

这个是 Java 里**做数字格式化的王牌类**，比 `String.format` 更专业 👇


一句话：

> **把数字按指定“格式模板”变成字符串**

包：

```java
java.text.DecimalFormat
```

---

# 🧠 基本用法

```java
double num = 12345.6789;

DecimalFormat df = new DecimalFormat("格式规则");
String result = df.format(num);
```

---

# 🎯 最核心：格式符号

| 符号  | 作用         |
| --- | ---------- |
| `0` | 必须有数字，不够补0 |
| `#` | 可有可无       |
| `.` | 小数点        |
| `,` | 千位分隔符      |
| `%` | 乘100并加%    |
| `¤` | 货币符号       |
| `E` | 科学计数法      |

---

# 🌰 常见场景

## ① 保留小数位

```java
DecimalFormat df = new DecimalFormat("0.00");
System.out.println(df.format(3.1));     // 3.10
System.out.println(df.format(3));       // 3.00
```

`0` 表示必须有。

---

## ② 可选小数位

```java
DecimalFormat df = new DecimalFormat("0.##");
System.out.println(df.format(3.1));     // 3.1
System.out.println(df.format(3));       // 3
```

`#` 表示没有就不显示。

---

## ③ 千位分隔

```java
DecimalFormat df = new DecimalFormat("#,###");
System.out.println(df.format(1234567)); // 1,234,567
```

---

## ④ 百分比

```java
DecimalFormat df = new DecimalFormat("0.00%");
System.out.println(df.format(0.256));   // 25.60%
```

自动 ×100。

---

## ⑤ 金额

```java
DecimalFormat df = new DecimalFormat("¤#,##0.00");
System.out.println(df.format(1234.5));  // ￥1,234.50 （取决于地区）
```

---

## ⑥ 科学计数法

```java
DecimalFormat df = new DecimalFormat("0.###E0");
System.out.println(df.format(12345));   // 1.235E4
```

---

# ⚙️ 进阶控制

```java
df.setRoundingMode(RoundingMode.HALF_UP); // 四舍五入
df.setMaximumFractionDigits(2);
df.setMinimumIntegerDigits(3);
```

---

# 🔍 和 String.format 区别

| 对比     | DecimalFormat | String.format |
| ------ | ------------- | ------------- |
| 控制精度   | 更灵活           | 一般            |
| 本地化    | 强             | 一般            |
| 金额/百分比 | 很方便           | 麻烦            |
| 性能     | 高             | 稍慢            |

---

# 🚨 注意

### 1️⃣ 线程不安全

多线程要各自 new 或加锁。

### 2️⃣ 只负责“显示”，不改变原数值

---

# 🧠 一句话总结

> `DecimalFormat` = **给数字套模板，想怎么长就怎么长**


## 数字类 math
**Java `Math` 类的常用数学方法**，这个类基本是“计算工具箱” 📦

包：

```java
java.lang.Math   // 不用导包，默认可用
```

---

# 🧩 一、数学常量

```java
System.out.println(Math.PI);  // π = 3.141592653589793
System.out.println(Math.E);   // e = 2.718281828459045
```

---

# 🧩 二、绝对值

```java
double a = -123456.36695;
System.out.printf("%.2f%n", Math.abs(a));
```

👉 `abs()` = 取绝对值
结果：`123456.37`

---

# 🧩 三、取整相关（重点！）

你图里这三兄弟是面试常客 👇

```java
double b = 43.4;

System.out.printf("The ceiling of %.2f is %.2f%n", b, Math.ceil(b));
System.out.printf("The floor of %.2f is %.2f%n", b, Math.floor(b));
System.out.printf("The rint of %.2f is %.2f%n", b, Math.rint(b));
```

### 区别：

| 方法        | 作用      | 例子(43.4) |
| --------- | ------- | -------- |
| `ceil()`  | 向上取整    | 44.0     |
| `floor()` | 向下取整    | 43.0     |
| `rint()`  | 四舍六入五成双 | 43.0     |

---

## ❗ rint 特殊规则（银行家舍入）

```java
Math.rint(3.5) → 4.0
Math.rint(2.5) → 2.0
```

靠近偶数。

---

# 🧩 四、四舍五入

```java
Math.round(3.6);   // 4
Math.round(3.4);   // 3
```

⚠ 返回 `long` 或 `int`

---

# 🧩 五、最大最小

```java
Math.max(10, 20);  // 20
Math.min(10, 20);  // 10
```

---

# 🧩 六、幂 & 开方

```java
Math.pow(2, 3);  // 8.0
Math.sqrt(16);   // 4.0
Math.cbrt(27);   // 3.0
```

---

# 🧩 七、随机数

```java
Math.random();  // [0.0, 1.0)
```

生成 1~10：

```java
int n = (int)(Math.random() * 10) + 1;
```

---

# 🧩 八、三角函数

```java
Math.sin(Math.PI / 2); // 1
Math.cos(0);           // 1
Math.tan(Math.PI / 4); // 1
```

角度转弧度：

```java
Math.toRadians(90);
```

---

# 🧩 九、完整示例代码（带注释）

```java
public class MathDemo {
    public static void main(String[] args) {

        // 常量
        System.out.println(Math.PI);
        System.out.println(Math.E);

        // 绝对值
        double a = -123456.36695;
        System.out.printf("abs: %.2f%n", Math.abs(a));

        // 取整
        double b = 43.4;
        System.out.printf("ceil: %.2f%n", Math.ceil(b));
        System.out.printf("floor: %.2f%n", Math.floor(b));
        System.out.printf("rint: %.2f%n", Math.rint(b));

        // 四舍五入
        System.out.println("round: " + Math.round(3.6));

        // 幂运算
        System.out.println("pow: " + Math.pow(2, 3));

        // 开方
        System.out.println("sqrt: " + Math.sqrt(16));

        // 最大最小
        System.out.println("max: " + Math.max(5, 8));

        // 随机数
        System.out.println("random: " + Math.random());
    }
}
```

---

# 🎯 一句话总结

`Math` 类就是：

> **“不用 new 的数学工具箱”**


## this关键字

在Java中，`this`关键字是一个非常重要的引用，它指向**当前对象**本身。让我详细介绍它的主要用法：

## 1. 引用当前类的实例变量

当局部变量（方法参数）与实例变量重名时，用`this`来区分：

```java
public class Person {
    private String name;
    private int age;
    
    public Person(String name, int age) {
        this.name = name;  // this.name指向实例变量，name指向方法参数
        this.age = age;    // 如果不加this，就是参数自己赋值给自己
    }
}
```

## 2. 调用当前类的其他构造方法

在一个构造方法中调用另一个构造方法，**必须写在第一行**：

```java
public class Student {
    private String name;
    private int age;
    private String school;
    
    // 完整构造方法
    public Student(String name, int age, String school) {
        this.name = name;
        this.age = age;
        this.school = school;
    }
    
    // 无学校信息的构造方法，调用上面的构造方法
    public Student(String name, int age) {
        this(name, age, "未入学");  // 调用三个参数的构造方法
    }
    
    // 无参构造方法，调用两个参数的构造方法
    public Student() {
        this("未知", 0);  // 调用两个参数的构造方法
    }
}
```

## 3. 返回当前对象实例

实现链式调用（方法返回对象本身）：

```java
public class StringBuilder {
    private String value = "";
    
    public StringBuilder append(String str) {
        value += str;
        return this;  // 返回当前对象，支持链式调用
    }
    
    public StringBuilder append(int num) {
        value += num;
        return this;  // 返回当前对象
    }
}

// 使用示例
StringBuilder sb = new StringBuilder();
sb.append("Hello").append(" ").append("World");
```

## 4. 作为方法参数传递

将当前对象作为参数传递给其他方法：

```java
public class EventHandler {
    public void registerListener() {
        // 将当前对象注册为监听器
        EventManager.addListener(this);
    }
}

public class TreeNode {
    private TreeNode parent;
    
    public void setParent(TreeNode node) {
        this.parent = node;
        node.addChild(this);  // 将当前节点添加为子节点
    }
}
```

## 5. 区分内部类和外部类的this

在内部类中访问外部类的实例：

```java
public class OuterClass {
    private String name = "Outer";
    
    class InnerClass {
        private String name = "Inner";
        
        public void printNames() {
            // 访问内部类的成员
            System.out.println(this.name);           // 输出: Inner
            
            // 访问外部类的成员
            System.out.println(OuterClass.this.name); // 输出: Outer
        }
    }
}
```

## 6. 调用当前类的实例方法

虽然通常可以省略，但有时为了代码清晰可以加上：

```java
public class Calculator {
    private int result = 0;
    
    public void add(int value) {
        // 可以省略this，编译器会自动添加
        this.result += value;
    }
    
    public void display() {
        // 显式使用this调用方法
        this.printResult();  // 等同于 printResult();
    }
    
    private void printResult() {
        System.out.println("结果: " + this.result);
    }
}
```

## 注意事项

1. **不能在静态上下文中使用this**：静态方法属于类而非对象
   ```java
   public class Test {
       private int value;
       
       public static void staticMethod() {
           // this.value = 10;  // 编译错误！静态方法不能使用this
       }
   }
   ```

2. **构造方法调用必须是第一个语句**
   ```java
   public class Example {
       public Example() {
           // this("test");  // 正确
           // System.out.println("test");  // 如果这行在前面，编译错误
           // this("test");  // 不能放在这里，必须在第一行
       }
       
       public Example(String s) { }
   }
   ```

`this`关键字的核心作用是消除歧义和实现对象自身的引用，掌握这些用法能帮助你写出更清晰、更灵活的Java代码。

## 传值 传址

在Java中，**只有传值（值传递）**，没有传地址（引用传递）。这是一个非常重要的概念，很多初学者容易误解。让我详细解释：

## 基本概念

**Java总是传值**，但传递的内容取决于参数类型：
- **基本类型**：传递的是值的副本
- **引用类型**：传递的是引用的副本（对象的地址值）

## 1. 基本类型的传值

传递的是实际值的副本，方法内的修改不影响原变量：

```java
public class ValuePassing {
    public static void main(String[] args) {
        int num = 10;
        System.out.println("调用前: " + num);  // 10
        
        changeValue(num);
        System.out.println("调用后: " + num);  // 10（值不变）
    }
    
    public static void changeValue(int x) {
        x = 20;  // 修改的是副本，不影响原变量
        System.out.println("方法内: " + x);   // 20
    }
}
```

## 2. 引用类型的传值

传递的是引用的副本（对象地址），两个引用指向同一个对象：

```java
public class ReferencePassing {
    public static void main(String[] args) {
        Person person = new Person("张三", 20);
        System.out.println("调用前: " + person.getName());  // 张三
        
        changeName(person);
        System.out.println("调用后: " + person.getName());  // 李四（对象内容改变了）
        
        System.out.println("调用前引用: " + person);  // Person@15db9742
        
        changeReference(person);
        System.out.println("调用后引用: " + person);  // Person@15db9742（引用本身没变）
    }
    
    // 修改对象内容 - 会影响原对象
    public static void changeName(Person p) {
        p.setName("李四");  // 通过引用副本修改同一个对象
    }
    
    // 尝试修改引用本身 - 不会影响原引用
    public static void changeReference(Person p) {
        p = new Person("王五", 30);  // 只修改了引用的副本
        System.out.println("方法内新引用: " + p);  // Person@6d06d69c
    }
}

class Person {
    private String name;
    private int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
```

## 3. 常见误解示例

### 误解1：认为可以修改引用本身
```java
public class Misunderstanding1 {
    public static void main(String[] args) {
        String str = "Hello";
        changeString(str);
        System.out.println(str);  // 仍然是 "Hello"，不是 "World"
    }
    
    public static void changeString(String s) {
        s = "World";  // 只修改了引用的副本
    }
}
```

### 误解2：包装类的特殊情况
```java
public class WrapperExample {
    public static void main(String[] args) {
        Integer num = 100;
        changeInteger(num);
        System.out.println(num);  // 100，不是 200
    }
    
    public static void changeInteger(Integer i) {
        i = 200;  // 实际上是 i = Integer.valueOf(200)，修改了引用指向
    }
}
```

## 4. 数组也是引用类型

```java
public class ArrayExample {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        
        modifyArray(arr);
        System.out.println(Arrays.toString(arr));  // [99, 2, 3]（内容改变）
        
        reassignArray(arr);
        System.out.println(Arrays.toString(arr));  // [99, 2, 3]（引用未变）
    }
    
    // 修改数组内容 - 会生效
    public static void modifyArray(int[] array) {
        array[0] = 99;
    }
    
    // 重新分配数组 - 不会生效
    public static void reassignArray(int[] array) {
        array = new int[]{4, 5, 6};  // 只修改了引用的副本
    }
}
```

## 5. 实际应用中的理解

### 5.1 交换两个对象 - 错误示范
```java
public class SwapExample {
    public static void main(String[] args) {
        Person p1 = new Person("张三", 20);
        Person p2 = new Person("李四", 25);
        
        swap(p1, p2);
        System.out.println(p1.getName());  // 张三（没交换成功）
        System.out.println(p2.getName());  // 李四（没交换成功）
    }
    
    // 无法交换两个引用本身
    public static void swap(Person a, Person b) {
        Person temp = a;
        a = b;
        b = temp;  // 只交换了引用的副本
    }
}
```

### 5.2 正确做法：交换对象属性
```java
public class CorrectSwap {
    public static void main(String[] args) {
        Person p1 = new Person("张三", 20);
        Person p2 = new Person("李四", 25);
        
        swapNames(p1, p2);
        System.out.println(p1.getName());  // 李四
        System.out.println(p2.getName());  // 张三
    }
    
    // 交换属性值，而不是引用
    public static void swapNames(Person a, Person b) {
        String tempName = a.getName();
        a.setName(b.getName());
        b.setName(tempName);
    }
}
```

## 6. 图解理解

```
基本类型传值：
main: num = 10  ──副本──→ changeValue: x = 10
                           x = 20
main: num 仍然是 10

引用类型传值：
main: person ──副本──→ changeName: p
      │                    │
      ↓                    ↓
    Person对象         指向同一个对象
    name="张三" ←────────修改 name="李四"
```

## 总结

1. **Java只有传值，没有传地址**
2. **基本类型**：传递值的副本，方法内修改不影响原变量
3. **引用类型**：传递引用的副本，通过这个副本可以修改对象内容，但不能修改原引用本身
4. **String、包装类等不可变类**：看起来像基本类型，其实是引用传递，但内容不可修改
5. **数组**：也是引用类型，遵循同样的规则

理解这一点对避免bug非常重要，特别是在方法调用和参数传递时。


## java 9-17 新特性学习+回顾复习

### Lambda
 
Java 8引入了Lambda语法，用以简化单抽象方法接口的实现
 
Lambda语法实现了类型自动推断
 
单抽象方法接口被称为函数式接口，标注为`@FunctionalInterface`

### 方法引用
 
Functional Interface可以传入：
 
* 接口的实现类（代码较繁琐）
* Lambda表达式
* 符合方法签名的静态方法
* 符合方法签名的实例方法（实例类型被看做第一个参数类型）
* 符合方法签名的构造方法（实例类型被看做返回类型）


我们来看一下Lambda表达式的具体规范：

标准格式为：([参数类型 参数名称,]...) ‐> { 代码语句，包括返回值 }
和匿名内部类不同，Lambda仅支持接口，不支持抽象类
接口内部必须有且仅有一个抽象方法（可以有多个方法，但是必须保证其他方法有默认实现，必须留一个抽象方法出来）



## java 9模块化开发
Java 9引入的模块机制（官方名称是**Java平台模块系统**，即JPMS，项目代号Project Jigsaw）是Java自诞生以来最重要的一次变革。它的核心思想是让Java程序像搭积木一样，由一个个独立、自描述的“模块”组成，从而从根本上解决大型软件长期以来的维护和依赖难题 。

你可以把它理解为在传统的**类（class）**和**包（package）**之上，增加了一层新的、更强大的组织单元 。



### 🤔 为什么需要模块？解决“类路径地狱”

在Java 9之前，Java程序依赖的是“类路径”（classpath）。这种方式随着项目规模变大，容易引发一系列问题：
- **依赖冲突**：两个同名的类（如 `com.example.Util`）共存，系统随机加载一个，导致诡异的运行时错误 。
- **版本混乱**：不同库依赖同一日志框架的不同版本，可能引发 `NoSuchMethodError` 。
- **封装脆弱**：即使类被声明为 `public`，如果它是库的内部实现，也无法阻止外部代码直接访问它，增加了维护成本 。

模块机制的出现，就是为了给这些问题画上句号。

### 🧱 什么是Java模块？

一个模块就是一组相关的包和资源的集合，它的核心是**模块描述符**，文件名为 `module-info.java`，位于模块的根目录 。这个文件就是模块的“说明书”，它明确地声明了：

- **模块的名字**：全局唯一 。
- **它需要什么**：通过 `requires` 关键字，声明该模块依赖哪些其他模块 。
- **它给谁用什么**：通过 `exports` 关键字，声明哪些包是公开的，允许其他模块访问。未导出的包，即使内部的类是 `public`，对外部也是不可见的，实现了真正的封装 。

### ✨ 模块化的核心优势

- **强封装性**：模块可以精确控制哪些代码可以对外暴露。内部实现细节被完全隐藏，提高了代码的安全性和可维护性 。
- **可靠的配置**：依赖关系变得清晰且强制。编译时就能发现缺少依赖或版本冲突的问题，将错误扼杀在萌芽状态，告别运行时 `ClassNotFoundException` 的困扰 。
- **可扩展的JDK**：JDK自身也被模块化，拆分为几十个模块（如 `java.base`、`java.sql`、`java.xml`）。借助新增的 `jlink` 工具，你可以为应用程序定制一个只包含所需模块的最小化JRE，极大缩减运行时体积，特别适合云原生和容器化部署 。
- **清晰的架构**：模块强制你思考和定义代码之间的边界，有助于构建更清晰、更易于理解和维护的大型企业级应用 。

### 💡 最简单的例子：`module-info.java` 长什么样？

```java
// 文件位置: src/main/java/module-info.java

module com.example.myapp {          // 声明一个名为 com.example.myapp 的模块
    requires java.sql;              // 这个模块需要使用 java.sql 模块
    exports com.example.myapp.api;  // 只对外公开 com.example.myapp.api 包
}
```

总而言之，Java 9的模块机制为Java平台引入了“强封装+显式依赖”的理念，它就像为代码世界引入了“法律和秩序”，让大型应用的构建和维护变得更加可靠和高效。虽然对于小型项目或初学者来说，可能暂时感受不到它的威力，但在中大型企业级开发中，它已成为一项不可或缺的基础设施。




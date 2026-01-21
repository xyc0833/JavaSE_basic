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


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



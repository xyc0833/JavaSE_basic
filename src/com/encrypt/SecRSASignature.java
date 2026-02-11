package com.encrypt;

import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class SecRSASignature {

    // -------------------------
    // 成员变量：RSA私钥和公钥
    // -------------------------
    PrivateKey sk; // 私钥，用于签名
    PublicKey pk;  // 公钥，用于验证签名

    // -------------------------
    // 构造方法1：生成新的RSA密钥对
    // -------------------------
    public SecRSASignature() throws GeneralSecurityException {
        // 创建RSA密钥生成器
        KeyPairGenerator kpGen = KeyPairGenerator.getInstance("RSA");
        kpGen.initialize(1024); // 指定密钥长度1024位（实际生产建议2048或以上）
        KeyPair kp = kpGen.generateKeyPair(); // 生成KeyPair
        this.sk = kp.getPrivate(); // 保存私钥
        this.pk = kp.getPublic();  // 保存公钥
    }

    // -------------------------
    // 构造方法2：通过已有的公钥和私钥字节数组恢复对象
    // -------------------------
    public SecRSASignature(byte[] pk, byte[] sk) throws GeneralSecurityException {
        KeyFactory kf = KeyFactory.getInstance("RSA"); // 获取RSA KeyFactory
        // 公钥：X.509编码
        X509EncodedKeySpec pkSpec = new X509EncodedKeySpec(pk);
        this.pk = kf.generatePublic(pkSpec);
        // 私钥：PKCS#8编码
        PKCS8EncodedKeySpec skSpec = new PKCS8EncodedKeySpec(sk);
        this.sk = kf.generatePrivate(skSpec);
    }

    // -------------------------
    // 获取私钥字节
    // -------------------------
    public byte[] getPrivateKey() {
        return this.sk.getEncoded();
    }

    // -------------------------
    // 获取公钥字节
    // -------------------------
    public byte[] getPublicKey() {
        return this.pk.getEncoded();
    }

    // -------------------------
    // 用私钥签名消息
    // -------------------------
    public byte[] sign(byte[] message) throws GeneralSecurityException {
        Signature signature = Signature.getInstance("SHA1withRSA"); // 使用SHA1withRSA算法
        signature.initSign(this.sk);  // 初始化签名对象，使用私钥
        signature.update(message);    // 更新消息内容
        return signature.sign();      // 返回签名结果
    }

    // -------------------------
    // 用公钥验证签名
    // -------------------------
    public boolean verify(byte[] message, byte[] sign) throws GeneralSecurityException {
        Signature signature = Signature.getInstance("SHA1withRSA"); // SHA1withRSA验证
        signature.initVerify(this.pk); // 使用公钥初始化验证对象
        signature.update(message);     // 更新消息内容
        return signature.verify(sign); // 返回验证结果（true/false）
    }

    // -------------------------
    // 测试方法
    // -------------------------
    public static void main(String[] args) throws Exception {
        // 原始消息
        byte[] message = "Hello，使用SHA1withRSA算法进行数字签名！".getBytes("UTF-8");

        // 生成新的RSA签名对象
        SecRSASignature rsas = new SecRSASignature();

        // 使用私钥签名消息
        byte[] sign = rsas.sign(message);
        System.out.println("sign: " + Base64.getEncoder().encodeToString(sign));

        // 使用公钥验证签名（正确情况）
        boolean verified = rsas.verify(message, sign);
        System.out.println("verify: " + verified);

        // 用另一个新的RSA对象的公钥验证（会失败）
        boolean verified2 = new SecRSASignature().verify(message, sign);
        System.out.println("verify with another public key: " + verified2);

        // 修改原始消息，验证签名（会失败）
        message[0] = 100;
        boolean verified3 = rsas.verify(message, sign);
        System.out.println("verify changed message: " + verified3);
    }
}

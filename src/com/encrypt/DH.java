package com.encrypt;

import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class DH {

    public static void main(String[] args) {
        // 创建 Bob 和 Alice 两个用户对象
        Person bob = new Person("Bob");
        Person alice = new Person("Alice");

        // 各自生成 DH KeyPair（公私钥对）
        bob.generateKeyPair();
        alice.generateKeyPair();

        // 双方交换各自的PublicKey并生成共享密钥
        bob.generateSecretKey(alice.publicKey.getEncoded());   // Bob 用 Alice 的公钥生成本地AES密钥
        alice.generateSecretKey(bob.publicKey.getEncoded());   // Alice 用 Bob 的公钥生成本地AES密钥

        // 打印密钥信息，检查双方生成的SecretKey是否一致
        bob.printKeys();
        alice.printKeys();

        // 使用共享SecretKey进行AES加密/解密消息
        String msgBobToAlice = bob.sendMessage("Hello, Alice!");  // Bob加密消息发送给Alice
        System.out.println("Bob -> Alice: " + msgBobToAlice);
        String aliceDecrypted = alice.receiveMessage(msgBobToAlice);  // Alice解密消息
        System.out.println("Alice decrypted: " + aliceDecrypted);
    }
}

class Person {

    public final String name;

    public PublicKey publicKey;       // 本地公钥
    private PrivateKey privateKey;    // 本地私钥
    private SecretKey secretKey;      // 双方共享的AES密钥

    public Person(String name) {
        this.name = name;
    }

    // -------------------------
    // 生成本地DH KeyPair
    // -------------------------
    public void generateKeyPair() {
        try {
            KeyPairGenerator kpGen = KeyPairGenerator.getInstance("DH");
            kpGen.initialize(512); // DH key size 512位（实际生产建议2048位以上）
            KeyPair kp = kpGen.generateKeyPair();
            this.privateKey = kp.getPrivate();  // 本地私钥
            this.publicKey = kp.getPublic();    // 本地公钥
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
    }

    // -------------------------
    // 使用对方PublicKey生成共享AES密钥
    // -------------------------
    public void generateSecretKey(byte[] receivedPubKeyBytes) {
        try {
            // 将接收到的byte[]公钥转换为PublicKey对象
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(receivedPubKeyBytes);
            KeyFactory kf = KeyFactory.getInstance("DH");
            PublicKey receivedPublicKey = kf.generatePublic(keySpec);

            // 初始化DH KeyAgreement，用本地私钥
            KeyAgreement keyAgreement = KeyAgreement.getInstance("DH");
            keyAgreement.init(this.privateKey);

            // 执行密钥交换阶段，输入对方公钥
            keyAgreement.doPhase(receivedPublicKey, true);

            // 生成共享密钥 byte[]
            byte[] sharedSecret = keyAgreement.generateSecret();

            // 使用共享字节生成AES密钥 (128位)
            // 注意：AES-128需要16字节，AES-256需要32字节，确保截取长度正确
            this.secretKey = new SecretKeySpec(sharedSecret, 0, 16, "AES");

        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
    }

    // -------------------------
    // 打印本地密钥信息
    // -------------------------
    public void printKeys() {
        System.out.printf("Name: %s\n", this.name);
        System.out.printf("Private key: %x\n", new BigInteger(1, this.privateKey.getEncoded()));
        System.out.printf("Public key: %x\n", new BigInteger(1, this.publicKey.getEncoded()));
        System.out.printf("Secret key: %x\n", new BigInteger(1, this.secretKey.getEncoded()));
    }

    // -------------------------
    // 使用共享AES密钥加密消息
    // -------------------------
    public String sendMessage(String message) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding"); // AES加密，ECB模式 + PKCS5填充
            cipher.init(Cipher.ENCRYPT_MODE, this.secretKey);
            byte[] data = cipher.doFinal(message.getBytes("UTF-8"));
            return Base64.getEncoder().encodeToString(data);  // 返回Base64字符串方便传输
        } catch (GeneralSecurityException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    // -------------------------
    // 使用共享AES密钥解密消息
    // -------------------------
    public String receiveMessage(String message) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding"); // AES解密
            cipher.init(Cipher.DECRYPT_MODE, this.secretKey);
            byte[] data = cipher.doFinal(Base64.getDecoder().decode(message));
            return new String(data, "UTF-8");
        } catch (GeneralSecurityException | IOException e) {
            throw new RuntimeException(e);
        }
    }

}

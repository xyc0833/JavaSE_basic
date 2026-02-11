package com.encrypt;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Xyc_encrypt {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//ULR编码
		String original = "URL 参数";
		//对字符串进行编码
		String encoded = URLEncoder.encode(original, "UTF-8");
		System.out.println(encoded);
		String ori = new String(URLDecoder.decode(encoded, "UTF-8"));
		System.out.println(ori);
		
		//base64编码
		String original02 = "Hello\u00ff编码测试";
		//.withoutPadding()可以把末尾的等号去掉
		String b64 = Base64.getUrlEncoder().withoutPadding().encodeToString(original02.getBytes("UTF-8"));
		System.out.println(b64);
		String ori02 = new String(Base64.getUrlDecoder().decode(b64), "UTF-8");
		System.out.println(ori02);
		
		//MD5算法
		// 原始字符串（要进行 MD5 摘要计算的内容）
		String s = "MD5摘要算法测试";
		// 把字符串按 UTF-8 编码转换成字节数组，然后传给 toMD5 方法计算摘要
		// MD5 本质上是对“字节”做运算，不是直接对字符串
		byte[] r = toMD5(s.getBytes("UTF-8"));
		// 把 MD5 结果（16字节）转成 32 位的十六进制字符串并输出
		System.out.println(
		    String.format("%032x",          // 格式化为 32 位，不足前面补 0，x 表示十六进制小写
		        new BigInteger(1, r)        // 把字节数组当作“无符号整数”转换成 BigInteger
		    )
		);
		
		//MD5算法 通过加入salt值 把一个不太安全的口令变成一个相对安全的口令
		String passwd = "helloworld";
		String salt = "Random salt";
		byte[] r01 = Xyc_encrypt.toMD5((salt + passwd).getBytes("UTF-8"));
		System.out.println(String.format("%032x", new BigInteger(1, r01)));
		
		//SHA-1 摘要算法
		String s01 = "Java摘要算法测试";
		byte[] input = s01.getBytes("UTF-8");
		// 标准算法名称：
		// http://docs.oracle.com/javase/6/docs/technotes/guides/security/StandardNames.html#MessageDigest
		byte[] r1 = digest("MD5", input);
		System.out.println(r1.length + ": " + String.format("%0" + (r1.length * 2) + "x", new BigInteger(1, r1)));
		byte[] r2 = digest("SHA-1", input);
		System.out.println(r2.length + ": " + String.format("%0" + (r2.length * 2) + "x", new BigInteger(1, r2)));
		byte[] r3 = digest("SHA-256", input);
		System.out.println(r3.length + ": " + String.format("%0" + (r3.length * 2) + "x", new BigInteger(1, r3)));
		//byte[] r4 = digest("RipeMD160", input);
		//System.out.println(r4.length + ": " + String.format("%0" + (r4.length * 2) + "x", new BigInteger(1, r4)));

		//AES算法
		// 原文:
		String message = "Hello, world! encrypted using AES!";
		System.out.println("Message: " + message);
		// 128位密钥 = 16 bytes Key:
		byte[] key = "1234567890abcdef".getBytes("UTF-8");
		// 加密:
		byte[] data = message.getBytes(StandardCharsets.UTF_8);
		byte[] encrypted = encrypt(key, data);
		System.out.println("Encrypted data: " + Base64.getEncoder().encodeToString(encrypted));
		// 解密:
		byte[] decrypted = decrypt(key, encrypted);
		System.out.println("Decrypted data: " + new String(decrypted, "UTF-8"));
		

	}
	
	//AES对称加密算法
	static final String CIPHER_NAME = "AES/ECB/PKCS5Padding";

	// 加密:
	public static byte[] encrypt(byte[] key, byte[] input) throws GeneralSecurityException {
		Cipher cipher = Cipher.getInstance(CIPHER_NAME);
		SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
		cipher.init(Cipher.ENCRYPT_MODE, keySpec);
		return cipher.doFinal(input);
	}

	// 解密:
	public static byte[] decrypt(byte[] key, byte[] input) throws GeneralSecurityException {
		Cipher cipher = Cipher.getInstance(CIPHER_NAME);
		SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
		cipher.init(Cipher.DECRYPT_MODE, keySpec);
		return cipher.doFinal(input);
	}
	
	public static byte[] digest(String hashAlgorithm, byte[] input) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance(hashAlgorithm);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		md.update(input);
		return md.digest();
	}
	
	public static byte[] toMD5(byte[] input) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		md.update(input);
		return md.digest();
	}

}

package com.xyc;
import static java.lang.System.out;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

public class Abstract_xyc {
	public static void main(String[] args) {
		Shape s1 = new Rect(12, 15);
		Shape s2 = new Circle(3.4);
		
		System.out.println(s1.area());
		System.out.println(s2.area());
		
		Hello h = new Hello("World");
		
		out.println(h.hello());
		
		for (Weekday p : Weekday.values()) {
			System.out.println(p.name());
		}
		Weekday fri = Weekday.FRI;
		// enum -> String:
		System.out.println("FRI.name() = " + fri.name());
		// 定义时的序号:
		System.out.println("FRI.ordinal() = " + fri.ordinal());
		// String -> enum:
		System.out.println(Weekday.valueOf("FRI").name());
		
		// Math
		System.out.println(Math.sqrt(2)); // 1.414
		
		//Random
		Random ra = new Random(123);
		//123 是 随机种子（seed）
		// 相同的 seed → 生成的随机序列完全一样
		System.out.println(ra.nextInt()); //生成一个 int 范围内的随机数
		
		SecureRandom se = new SecureRandom() ;
		System.out.println(se.nextInt());
		
		// SecureRandom
		SecureRandom sr = new SecureRandom();
		System.out.println(sr.nextInt());
		System.out.println(sr.nextInt());

		// BigInteger
		BigInteger bi = new BigInteger("1234567890");
		System.out.println(bi.pow(5));

		// BigDecimal
		BigDecimal bd = new BigDecimal("123.10");
		System.out.println(bd.multiply(bd));
		
//		test("UTF-8");
//		test("ABC");
		
//		process("abc");
//		
//		process1();
		
		double x = abs(-123.45);
		assert x >= 0 : "x must >= 0 but x = " + x;
		System.out.println(x);
	}
	static void test(String encoding) {
		System.out.print("Test encoding " + encoding + "...");
		try {
			"test".getBytes(encoding);
			System.out.println(" ok.");
		} catch (UnsupportedEncodingException e) {
			System.out.println(" failed.");
			System.out.println(e);
		}
	}
	
	static void process(String s) {
		try {
			int n = Integer.parseInt(s); //Java 中把“字符串 → 整数”
			int m = 100 / n;
		//可以同时捕获两种异常
		} catch (NumberFormatException | ArithmeticException e) {
			System.out.println(e);
			System.out.println("Bad input.");
		}  finally {
			System.out.println("end process.");
		}
	}
	
	static void process1() {
		try {
			process2();
		} catch (Exception e) {
			//用来把异常的“调用栈信息”打印到控制台，方便定位错误发生的位置。
			e.printStackTrace();
			
		} finally {
			System.out.println("END");
		}
	}

	static void process2() {
		process3();
	}

	static void process3() {
		try {
		Integer.parseInt(null);
		}catch (NumberFormatException e) {
			//将原始的异常 传入到新异常中
			throw new IllegalArgumentException(e);
		}
		
		/**
		 * 	try {
		    somethingWrong("");
		} catch (Exception e) {
		    e.printStackTrace();

		    for (Throwable t : e.getSuppressed()) {
		        t.printStackTrace();
		    }
		}
		 * */		
	}
	static double abs(double d) {
		return d >= 0 ? d : -d;
	}
	
}


class Hello {

	private final String name;

	public Hello(String name) {
		this.name = name;
	}

	public String hello() {
		return "Hello, " + name + "!";
	}
}
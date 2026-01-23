package com.xyc;

import java.nio.charset.StandardCharsets;

public class Str {

	public static void main(String[] args) {
		String s = "Hello, world!";
		System.out.println(s);
		String sub = s.substring(7);
		System.out.println(sub);
		System.out.println(" 中文 ".trim());
		byte[] data = "中文ABC".getBytes(StandardCharsets.UTF_8);
		System.out.println(data);
		String s2 = new String(data, StandardCharsets.UTF_8);
		System.out.println(s2);
		
		char c1 = 'A';
		char c2 = '中';
		int n1 = c1; // 65
		int n2 = c2; // 20013
		System.out.println(n1);
		System.out.println(n2);
		char c3 = '\u0041';
		char c4 = '\u4e2d';
		System.out.println(c3);
		System.out.println(c4);
		
		String name = "World";
		StringBuilder sb = new StringBuilder();
		sb.append("Hello, ").append(name).append('!');
		String s01 = sb.toString();
		System.out.println(s01);
		
		
		Integer n = 5 + Integer.valueOf(10);
		Number m = n;
		System.out.println(m.floatValue());
	}
	
}


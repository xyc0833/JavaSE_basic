package com.regularX;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Xyc_regex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "1978";
		boolean x = is19xx(s);
		System.out.println(x);
		
		String tags = "java, php; python";
		String[] arr = tags.split("[\\s\\,\\;]+");
		System.out.println(Arrays.toString(arr));
		
		//希望在一个句子中 查找英文单词 the
		String s01 = "The quick brown fox jumps over the lazy dog.";
		//Pattern.CASE_INSENSITIVE 表示忽略大小写
		Pattern p = Pattern.compile("the", Pattern.CASE_INSENSITIVE);
		//提取每个单词
		//Pattern p = Pattern.compile("\\w+", Pattern.CASE_INSENSITIVE);
		//希望匹配字母带o的单词
		//Pattern p = Pattern.compile("\\w*o\\w*", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(s01);
		while (m.find() == true) {
			String sub = s01.substring(m.start(), m.end());
			System.out.println(sub + ", start=" + m.start() + ", end=" + m.end());
		}
		
		//把句子中的多个空格 替换成一个空格
		String s02 = "The   quick brown   fox  jumps    over the lazy dog.";
		String r = s02.replaceAll("\\s+", " ");
		System.out.println(r);
		//$1 表示反向引用
		String r2 = r.replaceAll("(\\w+)", "<b>$1</b>");
		System.out.println(r2);
	}
	
	public static boolean is19xx(String s) {
		//判断 19XX 年
		return s.matches("19\\d\\d");
		
	}
	
	//判断电话号码
	//前面的区号 必须以0开头
	//后面的电话号码 不能以0 开头
	public static boolean isValidTel(String s) {
		return s.matches("0\\d{2,3}\\-[1-9]\\d{5,7}");
		
	}
	
	//判断qq号
	// ^表示字符串开始  $表示字符串结束
	public static boolean isValidQQ(String s) {
		return s.matches("^[1-9]\\d{4,9}$");
	}
	
	public static int zeros(String s) {
		//正则表达式 默认的是贪婪匹配 
		// \d+ 会尽可能多的匹配 因此匹配到了整个字符串
		// 0* 匹配到的是 空字符串
		// 使用?表示对某一规则进行非贪婪匹配
		Pattern p = Pattern.compile("^\\d+?(0*)$");
		Matcher m = p.matcher(s);
		if (m.matches()) {
			String zeroStr = m.group(1);
			return zeroStr.length();
		}
		throw new IllegalArgumentException("Not a number");
	}
	

}

package com.regularX;

public class Xyc_regex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "1978";
		boolean x = is19xx(s);
		System.out.println(x);
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
	

}

package com.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Date_xyc {

	public static void main(String[] args) throws ParseException {
		// 获取系统当前时间戳
		System.out.println(System.currentTimeMillis());
		//获取当前时间
		Date nowDate = new Date();
		System.out.println(nowDate);
		System.out.println(nowDate.toString());
		System.out.println("toLocaleString : " + nowDate.toLocaleString());
		System.out.println("toGMTString :" + nowDate.toGMTString());
		
		//如何指定格式打印日期
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("指定格式打印 ：" + simpleDateFormat.format(nowDate));
		
		SimpleDateFormat simpleDateFormat02 = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss z ");
		System.out.println("指定格式打印 ：" + simpleDateFormat02.format(nowDate));
		
		
		//把date转化为long
		long t = nowDate.getTime();
		System.out.println(t);
		
		//将 string 转换成date对象
		// 按系统Locale解析日期时间：
		String s1 = "2016-11-20 12:15:59";
		Date date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(s1);
		System.out.println(date1);
		// 解析MMM时默认按照系统Locale:
		String s2 = "Nov/20/2016 12:15:59";
		//Nov的解析 需要传入local.us
		Date date2 = new SimpleDateFormat("MMM/dd/yyyy HH:mm:ss",Locale.US).parse(s2);
		System.out.println(date2);
		// 按ISO 8601标准格式解析：
		String iso = "2016-11-20T12:15:59";
		Date date3 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(iso);
		System.out.println(date3);
		
		System.out.println("=======================================================");
		
		//获取当前时间
		Calendar c = Calendar.getInstance();
		System.out.println(c.getTime());
		
		// 转换为Date打印：
		System.out.println(c.getTime());
		// + 5 days:
		c.add(Calendar.DAY_OF_MONTH, 5);
		// - 2 hours:
		c.add(Calendar.HOUR_OF_DAY, -2);
		// 转换为Date打印：
		System.out.println(c.getTime());
		
		//获取纽约时间
		c.setTimeZone(TimeZone.getTimeZone("America/New_York"));
		int y = c.get(Calendar.YEAR);
		int m = c.get(Calendar.MONTH) + 1;
		int d = c.get(Calendar.DAY_OF_MONTH);
		int hh = c.get(Calendar.HOUR_OF_DAY);
		int mm = c.get(Calendar.MINUTE);
		int ss = c.get(Calendar.SECOND);
		System.out.println(y + "-" + m + "-" + d + " " + hh + ":" + mm + ":" + ss);
		
		System.out.println("time zone" + c.getTimeZone());

	}

}

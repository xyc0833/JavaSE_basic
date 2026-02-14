package com.new_features;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class Lambda_xyc {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		String[] words = "Improving code with Lambda expressions in Java".split(" ");
		//这里是常规匿名类的写法
		Arrays.sort(words, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				// 忽略大小写排序:
				return s1.toLowerCase().compareTo(s2.toLowerCase());
			}
		});
		System.out.println(Arrays.toString(words));
		System.out.println("=======================");
		
		//采用lambda表达式的写法
		Arrays.sort(words,(s1,s2)->{
			return s1.toLowerCase().compareTo(s2.toLowerCase());
		});
		System.out.println(Arrays.toString(words));
		
		//反射复习
//	    Class<String> stringClass = String.class;
//	    Field field = stringClass.getDeclaredField("value");   //这里我们通过反射来获取String类中的value字段
//	    field.setAccessible(true);   //由于是private访问权限，所以我们修改一下
//	    System.out.println(field.get("ABCD"));
		
	}
	public static void hello(String str){   //现在我们要实现一个方法，将传入的字符串转换为小写并打印
	    System.out.println(str.toLowerCase());  //那太简单了吧，直接转换打印一气呵成
	}
	//我们少考虑了一个问题，万一给进来的str是null呢？
	public static void hello02(String str){
	    if(str != null) {
	        System.out.println(str.toLowerCase());
	    }
	}
	//我就想一行解决，这时，Optional来了，我们可以将任何的变量包装进Optional类中使用：
	public static void hello03(String str){
	    Optional
	            .ofNullable(str)   //将str包装进Optional
	            .ifPresent(s -> {   //ifPresent表示只有对象不为null才会执行里面的逻辑，实现一个Consumer（接受一个参数，返回值为void）
	                System.out.println(s);   
	            });
	}
	//结合 lambda表达式的进阶：双冒号代表 方法引用
	public static void hello04(String str){
	    Optional
	            .ofNullable(str)   //将str包装进Optional
	            .ifPresent(System.out::println);  
	  	//println也是接受一个String参数，返回void，所以这里使用我们前面提到的方法引用的写法
	}

}

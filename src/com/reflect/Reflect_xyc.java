package com.reflect;

public class Reflect_xyc {

	public static void main(String[] args) throws ClassNotFoundException {
		//获取到每个类对应的Class对象
	    Class<String> clazz = String.class;   //使用class关键字，通过类名获取
	    //使用Class类静态方法forName()，通过包名.类名获取，注意返回值是Class<?>
	    Class<?> clazz2 = Class.forName("java.lang.String");  
	    Class<?> clazz3 = new String("cpdd").getClass();  //通过实例对象获取
	    
	    System.out.println(clazz == clazz2);
	    System.out.println(clazz == clazz3);
	    //在JVM中每个类始终只存在一个Class对象，无论通过什么方法获取，都是一样的
	    
	    Class<String[]> calzz01 = String[].class;
	    System.out.println(calzz01.getName());//获取类名称（得到的是包名+类名的完整名称）
	    System.out.println(calzz01.getSimpleName());
	    System.out.println(calzz01.getTypeName());
	    System.out.println(calzz01.getClassLoader());//获取它的类加载器
	   // System.out.println(calzz01.cast(new Integer("10")));//强制类型转换
	    
	    String str = "";
	    System.out.println(str instanceof String);
	    //等价于
	    System.out.println(str.getClass() == String.class);

	}

}

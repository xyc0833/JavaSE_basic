package com.xyc;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Log_main {

	static Log log = LogFactory.getLog(Log_main.class);
	
	public static void main(String[] args) throws Exception {
		Logger logger = Logger.getGlobal();
		logger.info("xyc");
		log.info("xyc的 commons log");
		Person p = new Person("Xiao Ming", 0);
		System.out.println(p.hello());
		try {
			new Person();
		} catch (Exception e) {
			logger.log(Level.WARNING,"xycxyc",e);
			logger.log(Level.WARNING, "Create new person failed", e);
			log.error("exception",e);
		}
		logger.info("Program end.");
		
		Class cls = Person.class;
		System.out.println(cls.getName());
		System.out.println(cls.getSimpleName());
		System.out.println(cls.getPackage().getName());
		
		Person s = (Person)cls.newInstance();
		s.run();
		
		Person s01 = new Person();
		Class cls02 = s01.getClass();
		Field f = cls02.getField("age");
		//访问privated或者 protect的 字段
		Field f02 = cls02.getDeclaredField("name");
		printFieldInfo(f);
		s.hello();
		/**
		 * 反射在内部做的是：在 Person 类里，找一个方法名 = 
		 * setAddress参数类型列表 = (String)的方法
		 * */
		Method m = cls02.getMethod("setAddress", String.class);
		m.invoke(s01, "hangzhou");
		System.out.println(s01.getAddress());
		
		Class cls03 = Person.class;
		Constructor c = cls03.getDeclaredConstructor(String.class, int.class);
		printConstructorInfo(c);
		c.setAccessible(true);
		Person s02 = (Person) c.newInstance("Xiao Ming", 12);
		s.hello();
		
		Class cls04 = Person.class;
		printSuperClass(cls);
		
		@SuppressWarnings({ "rawtypes", "unused" })
		Class cls05 = Log_main.class;
		
		Person p1 = new Person("Xiao Ming", 25);
		Person p2 = new Person(null, 15);
		checkPerson(p1);
		checkPerson(p2);
	}
	//通过反射扫描字段 → 读取注解规则 → 自动执行校验，
	//从而避免在业务代码中大量编写重复的 if 判断
	
	
	// 校验 Person 对象是否合法
	// throws Exception：简化示例，真实项目中一般会抛自定义异常
	static void checkPerson(Person p) throws Exception {

	    // 打印当前正在校验的对象（方便调试）
	    System.out.println("check " + p + "...");

	    // 获取 Person 类的 Class 对象
	    // Class 对象相当于 Person 类在 JVM 中的“元信息描述”
	    Class c = Person.class;

	    // 获取 Person 类中所有 public 成员变量（字段）
	    // 每一个 Field 对象代表一个成员变量，比如 age、name
	    for (Field f : c.getFields()) {

	        // 对 Person 对象的每一个字段做统一校验
	        // 把“字段本身”和“对象实例”一起传进去
	        checkField(f, p);
	    }
	}


	// 校验某一个字段是否符合注解规则
	// f：字段本身（比如 age 字段）
	// p：字段所属的对象（Person 实例）
	static void checkField(Field f, Person p) throws Exception {

	    // ===================== 处理 @NotNull 注解 =====================

	    // 判断该字段上是否标注了 @NotNull 注解
	    if (f.isAnnotationPresent(NotNull.class)) {

	        // 通过反射，获取该字段在对象 p 中的实际值
	        // 等价于：p.age 或 p.name（但这里是通用写法）
	        Object r = f.get(p);

	        // 如果字段值为 null，说明违反了 @NotNull 约束
	        if (r == null) {
	            System.out.println(
	                "Error: field " + f.getName() + " is null."
	            );
	        }
	    }

	    // ===================== 处理 @Range 注解 =====================

	    // 判断该字段上是否标注了 @Range 注解
	    if (f.isAnnotationPresent(Range.class)) {

	        // 获取字段上的 @Range 注解实例
	        // 这样就能读到注解里定义的 min / max 值
	        Range range = f.getAnnotation(Range.class);

	        // 通过反射获取字段在对象 p 中的值
	        // 因为字段是 int 类型，所以需要做一次类型转换
	        int n = (Integer) f.get(p);

	        // 按照 @Range 注解中定义的规则进行校验
	        // 注意：规则不是写死的，而是来自注解
	        if (n < range.min() || n > range.max()) {
	            System.out.println(
	                "Error: field " + f.getName() + " is out of range."
	            );
	        }
	    }
	}
	
	static void chectField02(Field  f,Person p )throws Exception{
		//JVM 用 注解的 Class 对象 来判断“有没有贴这个注解”。
		if(f.isAnnotationPresent(NotNull.class)) {
			Object r = f.get(p);
			if(r == null) {
				System.out.println("Error field" + f.getName() + "is null ");
			}
		}
		if(f.isAnnotationPresent(Range.class)) {
			Range  range = f.getAnnotation(Range.class);
			int n = (Integer) f.get(p);
			if(n<range.min()|| n>range.max()) {
				System.out.println("Error field" + f.getName() + "is out of range");
			}
		}
	}

	
	static void printSuperClass(Class c) {
		System.out.print(c.getSimpleName());
		Class s = c.getSuperclass();
		if (s == null) {
			System.out.println();
		} else {
			System.out.print(" : ");
			printSuperClass(s);
		}
	}
	static void printConstructorInfo(Constructor c) {
		System.out.println(c);
		System.out.println("parameters: " + Arrays.toString(c.getParameterTypes()));
		System.out.println("modifier: " + c.getModifiers());
	}
	
	static void printFieldInfo(Field f) {
		System.out.println("field name: " + f.getName());
		System.out.println("field type: " + f.getType());
		System.out.println("field modifier: " + f.getModifiers());
		System.out.println("is public? " + Modifier.isPublic(f.getModifiers()));
		System.out.println("is protected? " + Modifier.isProtected(f.getModifiers()));
		System.out.println("is private? " + Modifier.isPrivate(f.getModifiers()));
		System.out.println("is static? " + Modifier.isStatic(f.getModifiers()));
		System.out.println("is final? " + Modifier.isFinal(f.getModifiers()));
	}

}

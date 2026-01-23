import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.*;
public class OOP_xyc {

	public static void main(String[] args)throws Exception{
		// TODO Auto-generated method stub
		// 类型 变量 = new 类型();
//		Person ming = new Person();
//		ming.setName("小明");
//		ming.setAge(12);
//
//		Person hong = new Person();
//		hong.setName("小红");
//		hong.setAge(15);
		Person ming = new Person("小明", 20);
		System.out.println(ming.getName());

		Person hong = new Person();
		System.out.println(hong.getName());

		System.out.println(ming.getName());
		System.out.println(ming.getAge());

		System.out.println(hong.getName());
		System.out.println(hong.getAge());
		
		Student s = new Student();
		s.run();
		
		Person psPerson = new Student();
		psPerson.run();
		
		Object o1 = psPerson;
		o1.hashCode();
		System.out.println(o1.hashCode());
		
		//instanceof 操作符 可以判断对象的类型
		System.out.println(ming instanceof Person);
		System.out.println(ming instanceof Student);
		
		System.out.println(ming);
		
		System.out.println(ming.getNumber());
		
		// 通过 Java 内省机制，获取 Person 类对应的 BeanInfo 对象
		// BeanInfo 中包含了该 JavaBean 的属性、方法、事件等信息
		BeanInfo bInfo = Introspector.getBeanInfo(Person.class);

		// 获取 Person 类中所有的属性描述器（PropertyDescriptor）
		// 每一个 PropertyDescriptor 对应一个 JavaBean 属性
		for (PropertyDescriptor pd : bInfo.getPropertyDescriptors()) {
		    // 打印当前属性的详细信息
		    printPropertyDescriptor(pd);
		}
	}
	/**
	 * 打印单个 PropertyDescriptor 的详细信息
	 * @param pd 属性描述器，描述了一个 JavaBean 属性
	 */
	static void printPropertyDescriptor(PropertyDescriptor pd) {

	    // 属性名，例如：name、age
	    String name = pd.getName();

	    // 属性的类型，例如：String、int
	    Class<?> clazz = pd.getPropertyType();

	    // 排除无效属性：
	    // 1. propertyType 为 null 的情况
	    // 2. JavaBean 默认会有一个名为 "class" 的属性（getClass 方法产生）
	    if (clazz == null || name.equals("class")) {
	        return;
	    }

	    // 获取该属性对应的 getter 方法
	    Method read = pd.getReadMethod();

	    // 获取该属性对应的 setter 方法
	    Method write = pd.getWriteMethod();

	    // 打印属性分隔标识
	    System.out.println("===== PropertyDescriptor =====");

	    // 打印属性名称
	    System.out.println("Name: " + name);

	    // 打印属性类型的全限定类名
	    System.out.println("Type: " + clazz.getName());

	    // 打印 getter 方法名（如果不存在则打印 null）
	    System.out.println("Read method: " + (read == null ? "null" : read.getName()));

	    // 打印 setter 方法名（如果不存在则打印 null）
	    System.out.println("Write method: " + (write == null ? "null" : write.getName()));
	}



}



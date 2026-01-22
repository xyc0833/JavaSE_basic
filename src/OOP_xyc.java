import java.util.*;
public class OOP_xyc {

	public static void main(String[] args) {
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
	}


}



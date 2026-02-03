package com.xyc;

import java.io.Serializable;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

//接口可以多继承
public class Person  implements Comparable<Person>,Serializable {

	
	private static final long serialVersionUID = 1116446341023698118L;
	private static int number;
	private String address = "beijing";
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	@NotNull
	protected String name;
	@Range(max = 20)
	public int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		number = number+1;
	}
	public Person() {
		this.name = "unnamed";
		this.age = 17;
		number++;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	

	public void setName(String firstName, String lastName) {
		this.name = firstName + " " + lastName;
	}

	public void run() {
		System.out.println(name + " is running!");
	}
	public String hello() {
		return "hello"+ name;
	}
	
	public static int getNumber() {
		return number;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public int hashCode() {
		return Objects.hash(this.address, this.age, this.name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(address, other.address) && age == other.age && Objects.equals(name, other.name);
	}
	@Override
	public int compareTo(Person o) {
		//按照name字段排序
		return this.name.compareTo(o.name);
	}
	
	
	
//	public boolean equals(Object o) {
//		if(this == o) {
//			return true;
//		}
//		//instanceof 判断它是否属于Person类
//		//判断一个对象在运行时，是否属于某个类或其子类 / 实现了某个接口
//		if(o instanceof Person) {
//			Person person = (Person) o;
//			//equals：比较内容是不是一样
////			if (this.name.equals(person.name) && this.age == person.age) {
////				return true;
////			}
//			//上面的代码不对 还要先去判断 this.name 是否为空
//			if (Objects.equals(this.name, person.name) && this.age == person.age) {
//				return true;
//			}
//			/***
//			 * 一、先给结论（最重要）
//				Objects.equals(a, b) = 带判空的 a.equals(b)
//				✔ 会处理 null
//				✔ 不会抛 NullPointerException
//				✔ 官方推荐写法（JDK 7+）
//			 */
//			
//		}
//		
//		return false;
//	}
	/***
	 * String name1 = new String("Tom");
		String name2 = new String("Tom");
		
	内存中是这样：

	name1 ──▶ "Tom" (对象A)
	name2 ──▶ "Tom" (对象B)
	虽然内容一样，但不是同一个对象

	name1 == name2        // false ❌
	name1.equals(name2)  // true  ✅
	 */

}


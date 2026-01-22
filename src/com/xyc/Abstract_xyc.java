package com.xyc;
import static java.lang.System.out;

public class Abstract_xyc {
	public static void main(String[] args) {
		Shape s1 = new Rect(12, 15);
		Shape s2 = new Circle(3.4);
		
		System.out.println(s1.area());
		System.out.println(s2.area());
		
		Hello h = new Hello("World");
		
		out.println(h.hello());
	}
}


class Hello {

	private final String name;

	public Hello(String name) {
		this.name = name;
	}

	public String hello() {
		return "Hello, " + name + "!";
	}
}
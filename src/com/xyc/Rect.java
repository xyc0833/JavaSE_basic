package com.xyc01;

public class Rect extends Shape{
	private final double width;
	private final double height;
	
	public Rect(double width, double height) {
		super();
		this.width = width;
		this.height = height;
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return width * height;
	}
	
}

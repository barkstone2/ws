package com.shape;

public class Rectangle extends Shape{
	
	double width;
	double height;
	
	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public Rectangle() {
		this(0,0);
	}
	
	public boolean isSquare() {
		return true;
	}
	
	
	
	@Override
	double calcArea() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}

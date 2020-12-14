package com.shape;

abstract class Shape {
	Point p;

	public Shape() {
		this(new Point(0,0));
	}
	
	
	public Shape(Point p) {
		this.p = p;
	}
	
	abstract double calcArea();
	
	Point getPosition() {
		return p;
	}
	
	void setPosition(Point p) {
		this.p = p;
	}
		
}

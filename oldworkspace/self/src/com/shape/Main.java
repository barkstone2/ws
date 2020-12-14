package com.shape;


public class Main {
	public static void main(String[] args) {
		
		Outer o = new Outer();
		Outer.Inner inner = o.new Inner();
		
		
		inner.method1();
	}
}

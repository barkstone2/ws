package com.day17;

public class Product {
	
	String name;
	int price;
	
	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return name + "\t" + price;
	}
	
}

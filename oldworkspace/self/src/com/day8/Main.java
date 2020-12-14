package com.day8;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Box<Fruit> fruitBox = new Box<Fruit>();
		
		fruitBox.add(new Fruit());
		fruitBox.add(new Fruit());
		fruitBox.add(new Fruit());
		System.out.println(fruitBox.get(0));
		System.out.println(fruitBox);
		
	}

}

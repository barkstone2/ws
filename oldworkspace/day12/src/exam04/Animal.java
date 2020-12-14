package exam04;

public class Animal {
	String name;
	int age;
	
	
	public Animal() {
	}
	
	public Animal(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void sound() {
		
	}
	
	public void display() {
		System.out.println(name + " / "+age);
	}
	
	
}

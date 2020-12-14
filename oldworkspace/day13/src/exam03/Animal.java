package exam03;

public abstract class Animal {
	public abstract void sound(); // 추상메소드
	
	public void display() {
		System.out.println("animal display");
	}
	
	public Animal() {
		System.out.println("-- Animal() --");
	}
	
}

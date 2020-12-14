package exam03;

public class Dog extends Animal {
	
	
	@Override
	public void sound() {
		System.out.println("dog sound");
	}
	
	public Dog() {
		System.out.println("-- Dog() --");
	}
	
}

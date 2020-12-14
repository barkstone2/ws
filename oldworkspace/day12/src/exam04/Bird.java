package exam04;

public class Bird extends Animal{
	public Bird(String name, int age) {
		super(name,age);
	}
	
	@Override
	public void sound() {
		System.out.println("-- 짹짹 --");;
	}
}

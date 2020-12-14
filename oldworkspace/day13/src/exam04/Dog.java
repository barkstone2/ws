package exam04;

public class Dog implements Animal {

	@Override
	public void sound() {
		System.out.println("-- 멍멍 --");
	}

	@Override
	public void disp() {
		System.out.println("-- 개 --");
	}

	
	
}

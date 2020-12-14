package exam04;

public class Pig implements Animal {

	@Override
	public void sound() {
		System.out.println("-- 꿀꿀 --");
	}

	@Override
	public void disp() {
		System.out.println("-- 돼지 --");
	}

}

package exam04;

public class Cat implements Animal {

	@Override
	public void sound() {
		System.out.println("-- 야옹 --");
	}

	@Override
	public void disp() {
		System.out.println("-- 고양이 --");
	}

}

package exam02;

class MyClass {
	int x = 50;
}

public class ClassTest02 {

	public static void main(String[] args) {

		MyClass mc = new MyClass();

		System.out.println(mc.x);

		mc.x = 100;
		
		System.out.println(mc.x);

	}

}

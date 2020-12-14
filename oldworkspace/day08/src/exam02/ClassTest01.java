package exam02;

public class ClassTest01 {
	// Member Field - 클래스에 포함된 변수

	static int x = 10;
	int y = 20;

	public static void main(String[] args) {
		ClassTest01 c1 = new ClassTest01(); // 객체, 인스턴스
		System.out.println(c1.x);
		System.out.println(c1.y);

		c1.x = 100;
		System.out.println(c1.x);

		c1.y = 200;
		System.out.println(c1.y);

		ClassTest01 c2 = new ClassTest01();
		System.out.println(c2.x);
		System.out.println(c2.y);

		ClassTest01 c3 = new ClassTest01();
		System.out.println(c3.x);
		System.out.println(c3.y);

	}

}

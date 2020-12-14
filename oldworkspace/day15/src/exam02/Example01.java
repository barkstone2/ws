package exam02;

public class Example01 {
	public static void main(String[] args) {
		InterfaceA ia; // 자동형변환

		ia = (a, b) -> a + b;

		int result = ia.method01(3, 5);
		System.out.println(result);

	}
}

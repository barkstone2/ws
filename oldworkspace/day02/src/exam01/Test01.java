package exam01;

public class Test01 {
	
	public static void main(String[] args) { //실행과 관련있음.
		//부호가 나온 이후부터 그 줄 전체가 주석처리된다.
		/* 범위를 지정하고, 그 범위의 내용은 주석처리 된다. */
		//화면출력 - print, println, printf
		
//		System.out.print("안녕");
//		System.out.println("안녕");
//		System.out.printf("%d %f %c %s", 10, 3.14, 'A', "안녕");
		
		//변수와 자료형
		
		byte a = 1;
		System.out.println("a의 값은 " + a + "입니다.");
		
		
		byte b = 1; // -128 ~ 127
		System.out.println("b의 값은 " + b + "입니다.");
		System.out.println(Byte.MIN_VALUE + " ~ " + Byte.MAX_VALUE);
		
		
		short s = 1; // -32768 ~ 32767
		System.out.println("s의 값은 " + s + "입니다.");
		System.out.println(Short.MIN_VALUE + " ~ " + Short.MAX_VALUE);
		
		
		int i = 1;  // -2147483648 ~ 2147483647
		System.out.println("i의 값은 " + i + "입니다.");
		System.out.println(Integer.MIN_VALUE + " ~ " + Integer.MAX_VALUE);
		
		
		long l = 1L; // -9223372036854775808 ~ 9223372036854775807
		System.out.println("l의 값은 " + l + "입니다.");
		System.out.println(Long.MIN_VALUE + " ~ " + Long.MAX_VALUE);
		
		
		System.out.println(s - i);
	
		
		
		//실수타입 : float, double
		
		float f = 3.14f; // -126 ~ 3.4028235E38
		System.out.println("f의 값은 " + f + "입니다.");
		System.out.println(Float.MIN_EXPONENT + " ~ " + Float.MAX_VALUE);
		
		double d = 3.14;
		System.out.println("d의 값은 " + d + "입니다.");
		
		System.out.println(d - f);
		
		//계산을 할 때는 데이터 타입을 동일하게 맞춰야 한다.
		
		
//		char c = 'a'; //유니코드 타입의 값
//		System.out.println("c의 값은 " + c + "입니다.");
//		c = 65;
//		System.out.println("c의 값은 " + c + "입니다.");
		
		
		
	}
	
}
//가독성
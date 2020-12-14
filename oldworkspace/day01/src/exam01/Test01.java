package exam01;

public class Test01 {
	
	public static void main(String[] args) {
		//변수 - 기본형변수(primitive type) - 8개, 참조형 변수(reference type)
		/*
		  	정수형 : byte(1byte), short(2byte), int(4byte), long(8byte)
		  	실수형 : float(4byte), double(8byte)
		  	문자형 : char(2byte) - unsigned(음수가 없다)
		  	논리형 : boolean(1byte)
		 */
		
		//int - 자료형, 데이터타입
		//number - 변수명, 개발자가 만든다.
		//= ==> 대입 연산자
		//5 : 값
		int number = 5;
		System.out.println(number);
		number = 10;
		System.out.println(number);
		number = 50;
		System.out.println(number);
		
		
		//변수 선언 및 초기화
		//int su = 100;
		int su; //변수 선언
		su = 100;
		System.out.println(su);
		
		int num1 = 20 + 70; //90
		
		//---------------------------------------------------------
		
		//int a1, a2, a3;
		int a1;
		int a2;
		int a3;
		
		byte a = 127;
		short b = 1000;
		int c = 1000;
		long d = 1000L;
		float f;
		double e;
		
		f = (float)Math.PI;
		System.out.println(f);
		e = Math.PI;
		System.out.println(e);
		
		int g = (int)(Math.random()*10+1);
		System.out.println(g);
		
	
		char[] arrr = new char[] {'a', 'b', 'c', 'd', 'e'};
		String list = "";
		
		for (int i=0; i< arrr.length; i++) {
			list += arrr[i];
		}
		
		System.out.println(list);
		
		//자동형변환(Promotion) : 작은 범위의 값을 더 큰 범위의 자료형에 집어넣을 때 자동으로 들어감
		//강제형변환(Casting) : 큰 범위의 값을 작은 범위의 자료형에 넣을려니 안들어가더라.
		//					그래서 강제로 작은 범위 자료형으로 바꾸어 넣어준다.
		
		int j1 = 30;
		int j2 = 50;
		System.out.println(j1 + j2); //80
		
		int j3 = j1 + j2;
		System.out.println(j3);
		
		int j4 = j1 - j2;
		System.out.println(j4);
		
		int j5 = j1 * j2; // 곱하기
		System.out.println(j5);
		
		j1 = 7;
		j2 = 2;
		int j6 = j1 / j2; // / -> 나누기
		System.out.println(j6);
				
		//정수와 정수의 연산 결과는 정수가 나온다.
		
		int j7 = j1 % j2;
		System.out.println(j7); // 나머지
		
//		산술연산자
//		+
//		-
//		*
//		/
//		%
		
		String str1 = "대한";
		System.out.println(str1);
		
		String str2 = "민국";
		System.out.println(str2);
		
		System.out.println(str1 + str2); // 문자열 + 문자열 => 나열된다.
		
		str1 = "6";
		str2 = "7";
		System.out.println(str1 + str2); // 67
		
		int nu1 = 2;
		
		//문자열 연산
		System.out.println(str1 + str2 + nu1); // 문자열 + 문자열 + 숫자(자동으로 문자열로 바귄다.)
		
		
		//변수 - 개발자 마음대로 만들면 된다.
		//자료형 변수 이름 = 값 또는 식;
		//변수 이름의 첫 글자는 숫자허용X
		//변수 이름의  첫 글자는 영어대문자 또는 소문자
		//특수 문자는 $, _
		//
		
		String $name = "홍길동";
		String _name = "홍길동";
		String n1a2m3e5 = "홍길동";
//		String n b = "홍길동"; //공백 X
//		String for = "홍길동"; //자바 예약어 X
		
		
		
		
		Calculator cal = new Calculator();
				
		while(cal.exit!=1) {
			cal.command();
			switch (cal.sc.nextInt()) {
			case 1:
				cal.add();
				continue;
			case 2:
				cal.sub();
				continue;
			case 3:
				cal.multi();
				continue;
			default:
				System.out.println("종료");
				cal.exit = 1;
				break;
			}
		}
		
		
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}

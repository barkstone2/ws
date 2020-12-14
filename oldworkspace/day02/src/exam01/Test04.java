package exam01;

public class Test04 {
	
	public static void main(String[] args) {
		//형변환  : 자동형변환(Promotion), 강제형변환(Casting)
		//		묵시형형변환			명시적형변환
		
		//하나의 타입을 다른 타입으로 바꾸는 것.
		//상대적으로 작은 타입에서 큰 타입으로의 타입 변환은 생략할 수  있습니다.
		//큰 타입에서 작은 타입으로의 타입 변환은 데이터의 손실이 발생합니다.
		
//		int intValue = 7;
//		double doubleValue = 3.0F;
//		doubleValue = intValue; //자동형변환(Promotion)
//		System.out.println(doubleValue);
		
//		double dValue1 = 8.53;
//		int iValue1 = 5;
//		iValue1 = (int)dValue1;
//		System.out.println(iValue1);
		
//		short a1 = 120;
//		int b1 = a1;
		
//		byte a2 = 120;
//		short b2 = a2;
		
//		byte a3 = 120; //1byte = 8bit
//		char b3 = a3; //2byte = 16bit, unsigned = 양수만 (0을 포함)
/*		
		int i1 = 120;
		byte b1 = (byte)i1;
		System.out.println(b1);
		
		int a = 130;
		byte b = (byte)a;
		System.out.println(b);
*/
//		long a = 123L;
		
		float a = 123;
		
		int fahrenheit = 100;
		float celcius = (int)((5/9f * (fahrenheit - 32))*100 + 0.5) / 100f;
		System.out.println(celcius);
	}
}

package exam01;

public class Test03 {
	
	public static void main(String[] args) {
		//String : 문자열
		String insa = "Welcome to my site !!!";
		System.out.println(insa);
		
		insa = "안녕하세요?";
		System.out.println(insa);
		
		insa = "9 * 3 + 2 - 8";
		System.out.println(insa);
		
		//함수, 메소드
		String alpabet = "abcdefghijklmnopqrstuvwxyz";
		System.out.println("alpabet 변수의 값의 길이는 " + alpabet.length() + "입니다.");
		
//		int i = 1234567890;
//		System.out.println(i.length());
		
		String txt = "Welcome to my site !!!";
//		System.out.println(txt.toUpperCase());
//		String imsi = txt.toUpperCase();
//		System.out.println(imsi);
//		
//		System.out.println(txt.toLowerCase());
//		imsi = txt.toLowerCase();
//		System.out.println(imsi);
		
		
		//index(인덱스) - 위치값, 0부터 시작한다.
//		System.out.println(txt.indexOf("to")); // 8을 리턴한다.
		
//		System.out.println(txt.length()); //22
		
		String memo1 = "Hong's site !!!";
		System.out.println(memo1);
		
		String memo3 = "나의 고향은 '대구'이며,\n회사는 \t경기도입니다.";
		System.out.println(memo3);
		
		
		/*	이스케이프 문자
		 	>>	\' (작은 따옴표)
		 	>>	\" (큰 따옴표)
		 	>>	\\ (역 슬래쉬)
		 	>>	\n (줄 바꿈)
		 	>>	\t (탭)
		*/
		
		
		
		String firstName = "hong";
		String lastName = "kildong";
		System.out.println(firstName + "\n" + lastName); //문자열 연산
		
		
		System.out.println(firstName.concat(lastName));
		
		String result = firstName + " " + lastName;
		System.out.println(result);
	
		
		
		
		
	} // main end
	
} // Test03 class end

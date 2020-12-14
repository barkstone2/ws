package exam01;

import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) {
		//입력 : 이름과 출생년도
		//출력 : 이름, 나이
		
		String name;
		int birthYear;
		int nowYear = 2020;
//		
		Scanner sc = new Scanner(System.in);
		
		//입력
		System.out.print("이름을 입력하세요\n>>");
		name = sc.nextLine();
		
		System.out.print("출생년도를 입력하세요\n>>");
		birthYear = sc.nextInt();
		
		sc.close();
		
		System.out.println();
		
		//처리
		int age = nowYear - birthYear + 1;
		
		//출력
		System.out.printf("%s님의 나이는 %d살 입니다.", name, age);
		
		//문자열을 제외한 데이터를 입력 받은 후
		//nextLine() 메소드가 실행되면 키보드 버퍼의 엔터키를 읽어들이는 문제가 발생한다.
		
		//입력
		//처리
		//출력
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}

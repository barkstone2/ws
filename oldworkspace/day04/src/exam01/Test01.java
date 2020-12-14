package exam01;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		
		//윤년 4년마다 돌아옴, 100으로 나누어 떨어지면 평년
				//400으로 나누어 떨어지면 윤년
				
				//입력 : 연도
				//출력 : 연도의 윤년 여부
				
				
				int inputYear;
				
				Scanner sc = new Scanner(System.in);
				
				System.out.print("연도를 입력하세요>>");
				inputYear = sc.nextInt();
				
				if(inputYear%4 == 0 && inputYear%100 != 0) {
					System.out.println(inputYear + "년은 윤년입니다.");
				}else if(inputYear%400 == 0) {
					System.out.println(inputYear + "년은 윤년입니다.");
				}else {
					System.out.println(inputYear + "년은 윤년이 아닙니다.");
				}
		
	}
}

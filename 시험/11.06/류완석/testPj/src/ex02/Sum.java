package ex02;

import java.util.Scanner;

public class Sum {
	public static void main(String[] args) {
		
		int result = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요>>");
		try {
			int input = sc.nextInt();
			if(input==0) {
				throw new Exception();
			}
			for(int i=1; i<=input; i++) {
				result += i;
			}
			System.out.println("1부터 "+input+"까지의 합 : "+result);
			
		}catch(Exception e) {
			System.out.println("0보다 큰 정수를 입력해야 합니다.");
		}
		
		
	}
}

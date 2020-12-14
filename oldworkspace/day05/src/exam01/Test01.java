package exam01;

import java.util.Scanner;

public class Test01 {
	
	public static void main(String[] args) {
		//반복문 : for, while, do ~ while
		
//		int i=0;
//		while(i<5) {
//			System.out.println("i의 값은 " + i + "입니다.");
//			i++;
//		}
		
//		int i =1;
//		while(true) {
//			System.out.println(i);
//			
//			if(i>=10) {
//				break;
//			}
//			i++;
//		}
		
		//입력 : 정수한개
		//출력 : 1~입력한 정수까지의 합
		//1~정수까지 짝수의 합
		//1~정수까지 홀수의 합
		
//		int input;
//		int sum = 0;
//		int eSum = 0;
//		int oSum = 0;
//		
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.print("단수를 입력하세요>>");
//		input = sc.nextInt();
//		
//		for(int i=1; i<=input; i++) {
//			sum += i;
//			if(i%2==0) {
//				eSum+=i;
//			}else {
//				oSum+=i;
//			}//if end
//		}//for end
//		
//		System.out.println("1부터 " + input +"까지의 합 = " + sum);
//		System.out.println("1부터 " + input +"까지의 짝수의 합 = " + eSum);
//		System.out.println("1부터 " + input +"까지의 홀수의 합 = " + oSum);
//		
//		int j=1;
//		while(j<=input) {
//			sum += j;
//			if(j%2==0) {
//				eSum+=j;
//			}else {
//				oSum+=j;
//			}//if end
//			j++;
//		}
//		
//		System.out.println("1부터 " + input +"까지의 합 = " + sum);
//		System.out.println("1부터 " + input +"까지의 짝수의 합 = " + eSum);
//		System.out.println("1부터 " + input +"까지의 홀수의 합 = " + oSum);
		
		
		Scanner sc = new Scanner(System.in);
		
//		do {
//			
//			System.out.print("단수를 입력하세요>>");
//			int input = sc.nextInt();
//			sc.nextLine();
//			
//				for(int j=1; j<10; j++) {
//					System.out.println(input+" * "+j+" = "+input*j);
//				}
//			
//			System.out.print("계속 하시려면 \'y\'를 입력하세요>>");
//			String com = sc.nextLine();
//			
//			if(com.equalsIgnoreCase("Y")) {
//				continue;
//			}else {
//				System.out.println("종료");
//				break;
//			}
//			
//		}while(true);
		
		
		while(true) {
			System.out.print("단수를 입력하세요>>");
			int input = sc.nextInt();
			sc.nextLine();
			
				for(int j=1; j<10; j++) {
					System.out.println(input+" * "+j+" = "+input*j);
				}
			
			System.out.print("계속 하시려면 \'y\'를 입력하세요>>");
			String com = sc.nextLine();
			
			if(com.equalsIgnoreCase("Y")) {
				continue;
			}else {
				System.out.println("종료");
				break;
			}
			
		}
		
		
		
		
		
		
		
		
		
		
		
	}// main Method end
	
	
	
}

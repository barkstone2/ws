package exam01;

import java.util.ArrayList;
import java.util.Scanner;

public class Test05 {
	//멤버 메소드
	
	
	public static void main(String[] args) {
		
		
		
		
		
		
		
		
//		Scanner sc = new Scanner(System.in);
//		System.out.print("원하는 단 수를 입력하세요>>");
//		int dan = sc.nextInt();
//		
//		new Test05().gugudan(dan);
		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("입력을 종료하려면 상품 이름에 Q를 입력하세요.");
//		
//		while(true) {
//			System.out.println("상품 이름을 입력하세요.");
//			System.out.print(">>");
//			String inputName = sc.next();
//			
//			if(inputName.equalsIgnoreCase("Q")) {
//				System.out.println("입력을 종료합니다.");
//				break;
//			}
//			
//			System.out.println("상품 가격을 입력하세요.");
//			System.out.print(">>");
//			int inputPrice = sc.nextInt();
//			
//			new Test05().receipt(inputName, inputPrice);
//		}
		
		//입력 : 두 수를 입력 받아서
		//출력 : 두 수에 대한 사칙 연산
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫 번째 수를 입력하세요>>");
		int firstNum = sc.nextInt();
		
		System.out.print("두 번째 수를 입력하세요>>");
		int secondNum = sc.nextInt(); 
		
		new Test05().doCal(firstNum, secondNum);
		
		
	}
	
	
	void gugudan(int dan) {
		for (int i=1; i<10; i++) {
			System.out.printf("%d * %d = %d\n", dan, i, dan*i);
		}
	}
	
	void receipt(String pName, int price) {
//		ArrayList list = new ArrayList();
		System.out.printf("입력한 상품은 %s이며, 가격은 %d원 입니다.\n",pName,price);
	}
	
	void doCal(int a, int b) {
		if(b==0) {
			System.out.println("0으로 나눌 수 없습니다.");
			return;
		}
		System.out.printf("%d + %d = %d\n",a,b,(a+b));
		System.out.printf("%d - %d = %d\n",a,b,(a-b));
		System.out.printf("%d * %d = %d\n",a,b,(a*b));
		System.out.printf("%d / %d = %.2f\n",a,b,((float)a/b));
		System.out.printf("%d %% %d = %d\n",a,b,(a%b));
	}	
	
	
	//입력:상품이름,상품가격
	//상품이름............상품가격
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	static void insa() {
		System.out.println("홍길동");
		System.out.println("안녕하세요?");
	}
	
	static void insa2(String name) {
		System.out.println(name + "님 안녕하세요.");
		
	}
	
	static void insa3(int kor, int eng, int math) {
		int total = kor + eng + math;
		double avg = total / 3.0;
		System.out.println("총점은 " + total + "입니다.");
		System.out.println("평균은 "+avg+"입니다.");
	}
	
	
	
	
}

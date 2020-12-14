package exam01;

import java.util.Scanner;

public class Test01 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		do{
			System.out.println("------------------");
			System.out.println("0:종료, 1:목록, 2:등록");
			System.out.println("------------------");
			System.out.print("선택하세요:");
			int cmd = sc.nextInt();
			
			if(cmd == 0) {
				break;
			}else if(cmd == 1) {
				System.out.println("--목록--");
				System.out.println();
			}else if(cmd ==2) {
				System.out.println("--등록--");
				System.out.println();
			}
			
		}while(true);
		System.out.println();
		System.out.println("--프로그램 종료--");
		
	}
	
	
}

package exam01;

import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) {
		//입력 : 이름, 월급, 보너스()
		//출력 : 이름, 월급, 보너스(%), 총연봉
		
		Scanner sc = new Scanner(System.in);
		
		String name;
		int salary;
		int bonusPer;
		int total;
		int bonus;
		char percent = '%';
		
		//---- 입력 ----
		System.out.print("이름을 입력하세요>>");
		name = sc.nextLine();
		System.out.print("월급을 입력하세요>>");
		salary = sc.nextInt();
		System.out.print("보너스 퍼센트를 입력하세요>>");
		bonusPer = sc.nextInt();
		
		//---- 처리 ----
		bonus = salary * bonusPer/100;
		total = salary * 12 + bonus;
		
		//---- 출력 ----
		System.out.printf("%s님의 월급은 %d원이고 %d%c의 보너스를 받습니다.\n보너스 금액은 %d원이며 총 연봉은 %d원입니다.",
				name, salary, bonusPer, percent, bonus, total);
		
		
		
	}
}

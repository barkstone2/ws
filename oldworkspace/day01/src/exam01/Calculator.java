package exam01;

import java.util.Scanner;

public class Calculator {
	public Calculator() {
	}
	
	int exit = 0;
	Scanner sc = new Scanner(System.in);
	
	public void command() {
		System.out.println("실행할 명령에 해당하는 숫자를 입력하세요.");
		System.out.println("1.덧셈 2.뺄셈 3.곱셈 4.종료");
		System.out.println(">>");
	}
	
	public void add() {
		System.out.println("첫 번째 숫자를 입력하세요.");
		System.out.println(">>");
		int pval1 = sc.nextInt();
		System.out.println("두 번째 숫자를 입력하세요.");
		System.out.println(">>");
		int pval2 = sc.nextInt();
		int sum = pval1 + pval2;
		System.out.println(pval1+ " + "+ pval2 +" = " + sum);
	}
	
	public void sub() {
		System.out.println("첫 번째 숫자를 입력하세요.");
		System.out.println(">>");
		int sval1 = sc.nextInt();
		System.out.println("두 번째 숫자를 입력하세요.");
		System.out.println(">>");
		int sval2 = sc.nextInt();
		int sub = sval1 - sval2;
		System.out.println(sval1+ " - "+ sval2 +" = " + sub);
	}
	
	public void multi() {
		System.out.println("첫 번째 숫자를 입력하세요.");
		System.out.println(">>");
		int mval1 = sc.nextInt();
		System.out.println("두 번째 숫자를 입력하세요.");
		System.out.println(">>");
		int mval2 = sc.nextInt();
		int mul = mval1 * mval2;
		System.out.println(mval1+ " * "+ mval2 +" = " + mul);

		}
	
}

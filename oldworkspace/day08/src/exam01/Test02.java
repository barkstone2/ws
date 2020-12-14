package exam01;

import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) {
		// 입력 : 정수 n
		// 출력 : 1~n까지의 합

		new Test02().sumTo();

	}

	void sumTo() {

		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요>>");

		int input = 0;
		try {
			input = sc.nextInt();
		} catch (Exception e) {
			System.out.println("정수를 입력해야 합니다.");
			sumTo();
			return;
		}

		int total = 0;
		for (int i = 1; i < input + 1; i++) {
			total += i;
		}
		printSum(input, total);

	}

	void printSum(int input, int total) {
		System.out.println("=======================");
		System.out.println("1부터 " + input + "까지의 합계 : " + total);
		System.out.println("=======================");

	}

}

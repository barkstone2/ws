package exam01;

import java.util.Scanner;

public class Test04 {
	public static void main(String[] args) {
		
		
//		int a = 5;
//		int b = 3;
//		String c = "5";
//		boolean bo = true;
//		
//		
//		if (a == 5) {
//			System.out.println("1");
//		}
//		System.out.println("2");
//		
//		
//		if(bo == true) {
//			System.out.println("5");
//		}
//		
//		if(c.equals("5")) {
//			System.out.println("3");
//		} else {
//			System.out.println("4");
//		}
//		
//		
//		if(a > 3 && a > 9) {
//			System.out.println("T");
//		} else {
//			System.out.println("F");
//		}
//		
//		
//		
//		
//		System.out.println("-- 프로그램 종료 --");
//		
////		int aa = 1;
////		
////		String ab = (aa == 1 || aa == 3 ? "남자" : "여자");
//		
//		
//		int n = 73;
//		if(n>= 90) {
//			System.out.println("1");
//		} else if(n>=80) {
//			System.out.println("2");
//		} else if(n>=70) {
//			System.out.println("3");
//		} else {
//			System.out.println("4");
//		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//입력 : 이름, 주민번호
		//출력 : 이름, 주민번호, 성별, 나이
		//index : 위치값, 0부터 시작
		//indexOf("a") a와 일치하는 위치 반환
		
		
//		String memo = "Welcom to my site";
//		String imsi = memo.substring(3);
//		System.out.println(imsi);
//		
//		int loc= memo.indexOf("1");
//		System.out.println(loc);
		
		
	
		
//		Scanner sc = new Scanner(System.in);
//		
//		String name;
//		String regNo;
//		String gender ="";
//		String genderCode;
//		int age;
//		int bornYear = 0;
//		int nowYear = 2020;
//		int bornCode = 0;
//		System.out.print("이름을 입력하세요>>");
//		name = sc.nextLine();
//		
//		System.out.print("주민번호를 입력하세요>>");
//		regNo = sc.nextLine();
//		
//		
//		genderCode = regNo.substring(7, 8); // substring으로도 가능
//		
//		if(genderCode.equals("1") || genderCode.equals("3")) {
//			gender = "남자";
//			
//		} else if(genderCode.equals("2") || genderCode.equals("4")) {
//			gender = "여자";
//			
//		} else {
//			System.out.println("잘못된 주민번호 입니다.");
//		}
//		
//		
//		
//		bornCode = Integer.parseInt(regNo.substring(0,2));
//		
//		if(genderCode.equals("1") || genderCode.equals("2")) {
//			bornYear = 1900;
//			
//		} else if(genderCode.equals("3") || genderCode.equals("4")) {
//			bornYear = 2000;
//			
//		} else {
//			System.out.println("잘못된 주민번호 입니다.");
//		}
//		
//		bornYear += bornCode;
//		
////		gc.equals("1"); //1(true) 반환
////		genderCode = regNo.charAt(7)-'0'; // char - '0' -> int형 변환
//		
//		age = nowYear - bornYear + 1;
//		
//		System.out.printf("%s님의 주민번호는 %s이며 성별은 %s이고 나이는 %d입니다.",
//				name, regNo, gender, age);
		
		
		//입력 : 이름, 국어, 영어, 수학
		//출력 :
		/*
	===============================
	이름	국어	영어	수학	총점	평균
	==============================
	홍길동 90 90 90 270 90
	=============================


		 */
		
//		Scanner sc = new Scanner(System.in);
//		
//		String name;
//		int kScore;
//		int eScore;
//		int mScore;
//		int total;
//		int avg;
//		String grade;
//		
//		System.out.print("이름을 입력하세요>>");
//		name = sc.nextLine();
//		
//		System.out.print("국어 점수를 입력하세요>>");
//		kScore = sc.nextInt();
//		
//		System.out.print("영어 점수를 입력하세요>>");
//		eScore = sc.nextInt();
//		
//		System.out.print("수학 점수를 입력하세요>>");
//		mScore = sc.nextInt();
//		
//		total = kScore + eScore + mScore;
//		avg = total / 3;
//		
//		
//		if(avg>=90) {
//			grade = "수";
//		}else if(avg>=80) {
//			grade = "우";
//		}else if(avg>=70) {
//			grade = "미";
//		}else if(avg>=60) {
//			grade = "양";
//		}else {
//			grade = "가";
//		}
//		
//		
//		System.out.println("=======================================================");
//		System.out.println("이름	국어	영어	수학	총점	평균	등급");
//		System.out.println("=======================================================");
//		System.out.printf("%s	%d	%d	%d	%d	%d	%s\n", name, kScore, eScore, mScore, total, avg, grade);
//		System.out.println("=======================================================");
//		
//		
//		switch ((int)(avg/10)) {
//		case 1:
//			System.out.println("1");
//			break;
//		case 2:
//			System.out.println("2");
//			break;
//		case 3:
//			System.out.println("3");
//			break;
//		default:
//			System.out.println("4");
//			break;
//		}
		
		
		//계산기
		//입력 : 두 수, add, sub, mul, div
		
		
//		Scanner sc = new Scanner(System.in);
//		
//		int num1;
//		int num2;
//		int tmp;
//		String cmd;
//		
//		System.out.print("명령어를 입력하세요. (add, sub, mul, div)\n");
//		System.out.println(">>");
//		cmd = sc.nextLine();
//		
//		switch (cmd) {
//		case "add":
//			System.out.print("첫 번째 수를 입력하세요>>");
//			num1 = sc.nextInt();
//			System.out.print("두 번째 수를 입력하세요>>");
//			num2 = sc.nextInt();
//			tmp = num1 + num2;
//			System.out.println(num1 + " + " + num2 + " = " + tmp + "입니다.");
//			break;
//			
//		case "sub":
//			System.out.print("첫 번째 수를 입력하세요>>");
//			num1 = sc.nextInt();
//			System.out.print("두 번째 수를 입력하세요>>");
//			num2 = sc.nextInt();
//			tmp = num1 - num2;
//			System.out.println(num1 + " - " + num2 + " = " + tmp + "입니다.");
//			break;
//			
//		case "mul":
//			System.out.print("첫 번째 수를 입력하세요>>");
//			num1 = sc.nextInt();
//			System.out.print("두 번째 수를 입력하세요>>");
//			num2 = sc.nextInt();
//			tmp = num1 * num2;
//			System.out.println(num1 + " * " + num2 + " = " + tmp + "입니다.");
//			break;
//			
//		case "div":
//			System.out.print("첫 번째 수를 입력하세요>>");
//			num1 = sc.nextInt();
//			System.out.print("두 번째 수를 입력하세요>>");
//			num2 = sc.nextInt();
//			double tmp2=0;
//			tmp2 = (double)num1 / num2;
//			System.out.println(num1 + " / " + num2 + " = "+ tmp2 + "입니다.");
//			break;
//			
//		default:
//			System.out.println("잘못된 명령어 입니다.");
//			break;
//		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}

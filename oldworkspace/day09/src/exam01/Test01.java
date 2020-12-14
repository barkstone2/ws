package exam01;

import java.util.ArrayList;
import java.util.Scanner;

//바이트코드(.class)
class Temp {
	// 필드, Field
		
	String[] subName = {"국어","영어","수학"};
	int kor;
	int eng;
	int math;
	int tot;
	double avg;

	public Temp(int kor, int eng, int math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		tot = kor + eng + math;
		avg = tot / (double)subName.length;
	}

	public Temp() {
		this(90,90,90);
	}

	@Override
	public String toString() {
		String msg = "";
		for(String sub : subName) {
			msg += (sub+"\t");
		}
		
		return msg;
	}
	
	void display() {

		System.out.printf("%d\t %d\t %d\t %d\t %.2f\t\n", kor, eng, math, tot, avg);

	}

	// 생성자, Constructor

	// 메소드, Method

}

public class Test01 {

	public static void main(String[] args) {
		// 자료형 변수 = new 생성자(); //생성자는 클래스 이름과 동일한 메서드
//		Temp t1 = new Temp();
//		t1.kor = 90;
//		t1.eng = 80;
//		t1.math = 71;
//		t1.tot = t1.kor + t1.eng + t1.math;
//		t1.avg = t1.tot / 3D; // promotion, 자동형변환
//
//		t1.display();
//
//		Temp t2 = new Temp();
//		t2.kor = 99;
//		t2.eng = 88;
//		t2.math = 76;
//		t2.tot = t2.kor + t2.eng + t2.math;
//		t2.avg = t2.tot / 3D;
//
//		t2.display();
//

//		Temp tp = new Temp();
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.print("국어 점수를 입력>>");
//		tp.kor  =	sc.nextInt();
//		System.out.print("영어 점수를 입력>>");
//		tp.eng = sc.nextInt();
//		System.out.print("수학 점수를 입력>>");
//		tp.math = sc.nextInt();
//		tp.tot = tp.kor + tp.eng + tp.math;
//		tp.avg = tp.tot / 3D;
//		tp.display();
		
		
		
		
		ArrayList<Temp> list = new ArrayList<>();

		Scanner sc = new Scanner(System.in);
		System.out.println("국어,영어,수학 점수를 입력하세요.");
		System.out.println("종료하시려면 Q를 입력하세요.");
		System.out.println("입력 양식 : 80,70,60");

		while (true) {
			System.out.print(">>");
			String input = sc.nextLine();
			if (input.equalsIgnoreCase("Q")) {
				break;
			}

			Scanner sc2 = new Scanner(input).useDelimiter(",");

			try {
				if (sc2.hasNext()) {
					list.add(new Temp(sc2.nextInt(), sc2.nextInt(), sc2.nextInt()));
				} else {
					System.out.println("입력된 값이 없습니다.");
				}

			} catch (Exception e) {
				System.out.println("잘못 입력했습니다.");
			}

		} // while end

		if (list.size() != 0) {
			System.out.println("----------------------------------------");
			System.out.println(new Temp()+"총점	평균");
			System.out.println("----------------------------------------");

			for (Temp t : list) {
				t.display();
			}

			System.out.println("----------------------------------------");
		}

		System.out.println("프로그램을 종료합니다.");

		
		
		
		
	} // main end

}

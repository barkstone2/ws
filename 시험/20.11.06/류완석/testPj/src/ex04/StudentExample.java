package ex04;

import java.util.ArrayList;
import java.util.Scanner;

import ex03.Student;

public class StudentExample {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Student> list = new ArrayList<>();
		
		while(true) {
			System.out.print("선택(1:조회, 2:등록, 기타:종료):");
			String menu = sc.next();
			if(menu.equals("1")) {
				if(!list.isEmpty()) {
					System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
					for(Student s : list) {
						System.out.println(s);
					}
				}else {
					System.out.println("목록이 비어있습니다.");
				}
			}else if(menu.equals("2")) {
				System.out.print("이름을 입력하세요>>");
				String name = sc.next();
				System.out.print("국어점수를 입력하세요>>");
				int kor = sc.nextInt();
				System.out.print("영어점수를 입력하세요>>");
				int eng = sc.nextInt();
				System.out.print("수학점수를 입력하세요>>");
				int mat = sc.nextInt();
				
				list.add(new Student(name,kor,eng,mat));
				
			}else {
				System.out.println("프로그램 종료");
				break;
			}
			
		}
		
	
		
		
		
		
	}
}

package ex03;

import java.util.ArrayList;
import java.util.Scanner;

public class Example {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Student> list = new ArrayList<>();
		
		
		for(int i=0; i<3; i++) {
				System.out.print("이름을 입력하세요>>");
				String name = sc.next();
				System.out.print("국어점수를 입력하세요>>");
				int kor = sc.nextInt();
				System.out.print("영어점수를 입력하세요>>");
				int eng = sc.nextInt();
				System.out.print("수학점수를 입력하세요>>");
				int mat = sc.nextInt();
				
				list.add(new Student(name,kor,eng,mat));
		}
		
		
		
		if(!list.isEmpty()) {
			System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
			for(Student s : list) {
				System.out.println(s);
			}
		}
		
		
		
	}
}

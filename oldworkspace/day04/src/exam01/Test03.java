package exam01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Test03 {
	
	public static void main(String[] args) {
		
		
//		for(int i=1; i<11; i++) {
//			for(int j=0; j<i; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		
//		String tmp = "";
//		for(int i=0; i<100; i++) {
//			tmp += "*";
//			System.out.println(tmp);
//		}
		

//		for(int i=2; i<10; i++) {
//			System.out.println(i+"단");
//			for(int j=1; j<10; j++) {
//				System.out.println(i+" * "+j+" = "+i*j);
//			}
//			System.out.println("==========");
//		}
		
		
		//입력 : 이름, 근속연수
		//출력 : 홍길동님의 근속연수는 ?년이고, 휴가일수는 ??입니다.
		//근속년수 1~3년 : 5일
		//근속년수 4~6년 : 10일
		//근속년수 7~8년 : 20일
		//근속년수 9년이상 : 30일
		//근속년수 15년이상 : 50일
		
		
//		String name;
//		int workYear;
//		int holiday = 0;
//		
//		
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.print("이름 입력>>");
//		name = sc.nextLine();
//		
//		System.out.print("근속연수>>");
//		workYear = sc.nextInt();
//		
//		if(workYear>=1) {
//			if(workYear<=3) {
//				holiday = 5;
//			} else if(workYear<=6) {
//				holiday = 10;
//			} else if(workYear<=8) {
//				holiday = 20;
//			} else if(9 <= workYear && workYear <15) {
//				holiday = 30;
//			} else {
//				holiday = 50;
//			}
//		}
//		
//		
//		System.out.printf("%s님의 근속년수는 %d년이고, 휴가일수는 %d일 입니다.",name,workYear,holiday);
		
		
		//입력 : 두개의 연도를 입력
		//출력 : 두 연도 사이의 연도를 모두 출력, 해당 연도들이 윤년인지 파악.
		//윤년 : 4의 배수면서 100의 배수가 아닌 것, 400의 배수인것.
		
//		Scanner sc = new Scanner(System.in);
		
//		int year1;
//		int year2;
//		
//		System.out.print("시작 연도를 입력하세요>>");
//		year1 = sc.nextInt();
//		
//		System.out.print("끝 연도를 입력하세요>>");
//		year2 = sc.nextInt();
		
		
//		for(int i=0; i<year2-year1+1; i++) {
//			if((year1+i)%4==0 && (year1+i)%100!=0) {
//				System.out.println(year1+i+"년은 윤년입니다.");
//			} else if((year1+i)%400==0) {
//				System.out.println(year1+i+"년은 윤년입니다.");
//			} else {
//				System.out.println(year1+i+"년은 윤년이 아닙니다.");
//			}
//			
//			
//		}
		
		
		//입력 : 숫자
		// 별 찍기 입력받은 숫자 만큼
		
//		Scanner sc = new Scanner(System.in);
//		
//		int line;
//		
//		System.out.print("라인 수를 입력하세요>>");
//		line = sc.nextInt();
//		
//		for(int i=0; i<line; i++) {
//			for(int j=0; j<i+1; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		
//		Scanner sc = new Scanner(System.in);
//		
//		int line;
//		
//		System.out.print("라인 수를 입력하세요>>");
//		line = sc.nextInt();
//		
//		for(int i=line; i>0; i--) {
//			for(int j=0; j<i; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		
		//입력 : 이름, 국어, 영어, 수학 <- 5명
		//출력 : 이름, 국어, 영어, 수학, 총점, 평균, 등급
		
//		String[] name = new String[3];
//		int[] kor = new int[3];
//		int[] eng = new int[3];
//		int[] math = new int[3];
//		int[] total = new int[3];
//		int[] avg = new int[3];
//		String[] grade = new String[3];
//		
//		int i=0;
//		
//		while(i<3) {
//			Scanner sc = new Scanner(System.in);
//			
//			System.out.print("이름을 입력하세요>>");
//			name[i] = sc.nextLine();
//			System.out.print("국어 점수를 입력하세요>>");
//			kor[i] = sc.nextInt();
//			System.out.print("영어 점수를 입력하세요>>");
//			eng[i] = sc.nextInt();
//			System.out.print("수학 점수를 입력하세요>>");
//			math[i] = sc.nextInt();
//			
//			total[i] = kor[i] + eng[i] + math[i];
//			avg[i] = total[i] / total.length;
//			
//			if(total[i]>=90) {
//				grade[i] = "수";
//			} else if(total[i]>=80) {
//				grade[i] = "우";
//			} else if(total[i]>=70) {
//				grade[i] = "미";
//			} else if(total[i]>=60) {
//				grade[i] = "양";
//			} else {
//				grade[i] = "가";
//			}
//			i++;
//		}
//		
//		System.out.println("----------------------------------------------------------------");
//		System.out.println("이름	국어	영어	수학	총점	평균	등급");
//		System.out.println("----------------------------------------------------------------");
//		
//		for(int j=0; j<3; j++) {
//			System.out.println(name[j]+"\t"+kor[j]+"\t"+eng[j]+"\t"+math[j]+"\t"+total[j]+"\t"+avg[j]+"\t"+grade[j]);
//		}
//		System.out.println("----------------------------------------------------------------");
		
		
		
		
//		Student[] st = new Student[3];
//		Scanner sc = new Scanner(System.in);
//		int i=0;
//		
//		while(true) {
//			System.out.println("명령어를 입력하세요.");
//			System.out.println("1.입력 2.종료");
//			System.out.print(">>");
//			int com = sc.nextInt();
//			sc.nextLine();
//			
//			if(com ==1) {
//				System.out.println("학생 정보를 입력하세요.");
//				System.out.println("입력 양식 : 이름,국어점수,영어점수,수학점수");
//				System.out.print(">>");
//				String input = sc.nextLine();
//				Scanner sc2 = new Scanner(input).useDelimiter(",");
//				
//				while(sc2.hasNext()) {
//					st[i] = new Student(sc2.next(), sc2.nextInt(),sc2.nextInt(),sc2.nextInt());
//					i++;
//				} // inner while end
//				
//			}else if(com==2) {
//				break;
//			} // if delimiter end
//		} // while scan end
//		
//		System.out.println("----------------------------------------------------------------");
//		System.out.println("이름	국어	영어	수학	총점	평균	등급");
//		System.out.println("----------------------------------------------------------------");
//		
//		for(int j=0; j<st.length; j++) {
//			
//			if(st[j]!=null) {
//				System.out.println(st[j]);
//			}else {
//				break;
//			}
//		}//for print st[] end
		
		File fi = new File("test.txt");
		ArrayList<Student> st = new ArrayList<Student>();
		int i=0;
		
		try {
			Scanner sc = new Scanner(fi);
			while(sc.hasNextLine()) {
				Scanner sc2 = new Scanner(sc.nextLine()).useDelimiter(",");
				
				while(sc2.hasNext()) {
					st.add(new Student(sc2.next(), sc2.nextInt(),sc2.nextInt(),sc2.nextInt()));
//					i++;
				}
			}
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("----------------------------------------------------------------");
		System.out.println("이름	국어	영어	수학	총점	평균	등급");
		System.out.println("----------------------------------------------------------------");
		
		for(int j=0; j<st.size(); j++) {
			
			if(st.get(j)!=null) {
				System.out.println(st.get(j));
			}else {
				break;
			}
		}//for print st[] end
		
		
		
		
		
		
		
		
		
		
		
	} // main Method end
	
	
	
	
}

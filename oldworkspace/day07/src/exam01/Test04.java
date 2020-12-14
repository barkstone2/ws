package exam01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Test04 {
	public static void main(String[] args) {
		
		
		//입력 : 이름,국어,영어,수학 -> 리스트에 담아라
		
		ArrayList<ArrayList<String>> allStudent = new ArrayList<ArrayList<String>>();
		
		Scanner sc = new Scanner(System.in);
		
		String[] menu = {"이름", "국어", "영어", "수학"};
		
		for(int j=0; allStudent.size()<3; j++) {
			ArrayList<String> student = new ArrayList<String>();
			for(int i=0; i<menu.length; i++) {
				System.out.print(menu[i]+"을 입력하세요>>");
				String input = sc.nextLine();
				student.add(input);
			}
			
			allStudent.add(student);
		}
		
		System.out.println(allStudent);
		System.out.println(allStudent.get(0).get(0));
		System.out.println(allStudent.get(1).get(0));
		System.out.println(allStudent.get(2).get(0));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		ArrayList cars = new ArrayList();
//		
//		cars.add("아반떼");
//		System.out.println(cars);
//		
//		cars.add("그랜저");
//		System.out.println(cars);
//		
//		cars.add("제네시스");
//		System.out.println(cars);
//		
//		cars.add(1, "소나타");
//		System.out.println(cars);
//		
//		cars.add("프라이드");
//		System.out.println(cars);
		
//		System.out.println(cars.get(0));
//		System.out.println(cars.size());
//		
//		Iterator it = cars.iterator();
//		while(it.hasNext()) {
//			System.out.println(it.next());
//		}
//		
//		for (int i=0; i<cars.size(); i++) {
//			System.out.println(cars.get(i));
//			
//		}
		
//		cars.set(1, "볼보");
//		System.out.println(cars);
//		
//		cars.remove(1);
//		System.out.println(cars);
//		
//		cars.remove("제네시스");
//		System.out.println(cars);
//		
//		cars.add("그랜저");
//		cars.add("그랜저");
//		System.out.println(cars);
//		
//		cars.remove("그랜저");
//		System.out.println(cars);
//		
//		System.out.println(cars.contains("그랜저"));
//		
//		cars.add(100);
//		System.out.println(cars);
//		
//		
//		System.out.println(cars.indexOf("그랜저"));
		
		//입력 : 국어,영어,수학,과학,역사,체육,음악,미술
		//출력 : 
		//국어,영어,수학,과학,역사,체육,음악,미술,총점,평균,등급
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		ArrayList list = new ArrayList();
//		Scanner sc = new Scanner(System.in);
//		int total = 0;
//		int avg = 0;
//		String grade = "";
//		
//		
//		for(int i=0; i<8; i++) {
//			System.out.print(">>");
//			int input = sc.nextInt();
//			list.add(input);
//		}
//		
//		System.out.println("국어\t영어\t수학\t과학\t역사\t체육\t음악\t미술\t총점\t평균\t등급");
//		
//		for(int i=0; i<list.size(); i++) {
//			System.out.print(list.get(i)+"\t");
//			total += (int)list.get(i);
//		}
//		
//		avg = total / list.size();
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
//		System.out.print(total+"\t"+avg+"\t"+grade);
		
		
		
		
		
		
		
		//입력 : 상품이름, 상품가격
		//출력
		//상품이름.....상품가격
		//=================
		//합계...........합계금액
		
		
//		ArrayList pName = new ArrayList();
//		ArrayList price = new ArrayList();
//		Scanner sc = new Scanner(System.in);
//		int totalP = 0;
//		
//		System.out.println("상품명,가격의 형태로 입력하세요.");
//		System.out.println("입력을 종료하시려면 q를 입력하세요");
//		
//		while(true) {
//			System.out.print(">>");
//			String input = sc.nextLine();
//			if(input.equalsIgnoreCase("Q")) {
//				System.out.println("입력을 종료합니다.");
//				break;
//			}
//			try {
//				if(sc.hasNextLine()) {
//					Scanner sc2 = new Scanner(input).useDelimiter(",");
//					pName.add(sc2.next());
//					price.add(sc2.nextInt());
//				
//				}else {
//					System.out.println("입력된 값이 없습니다.");
//				}
//				
//			}catch(Exception e) {
//				System.out.println("잘못 입력했습니다.");
//				
//			}//try-catch end
//		}//while end
//		
//		for(int i=0; i<pName.size(); i++) {
//			System.out.println(pName.get(i)+"\t.......\t"+price.get(i));
//			totalP += (int)price.get(i);
//		}
//		
//		System.out.println("======================");
//		System.out.println("합계\t.......\t"+totalP);
		
		
		
	}
}

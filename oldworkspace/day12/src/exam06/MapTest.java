package exam06;

import java.util.HashMap;
import java.util.Scanner;

public class MapTest {

	public static void main(String[] args) {
		HashMap<String, Student> map = new HashMap<>();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
			System.out.print("(종료:0,목록:1,입력:2,조회:3):");
			int com = sc.nextInt();
			
			if(com==0) {
				break;
			}else if(com==1) {
				System.out.println(map.keySet());
			}else if(com==2) {
				sc.nextLine();
				System.out.print("이름,국어,영어,수학,과학,역사 입력>>");
				String input = sc.nextLine();
				
				@SuppressWarnings("resource")
				Scanner sc2 = new Scanner(input).useDelimiter(",");
				String name = sc2.next();
				map.put(name, new Student(name, sc2.nextInt(), sc2.nextInt(), sc2.nextInt(), sc2.nextInt(), sc2.nextInt()));
			}else if(com==3) {
				System.out.print("조회할 이름을 입력하세요>>");
				String key = sc.next();
				System.out.println("이름\t국어\t영어\t수학\t과학\t역사\t총점\t평균\t등급");
				System.out.println(map.get(key));
			}
			
		}
		
		
		
	
		
	}

}

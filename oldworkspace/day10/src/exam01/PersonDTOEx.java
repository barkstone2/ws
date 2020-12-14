package exam01;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonDTOEx {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ArrayList<PersonDTO> pList = new ArrayList<>();
		System.out.println("이름,나이,키,몸무게 순으로 입력하세요.");
		System.out.println("입력을 종료하려면 Q를 입력하세요.");
		
		while(true) {
			System.out.print(">>");
			String input = sc.nextLine();
			
			if(input.equalsIgnoreCase("Q")) {
				break;
			}
			
			Scanner sc2 = new Scanner(input).useDelimiter(",");
			
			try {
				if(sc2.hasNext()) {
					pList.add(new PersonDTO(sc2.next(),sc2.nextInt(),sc2.nextDouble(),sc2.nextDouble()));
					
				}else {
					System.out.println("입력된 값이 없습니다.");
				}
			}catch(Exception e) {
				System.out.println("잘못 입력했습니다. 입력 양식에 맞춰 다시 입력하세요.");
			}
			
		}//while end
		
		if(pList.size()>0) {
			System.out.println("이름\t나이\t키\t몸무게");
			System.out.println("=============================");
			for(PersonDTO d : pList) {
				System.out.println(d);
			}
		}
		
		
		
		System.out.println("프로그램 종료");
		
	}
}

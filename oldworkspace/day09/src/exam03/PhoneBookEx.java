package exam03;

import java.util.ArrayList;
import java.util.Scanner;

@TestInfo(
	count = 3, testedBy = "Kim",
	testDate = @DateTime(yymmdd = "160101", hhmmss = "235959"),
	testTools = { "JUnit","AutoTester" }, testType = TestType.FIRST
)
public class PhoneBookEx {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		ArrayList<PhoneBook> pbList = new ArrayList<PhoneBook>();
		
		System.out.println("이름,전화번호,지역");
		
		while(true) {
			System.out.print(">>");
			String input = sc.nextLine();
			
			if(input.equalsIgnoreCase("Q")) {
				break;
			}
			
			if(input!=null) {
				Scanner sc2 = new Scanner(input).useDelimiter(",");
				try {
					pbList.add(new PhoneBook(sc2.next(),sc2.next(),sc2.next()));
				}catch(Exception e) {
					System.out.println("잘못 입력");
				}//try-catch end
			}//null check if end
		}//input while end
		
		if(pbList!=null) {
			for(PhoneBook pb : pbList) {
				System.out.println(pb);
			}
		}//list print end
		
		System.out.println("프로그램 종료");
		
	}
}

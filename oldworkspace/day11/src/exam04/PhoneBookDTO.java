package exam04;

import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBookDTO {
	
	private String name;
	private String pNum;
	private ArrayList<PhoneBookDTO> pBook = new ArrayList<>();
	
	public PhoneBookDTO(String name, String pNum) {
		this.name = name;
		this.pNum = pNum;
	}
	
	public PhoneBookDTO() {
	}
	
	
	public void input() {
		while(true) {
			System.out.print("선택하세요(0:종료, 1:목록, 2:등록):");
			Scanner sc = new Scanner(System.in);
			int com = sc.nextInt();
			if(com==0) {
				System.out.println("--프로그램 종료--");
				break;
			}else if(com==1) {
				if(pBook.isEmpty())	{
					System.out.println("--내용없음--");
				} else {
					System.out.println("이름\t전화번호");
					System.out.println("===========================");
					display();
					continue;
				}
				
			}else if(com==2) {
				System.out.print("이름:");
				String name = sc.next();
				System.out.print("전화번호:");
				String pNum = sc.next();
				pBook.add(new PhoneBookDTO(name,pNum));
				continue;
				
			}else {
				System.out.println("잘못입력하셨습니다. (0~2)");
				continue;
			}//if end
			
		
		}//while end
		
	}//input method end
	
	
	public void display() {
		for(PhoneBookDTO p : pBook) {
			System.out.println(p.name+"\t"+p.pNum);
		}
	}
	
	
	
	
	
}

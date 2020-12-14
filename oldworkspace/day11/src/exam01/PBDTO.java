package exam01;

import java.util.ArrayList;
import java.util.Scanner;

public class PBDTO {

	private String name;
	private String pNum;
	private ArrayList<PBDTO> phBook = new ArrayList<PBDTO>();
	
	
	public PBDTO(String name, String pNum) {
		this.name = name;
		this.pNum = pNum;
	}

	
	public PBDTO() {
	}
	
	
	public void input() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("입력>>");
			String input = sc.nextLine();
			
			if(input.equalsIgnoreCase("Q")) {
				break;
			}
			
			@SuppressWarnings("resource")
			Scanner sc2 = new Scanner(input).useDelimiter(",");
			
			if(sc2.hasNext()) {
				try {
					phBook.add(new PBDTO(sc2.next(),sc2.next()));
				}catch(Exception e) {
					System.out.println("잘못입력");
					continue;
				}
			}else {
				System.out.println("입력된 값 없음");
				continue;
			}

		}
	}
	
	public void prList() {
		if(!phBook.isEmpty()) {
			for(PBDTO p : phBook) {
				System.out.println(p);
				
			}
		}else {
			System.out.println("목록 비어있음");
		}
		
	}
	
	
	@Override
	public String toString() {
		return name + " " + pNum;
	}
	
	
}


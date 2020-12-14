package exam01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		//입력 : 상품이름, 가격
		//출력 : 상품이름....상품가격
		//===================
		//합계...............합계금액
		
		
		
		
		ArrayList<Product> list = new ArrayList<Product>();
		Scanner sc = new Scanner(System.in);
		
		int totalP = 0;
		
		System.out.println("상품명,가격의 형태로 입력하세요.");
		System.out.println("입력을 종료하시려면 q를 입력하세요");
		
		while(true) {
			System.out.print(">>");
			
			String input = sc.nextLine();
			
			if(input.equalsIgnoreCase("Q")) {
				System.out.println("입력을 종료합니다.");
				break;
			}
			
			if(!input.isEmpty()) {
				Scanner sc2 = new Scanner(input).useDelimiter(",");
				
				try {
					if(sc2.hasNext()) {
						list.add(new Product(sc2.next(),sc2.nextInt()));
					}
				}catch(Exception e) {
					System.out.println("입력 양식에 맞춰 입력하세요.");
					continue;
				}
			}else {
				System.out.println("입력된 값이 없습니다. 값을 입력하세요.");
			}//if end
			
		}//while end
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).pName+"\t.......\t"+list.get(i).price);
			totalP += list.get(i).price;
		}
		
		System.out.println("======================");
		System.out.println("합계\t.......\t"+totalP);
		
	}
}

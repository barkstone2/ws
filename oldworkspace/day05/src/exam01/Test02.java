package exam01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) throws FileNotFoundException {
		
		//입력 : 상품이름, 상품가격 -> 5개
		//출력 : 새우깡 ....1500원
		//-----------------
		//합계 : ........????원
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Product> list = new ArrayList<Product>();
		
		System.out.println("상품명,가격,수량 형태로 입력하세요.");
		System.out.println("입력을 종료하려면 Q를 입력하세요.");
		
		while(true) {
			
			System.out.print(">>");
			String input = sc.nextLine();
			
			if(input.equalsIgnoreCase("Q")) {
				System.out.println("입력을 종료합니다.");
				System.out.println();
				break;
			}
							
			if(!input.isEmpty()) {
				Scanner sc2 = new Scanner(input).useDelimiter(",");
				while(sc2.hasNext()) {
					try {
						list.add(new Product(sc2.next(), sc2.nextInt(),sc2.nextInt()));
					}catch(Exception e) {
						System.out.println("잘못 입력했습니다.");
						System.out.println("입력 형식에 맞춰 입력하세요.");
						continue;
					}//try catch
					
				}//list add while end
			} else{
				System.out.println("입력된 값이 없습니다. 값을 입력하세요.");
				continue;
			} //input empty if ends
			
		}//while end
		
		if(!list.isEmpty()) {
			int total=0;
			int point=0;
			for(int i=0; i<list.size(); i++) {
				System.out.println(list.get(i));
				total += list.get(i).price*list.get(i).count;
				point += list.get(i).point;
			}
			System.out.println("--------------------------------------");;
			System.out.println("합계\t\t"+total+"\t"+point);
		} else {
			System.out.println("상품 목록이 비어 있습니다.");
		}//list empty if end
		
		
		
//		File fi = new File("test.txt");
//		Scanner sc = new Scanner(fi);
//		ArrayList<Product> list = new ArrayList<Product>();
//		
//		while(sc.hasNextLine()) {
//			
//			String input = sc.nextLine();
//			Scanner sc2 = new Scanner(input).useDelimiter(",");
//				while(sc2.hasNext()) {
//					try {
//						list.add(new Product(sc2.next(), sc2.nextInt(),sc2.nextInt()));
//					}catch(Exception e) {
//						System.out.println("잘못된 파일입니다.");
//						System.out.println("입력 형식에 맞춰 파일을 작성한 뒤 다시 시도하세요.");
//						System.exit(0);
//					}//try catch
//				}//list add while end
//				sc2.close();
//		}//while end
//		
//		if(!list.isEmpty()) {
//			int total=0;
//			int point=0;
//			for(int i=0; i<list.size(); i++) {
//				System.out.println(list.get(i));
//				total += list.get(i).price*list.get(i).count;
//				point += list.get(i).point;
//			}
//			System.out.println("--------------------------------------");;
//			System.out.println("합계\t\t"+total+"원\t\t"+point+"P");
//		} else {
//			System.out.println("상품 목록이 비어 있습니다.");
//		}//list empty if end
//		sc.close();
	} // main Method end
	
	
}

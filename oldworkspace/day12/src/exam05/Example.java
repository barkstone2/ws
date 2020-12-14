package exam05;

import java.util.ArrayList;
import java.util.Scanner;

public class Example {
	public static void main(String[] args) {
		
		ArrayList<BookSale> list = new ArrayList<>();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int com;
		
		while(true) {
			System.out.print("선택(0:종료, 1:목록, 2:등록, 3:수정, 4:삭제):");
			com = sc.nextInt();
			
			if(com==0) {
				break;
			}else if(com==1) {
				System.out.print("책이름 \t");
				System.out.print("저자 \t");
				System.out.print("출판사 \t");
				System.out.print("발행년 \t");
				System.out.print("단가 \t");
				System.out.print("판매수 \t");
				System.out.print("순위 \t");
				System.out.println("판매금액");
				System.out.println("--------------------------------------------------------------------");
				for(BookSale b : list) {
					b.display();
				}
			}else if(com==2) {
				
				System.out.print("책이름을 입력하세요>>");
				String name = sc.next();
				System.out.print("저자를 입력하세요>>");
				String author = sc.next();
				System.out.print("출판사를 입력하세요>>");
				String maker = sc.next();
				System.out.print("출판년도를 입력하세요>>");
				int year = sc.nextInt();
				System.out.print("가격을 입력하세요>>");
				int price = sc.nextInt();
				System.out.print("판매수를 입력하세요>>");
				int amount = sc.nextInt();
				System.out.print("순위를 입력하세요>>");
				int rank = sc.nextInt();
				
				list.add(new BookSale(name, author, maker, year, price, amount, rank));
			}else if(com==3) {
				System.out.println("수정할 인덱스를 입력>>");
				int index = sc.nextInt();
				
				System.out.print("책이름을 입력하세요>>");
				String name = sc.next();
				System.out.print("저자를 입력하세요>>");
				String author = sc.next();
				System.out.print("출판사를 입력하세요>>");
				String maker = sc.next();
				System.out.print("출판년도를 입력하세요>>");
				int year = sc.nextInt();
				System.out.print("가격을 입력하세요>>");
				int price = sc.nextInt();
				System.out.print("판매수를 입력하세요>>");
				int amount = sc.nextInt();
				System.out.print("순위를 입력하세요>>");
				int rank = sc.nextInt();
				
				list.set(index, new BookSale(name, author, maker, year, price, amount, rank));
			
				
			}else if(com==4) {
				System.out.print("삭제할 인덱스를 입력>>");
				int index = sc.nextInt();
				list.remove(index);
			}else {
				continue;
			}
			
		}
		
		
		
		
		

	
	}
	
	
	
	
}

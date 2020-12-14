package exam05;

import java.util.ArrayList;
import java.util.Scanner;

public class BookDTO {
	//입력 : 책이름, 저자, 출판사, 출판연도, 단가, 판매수량, 총판매액
	
	private String bookName;
	private String author;
	private String maker;
	private int makeYear;
	private int price;
	private int sellCount;
	private int totMoney;

	
	public BookDTO(String bookName, String author, String maker, int makeYear, int price, int sellCount) {
		this.bookName = bookName;
		this.author = author;
		this.maker = maker;
		this.makeYear = makeYear;
		this.price = price;
		this.sellCount = sellCount;
		totMoney = price*sellCount;
		
	}
	
	public BookDTO() {
	}
	
	
	public ArrayList<BookDTO> inputBookInfo() {
		ArrayList<BookDTO> result = new ArrayList<BookDTO>();
		BookDTO tmp;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.println("책이름,저자,출판사,출판연도,단가,판매수량 순으로 입력하세요.");
		System.out.println("입력을 종료하려면 Q를 입력하세요.");
		
		while(true) {
			System.out.print(">>");
			String input = sc.nextLine();
			
			if(input.equalsIgnoreCase("Q")) {
				System.out.println("입력을 종료합니다.");
				break;
			}
			
			@SuppressWarnings("resource")
			Scanner sc2 = new Scanner(input).useDelimiter(",");
			
			try {
				tmp = new BookDTO(sc2.next(), sc2.next(), sc2.next(), sc2.nextInt(), sc2.nextInt(),sc2.nextInt());
				
			}catch(Exception e) {
				System.out.println("양식에 맞춰 다시 입력하세요.");
				continue;
			}
			
			result.add(tmp);
			
		}//while end
		
		return result;
	}
	
	
	
	public void printList(ArrayList<BookDTO> list) {
		if(!list.isEmpty()) {
			String msg = "책이름\t저자\t출판사\t출판연도\t단가\t판매수량\t총판매금액\n";
			msg += "=================================================================\n";
			for(BookDTO t : list) {
				msg += (t+"\n");
			}
			System.out.println(msg);
		}else {
			System.out.println("목록이 비어있습니다.");
		}
	}
	
	
	
	@Override
	public String toString() {
		return bookName+"\t"+author+"\t"+maker+"\t"+makeYear+"\t"+price+"\t"+sellCount+"\t"+totMoney;
	}
	
	
	
	
	
}

package exam05;

public class BookSale extends Book{
	//Field
	private int amount; //판매수
	private int rank; //순위
	private long money; //판매금액(단가 * 수량, 10만원 초과 시 10% 할인)
	
	//Constructor
	public BookSale() {}
	public BookSale(String bookName, String author, String maker, int year, int price, int amount, int rank) {
		super(bookName, author, maker, year, price);
		this.amount = amount;
		this.rank = rank;
		cal();
		
	}
	
	
	
	
	
	
	//Method
	
	
	public void cal() {
		money =(long)price*amount;
		if(money>100000) {
			money = (long)(money * 0.9);
		}
	}
	
	public void display() {

		System.out.print(getBookName()+"\t");
		System.out.print(getAuthor()+"\t");
		System.out.print(getMaker()+"\t");
		System.out.print(getYear()+"\t");
		System.out.print(getPrice()+"\t");
		
		System.out.print(amount+"\t");
		System.out.print(rank+"\t");
		System.out.print(money+"\t\n");
	}
	
	
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public long getMoney() {
		return money;
	}
	
	
	
	
	
	
	
}

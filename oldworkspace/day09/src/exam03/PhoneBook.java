package exam03;


public class PhoneBook {
	
	String name;
	String pNum;
	String area;
	
	public PhoneBook(String name, String pNum, String area) {
		this.name = name;
		this.pNum = pNum;
		this.area = area;
	}
	
	public PhoneBook() {
		
	}
	
	@Override
	public String toString() {
		return name+"\t"+pNum+"\t"+area;
	}
	
	
	
}

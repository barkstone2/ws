package exam01;

public class PhoneBook {
	private String name;
	private String phoneNum;
	
	public PhoneBook(String name, String phoneNum) {
		this.name = name;
		this.phoneNum = phoneNum;
	}
	
	public PhoneBook() {
	}

	public void display() {
		System.out.println(name+phoneNum);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	
	
	
	
	
}

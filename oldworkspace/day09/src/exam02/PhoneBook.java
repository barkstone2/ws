package exam02;

public class PhoneBook {
	String name;
	String phoneNum; //"000-0000-0000"
	String area;
	
	public PhoneBook(String name, String pNum, String area) {
		this.name = name;
		this.phoneNum = pNum;
		this.area = area;
	}
	
	public PhoneBook() {
	}
	
	
	@Override
	public String toString() {
		return name+"님의 전화번호는 "+phoneNum+"이며 지역은 "+area+"입니다.";
	}
	
	//입력을 받아 객체를 만들고 리스트에 담는다
	//폰넘버를 키로 해쉬맵을 만들어 해당하는 객체를 밸류로 할당한다.
	//toString 오버라이드를 통해 객체의 정보를 반환한다.
	//
	
	
}

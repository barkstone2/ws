package exam03;

public class MemberDTO {
	String name;
	String id;
	int usedMoney;
	String memGrade;
	//탑스1 - 3천만 이상
	//탑스2 - 1천만 이상
	//탑스3 - 5백만 이상
	// 그외 일반
	
	public MemberDTO(String name, String id, int usedMoney) {
		this.name = name;
		this.id = id;
		this.usedMoney = usedMoney;
		
		if(usedMoney>=30000000) {
			memGrade = "탑스1";
		}else if(usedMoney>=10000000) {
			memGrade = "탑스2";
		}else if(usedMoney>=5000000) {
			memGrade = "탑스3";
		}else {
			memGrade="일반";
		}
		
	}

	
	@Override
	public String toString() {
		return name +" "+id+" "+usedMoney+" "+memGrade;
	}
	
	
	
	
}

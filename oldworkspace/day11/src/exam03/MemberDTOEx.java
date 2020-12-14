package exam03;

import java.util.ArrayList;

public class MemberDTOEx {
	
	public static void main(String[] args) {
		
		ArrayList<MemberDTO> list = new ArrayList<>();
		MemberDTO m = new MemberDTO("홍길동", "hong", 40000000);
		
		list.add(m);
		
		
		
		System.out.println(list.get(0));
	
		
		
		
	}
}

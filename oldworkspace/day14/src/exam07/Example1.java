package exam07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Example1 {
	
	public static void main(String[] args) {
		
		
		ArrayList<HashMap<String, String>> list = new ArrayList<>();
		HashMap<String, String> map = new HashMap<>();
		
		
		map.put("name", "홍길동");
		map.put("id", "hong");
		map.put("password","1234");
		map.put("phone", "010-1111-2222");
		
		list.add(map);
		
		map = new HashMap<>();
		
		map.put("name", "정원겸");
		map.put("id", "jung");
		map.put("password","4567");
		map.put("phone", "010-3333-4444");
		
		list.add(map);
		
		map = new HashMap<>();
		
		map.put("name", "김정아");
		map.put("id", "kim");
		map.put("password","3456");
		map.put("phone", "010-3895-4486");
		
		list.add(map);
		
		Stream<HashMap<String, String>> str = list.stream();
		str.forEach((h)->{
			System.out.println(h.get("id"));
			System.out.println(h.get("name"));
			System.out.println(h.get("password"));
			System.out.println(h.get("phone"));
		});
	}
}

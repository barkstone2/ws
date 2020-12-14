package exam06;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Test {
	public static void main(String[] args) {
		
		ArrayList<Object> list = new ArrayList<>();
		System.out.println(list);
		list.add("하나");
		System.out.println(list);
		list.add("5");
		System.out.println(list);
		list.add(3);
		list.add(3.0);
		list.add(true);
		
		System.out.println(list.size());
		System.out.println("----------------");
		Stream<Object> str = list.stream();
		str.forEach(System.out::println);
		
		
	}
}

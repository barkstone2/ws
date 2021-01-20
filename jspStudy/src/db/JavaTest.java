package db;

import java.util.regex.Pattern;

public class JavaTest {

	public static void main(String[] args) {
		String abc = "1234";
		String pattern = "^[0-9]{4}$";
		boolean regex = !Pattern.matches(pattern, abc);
		
		System.out.println(regex);
	}

}

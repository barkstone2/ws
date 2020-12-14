package exam01;

import java.util.Arrays;

public class Test05 {
	public static void main(String[] args) {
		String[] names = { "홍길동", "이성순", "장천용", "이상대" };

		printArr(names);

	}

	static void printArr(String[] arr) {
		arr[2] = "박철순";
		for (String a : arr) {
			System.out.println(a);
		}
	}

}

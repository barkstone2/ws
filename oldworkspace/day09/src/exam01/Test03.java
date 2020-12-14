package exam01;

import java.util.Scanner;

public class Test03 {

	void canDrink(int age) {
		if (age > 19) {
			System.out.println("가능");
		} else {
			System.out.println("불가능");
		}

	}

	public static void main(String[] args) {
		Test03 t1 = new Test03();
		t1.canDrink(20);
		t1.canDrink(19);

	}

}

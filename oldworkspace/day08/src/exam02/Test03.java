package exam02;

import java.util.ArrayList;

class ClassTest {
	String name;
	String phone;
	String addr;

	void display() {
		System.out.printf("%s님의 전화번호는 %s이며, 주소는 %s입니다.\n", name, phone, addr);
	}

	public ClassTest(String name, String phone, String addr) {
		this.name = name;
		this.phone = phone;
		this.addr = addr;
	}

	public ClassTest() {
	}
}

public class Test03 {
	public static void main(String[] args) {

		ArrayList<ClassTest> cList = new ArrayList<ClassTest>();

		cList.add(new ClassTest("홍길동", "010-1111-2222", "경기"));
		cList.add(new ClassTest("이성순", "010-3333-4444", "대구"));
		cList.add(new ClassTest("장천용", "010-5555-6666", "서울"));

		for (ClassTest c : cList) {
			c.display();

		}

	}
}

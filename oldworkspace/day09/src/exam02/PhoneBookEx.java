package exam02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PhoneBookEx {
	public static void main(String[] args) {

		PhoneBook pb = new PhoneBook();

		pb.name = "홍길동";
		pb.phoneNum = "010-1111-2222";
		pb.area = "대구";

		PhoneBook pb2 = new PhoneBook("이성순", "010-3333-4444", "서울");
		PhoneBook pb3 = new PhoneBook("장천용", "010-5555-6666", "경기");

		HashMap<String, PhoneBook> pbMap = new HashMap<>();
		ArrayList<PhoneBook> pbList = new ArrayList<>();
		Scanner sc = new Scanner(System.in);

		pbList.add(pb);
		pbList.add(pb2);
		pbList.add(pb3);
		pbMap.put(pb.phoneNum, pb);
		pbMap.put(pb2.phoneNum, pb2);

		for (PhoneBook temp : pbList) {
			System.out.println(temp);
		}

	}
}

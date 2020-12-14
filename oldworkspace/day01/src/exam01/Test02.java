package exam01;

public class Test02 {
	public static void main(String[] args) {
		
		String name = "홍길동";
		int age = 19;
		String gender = "남자";
		
		//당신의 이름은 홍길동입니다.
		//당신의 나이는 19세입니다.
		//당신의 성별은 남자입니다.
		
		//문자열 연산
		System.out.println("입력하신 이름은 " + name + "이며, 나이는 " + age +"세입니다.");
		
		//문자열 연산
		String message = "";
		message += "입력하신 이름은 ";
		message += name;
		message += "이며, 나이는 ";
		message += age;
		message += "세입니다.";
		System.out.println(message);
		
		String msg = "입력하신 이름은 " + name + "이며, 나이는 " + age + "세입니다.";
		System.out.println(msg);
		
		
		// 서식이 있는
		// %s - 문자열, %d - 정수, %f - 실수, %c - 문자, %n - 줄바꿈
		System.out.printf("당신의 이름은 %s입니다.\n당신의 나이는 %d세입니다.\n당신의 성별은 %s입니다.\n",name, age, gender);
		
		
		
		char aaa = 'A';
		System.out.println(aaa);
		
		char bbb = 65;
		
		System.out.println(Character.MIN_VALUE);
		System.out.println(Character.MAX_VALUE);
		
		System.out.println(bbb);
		for(int i=33; i<123; i++) {
			char a = (char)i;
			System.out.print(a);
		}
		
		
		
		
		
		
		
		
		
	}
}

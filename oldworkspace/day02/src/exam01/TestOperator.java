package exam01;

public class TestOperator {
	
	public static void main(String[] args) {
		//연산자
//		int a;
//		int b;
//		int c;
//		
//		a = 7;
//		b = 5;
//		c = a + b;
//		System.out.println("a + b = " + c);
//		c = a - b;
//		System.out.println("a - b = " + c);
//		c = a * b;
//		System.out.println("a * b = " + c);
//		c = a / b;
//		double d = a / (double)b;
//		System.out.println("a / b = " + c);
//		System.out.println("a / b = " + d);
//		
//		c = a % b;
//		System.out.println("a % b = " + c);
		
//		int x;
//		int y;
//		float r;
//		
//		x = 5;
//		y = 3;
//		r = 0;
//		r = x + y;
//		r = x / y;
//		r = x % y;
//		
//		System.out.println(r);
		
		//대입연산자
//		int a = 5;
//		a += 3; // a = a + 3;
//		a -= 3; // a = a - 3;
//		a *= 10; // a = a * 10;
		
//		System.out.println("a의 값 = " + a);
		
		//증감연산자
//		int a = 5;
//		
//		a++; // a = a + 1;
//		++a; // a = a + 1;
//		a--; // a = a - 1;
//		--a; // a = a - 1;
//		
//		System.out.println("a = " + a);
		
		//전위 연산자, 후위 연산자
//		int a = 5;
//		int b = 0;
//		b = a++;
//		System.out.println("a = " + a);
//		System.out.println("b = " + b);
//		
//		int x = 5;
//		int y = 0;
//		y = ++x;
//		System.out.println("x = " + x);
//		System.out.println("y = " + y);
		
		//비교 연산자 - 조건 ==> boolean
//		> : 크다. ~초과
//		>= : 크거나 같다. ~이상
//		< : 작다. ~미만
//		<= : 작거나 같다. ~이하
//		== : 같다.
//		!= : 같지 않다.
		
//		System.out.println(5 > 2); //true
//		System.out.println(5 >= 2);
//		System.out.println(5 < 2);
//		System.out.println(5 <= 2);
//		System.out.println(5 == 2);
//		System.out.println(5 != 2);
		
		
		//논리연산자 : &&(and), ||(or), !(not)
		
//		int a = 5;
//		int b = 3;
//		int c = 9;
//		int d = 6;
//		boolean r;
//		
//		r = a > b && c > d;
//		System.out.println("r = " + r);
		
		//산술, 대입, 증감, 비교, 논리
		//산술 >> 비교(관계) >> 논리
		
		//5 <= 7 <= 9
		//5 <= 7 && 7 <= 9
		
		//&& : 둘 다 참일 때 참
		
//		a	b	&&	||	!a
//		-------------------
//		0	0	0	0	1 
//		0	1	0	1	1
//		1	0	0	1	0
//		1	1	1	1	0
		
		
		//조건문
		//삼항연산자
		//(조건) ? 참일 때 : 거짓일 때
//		int a, b, c;
//		a = 5;
//		b = 3;
//		
//		c = a > b ? 10 : 0;
//		System.out.println(c);
//		
//		c = (a < b) ? 10 : 0;
//		System.out.println(c);
		
		
		String name = "김철수";
		int money = 1000000;
		int bonusPer = 500/100;
		int bonus = money*bonusPer;
		long allMoney = money * 12 + bonus;
		
		System.out.println("-----------------------------------");
		System.out.println("이름	월급	보너스	총연봉액");
		System.out.println("-----------------------------------");
		System.out.println(name + "	" + money + "	" + bonus + "	" + allMoney);
		System.out.println("-----------------------------------");
		
		
		
		
		
		
		
		
//		int sum = 0;
//		for(int i=0; i<=10; i++) {
//			for(int j=0; j<=i; j++) {
//				System.out.print(i);
//			System.out.println();
//			}
//				
//		}
//		System.out.println("1");
//		int j = 1;
//		while(j < 12) {
//			int i = 0;
//			while(i < j) {
//				System.out.print(j);
//				System.out.println();
//				i++;
//			}
//			j++;
//		}
		
		
		
	}
}

package exam06;

class Tmp{
	String name;
	int money;
	static double iyul = 0.09;
	double total;
	
	public Tmp(String name, int money) {
		this.name = name;
		this.money =money;
		total = money + (money * iyul);
		System.out.println("name:"+total);
	}
	
	
}



public class Test01 {
	public static void main(String[] args) {
		Tmp.iyul = 0.01;
		Tmp t1 = new Tmp("홍길동", 10000);
		new Tmp("이성순", 30000);
		new Tmp("장천용", 50000);
		
		
	}
	
	
	
}

package exam06;

class Test222{
	static int a;
	
	public Test222(int a) {
		this.a = a;
		
	}
	
	public void disp() {
		System.out.println("a:"+a);
	}
	
	
	
}


public class Test111 {
	public static void main(String[] args) {
		Test222 t1 = new Test222(5);
				t1.disp();
		
		new Test222(7).disp();
		
		t1.disp();
		
	}
}

package exam01;

public class Test06 {
	public static void main(String[] args) {

		prn("홍길동", "19");
		prn("100","200","300","400");
		
	}
	
	static void prn(String ... n) {
		int i = 0;
		for(String a : n) {
			System.out.println("n["+i+"] : " + a);
			i++;
		}
	}
	
	
}

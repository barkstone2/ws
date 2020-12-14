package exam08;

public class Test01 {
	
	public static void main(String[] args) {
		
		int[] number = {1,2,3,4,5};
		try {
			System.out.println(number[9]);
		}catch(Exception e) {
			System.out.println("실행중 예외발생");
		}finally {
			System.out.println("무조건 실행된다.");
		}
		
		
		
	}
	
}

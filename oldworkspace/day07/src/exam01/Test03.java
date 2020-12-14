package exam01;


public class Test03 {
	public static void main(String[] args) {
		
		int[][] arr = new int[2][3];
		
		int k = 10;
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j] = k;
				k += 10;
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		
		
		
		
		
		
		
		
		
		
		
	}
}

package exam01;

public class Test02 {
	public static void main(String[] args) {
		
		int[][] nums = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
		
		for(int i=0; i<nums.length; i++) {
			for(int j=0; j<nums[i].length; j++) {
				System.out.println(i+"행 " + j+"열의 값은 " + nums[i][j]+"입니다.");
			}
			System.out.println();
		}
		
		
		
		
	}
}

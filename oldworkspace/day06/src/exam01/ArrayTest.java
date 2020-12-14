package exam01;

import java.util.Arrays;

public class ArrayTest {
	
	public static void main(String[] args) {
		//배열 - array
		//숫자 5개를 저장하려면? 10 20 30 40 50
		
		int[] arr1 = {1,2,3}; //자바
		int arr2[] = {1,2,3}; //C언어
		
		
		int[] nums = {10,20,30,40,50};
		int tot = 0;
		int avg = 0;
		
		for(int i=0; i<nums.length; i++) {
			System.out.println("nums["+i+"]:" +nums[i]);
			tot += nums[i];
		}
		avg = tot/nums.length;
		
		System.out.println("총점: " + tot);
		System.out.println("평균: " + avg);
		
		int[] array = new int[5];
		System.out.println("array:" + array);
		
		for(int i=0; i<array.length; i++) {
			System.out.println("array["+i+"]:" +array[i]);
		}
		
		array[0] = 100;
		array[1] = 200;
		array[2] = 300;
		array[3] = 400;
		array[4] = 500;
		
//		array[5] = 600;
		
		
		
//		System.out.println();
//		System.out.println(Arrays.toString(nums));
		
		
		
		
	}
}

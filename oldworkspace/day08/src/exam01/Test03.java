package exam01;

import java.util.Arrays;

public class Test03 {
	public static void main(String[] args) {

		int[] nums = { 10, 20, 30, 40, 50 };

		new Test03().new Inner().imsi(nums);
		new Test03().imsi(nums);

	}

	class Inner {
		int a = 1;

		void imsi(int[] arr) {
			System.out.println(Arrays.toString(arr));
		}
	}

	void imsi(int[] arr) {
		arr[2] = 300;
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}

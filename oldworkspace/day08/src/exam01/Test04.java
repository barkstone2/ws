package exam01;

public class Test04 {
	public static void main(String[] args) {
		int[] nums = { 10, 20, 30 };
		test(nums[0], nums[1], nums[2]);

		for (int i = 0; i < nums.length; i++) {
			System.out.println("->" + nums[i]);
		}

	}// main end

	static void test(int a, int b, int c) {
		a = 100;
		System.out.printf("a: %d\nb: %d\nc: %d\n", a, b, c);
	}
}

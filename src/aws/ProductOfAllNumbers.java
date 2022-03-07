package aws;

import java.util.Arrays;

public class ProductOfAllNumbers {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(product(nums)));
	}

	static int[] product(int[] nums) {
		int n = nums.length;
		var num = new int[n];
		for (int i = 0; i < n; i++) {
			int product = 1;
			for (int j = 0; j < n; j++) {
				if (i != j) {
					product = product * nums[j];
					num[i] = product;
				}
			}
		}
		return num;
	}

}

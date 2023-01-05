package arrays;

import java.util.Arrays;

public class SetZeroes {

	public static void main(String[] args) {
		int[][] nums = { { 0, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
		System.out.println(Arrays.deepToString(new SetZeroes().setZeroes(nums)));
	}
	/*
	 * [
	 * 	[1, 1, 1]
	 * 	[1, 0, 1]
	 * 	[1, 1, 1]
	 * ]
	 * 
	 * Loop num.length
	 * if num[i][j]== 0
	 * SET num[i][j-1] = 0 //BOTTOM
	 * SET num[i][j+1] = 0 //TOP
	 * SET num[i-1][j] = 0 //LEFT
	 * SET num[i+1][j] = 0 //RIGHT
	 * 
	 * 
	 */

	int[][] setZeroes(int[][] nums) {
		int cols = nums[0].length;
		int rows = nums.length, col0 = 1;
		for (int i = 0; i < rows - 1; i++) {
			if(nums[i][0] == 0) col0 = 0;
			for (int j = 1; j < cols; j++) {
				if(nums[i][j] == 0)
					nums[i][0] = nums[0][j] = 0;
			}
		}
		
		for(int i = rows - 1; i >= 0; i--) {
			for(int j = cols - 1; j >= 1; j--) {
				if(nums[i][0]== 0 || nums[0][j] == 0)
					nums[i][j] = 0;
				
			if(col0 == 0) nums[i][0] = 0;
			}
		}
		return nums;
	}

}

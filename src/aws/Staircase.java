package aws;

import java.util.Arrays;

public class Staircase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numOfWays(5));
	}
	
	static int numOfWays(int n) {
		if(n == 0 || n ==1)
			return 1;
		
		int nums[] = new int[n + 1];
		nums[0] = 1;
		nums[1] = 1;
		
		for(int i = 2; i <= n; i++) {
			nums[i] = nums[i - 1] + nums[i - 2];
			System.out.println("Arrays = "+Arrays.toString(nums) + " nums="+nums[i]);
		}
		return nums[n];
		//return numOfWays(n - 1) + numOfWays(n - 2);
	}

}

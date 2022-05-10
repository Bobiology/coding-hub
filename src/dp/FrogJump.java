package dp;

import java.util.Arrays;

public class FrogJump {
	public static void main(String[] args) {
		int n = 4;
		int[] num = {10, 20, 30, 10};
		System.out.println("opt="+fibOptimized(n, num));
		System.out.println("mem="+frogJump(n, num));
		System.out.println("tab="+fibo(n, num));
	}

	// memoization
	private static int f(int n, int[] heights, int[] dp) {
		if (n == 0)
			return 0;
		if (dp[n] != -1)
			return dp[n];
		int left = f(n - 1, heights, dp) + Math.abs(heights[n] - heights[n - 1]);
		int right = Integer.MAX_VALUE;
		if (n > 1)
			right = f(n - 2, heights, dp) + Math.abs(heights[n] - heights[n - 2]);
		return dp[n] = Math.min(left, right);
	}

	public static int frogJump(int n, int heights[]) {
		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);
		return f(n - 1, heights, dp);
		// return fibo(n, heights);
		//return fibOptimized(n, heights);
	}

	// Tabulation
	private static int fibo(int n, int[] h) {
		int[] dp = new int[n];
		dp[n - 1] = 0;
		for (int i = 1; i < n; i++) {
			int left = dp[i - 1] + Math.abs(h[i] - h[i - 1]);
			int right = Integer.MAX_VALUE;
			if (i > 1)
				right = dp[i - 2] + Math.abs(h[i] - h[i - 2]);

			dp[i] = Math.min(left, right);
		}
		return dp[n - 1];
	}

	// space optimized
	private static int fibOptimized(int n, int[] h) {
		int prev = 0;
		int prev2 = 0;
		for (int i = 1; i < n; i++) {
			int left = prev + Math.abs(h[i] - h[i - 1]);
			int right = Integer.MAX_VALUE;
			if (i > 1)
				right = prev2 + Math.abs(h[i] - h[i - 2]);

			int temp = Math.min(left, right);
			prev2 = prev;
			prev = temp;
		}
		return prev;
	}
}

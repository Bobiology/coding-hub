package dp;

import java.util.Arrays;

public class Fibonacci {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		System.out.println(new Fibonacci().fibOpt(9)); //596041 555292 
		long elapsedTime = System.nanoTime() - startTime;
		System.out.println("time="+elapsedTime);
	}

	//table tabulation dp
	//time complexity: O(n)
	//space complexity: O(n)
	int fib(int n) {
	
		int f[] = new int[n + 1];
		f[0] = 0;
		f[1] = 1;

		for (int i = 2; i <= n; i++) {
			f[i] = f[i - 1] + f[i - 2];
		}
		
		return f[n];
	}
	
	//optimized tabulation
	//time complexity: O(n)
	//space complexity: O(1)
	int fibOpt(int n) {
		int prev2 = 0;
		int prev = 1;
		
		for(int i = 2; i <= n; i++) {
			int curr = prev2 + prev;
			prev2 = prev;
			prev = curr;
		}
		return prev;
	}
	
	
	//recursion
	//time complexity: O(n)
	//space complexity: O(1)
	int fib2(int n) {
		if(n < 2) return n;
		return fib2(n - 1) + fib2(n - 2);
	}
	//memoization
	//time complexity: O(n)
	//space complexity: O(n)
	int fib3(int n) {
		int lookup[] = new int[n+1];
		if(lookup[n] == 0) {
			if(n <= 1)
				lookup[n] = n;
			else
				lookup[n] = fib3(n - 1) + fib3(n - 2);
		}
		System.out.println(Arrays.toString(lookup));
		return lookup[n];
	}
	// Another memoization
	//time complexity: O(n)
	//space complexity: O(n)
	int fibo(int n) {
		int dp[] = new int[n + 1];
		Arrays.fill(dp, -1);
		return fiboEngine(n, dp);
	}
	
	private int fiboEngine(int n, int[] dp) {
		if(n <=1) return n;
		if(dp[n] != -1) return dp[n];

		return dp[n] = fiboEngine(n-1, dp) + fiboEngine(n - 2, dp);
	}
	
	

}

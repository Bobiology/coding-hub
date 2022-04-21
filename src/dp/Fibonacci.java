package dp;

import java.util.Arrays;

public class Fibonacci {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		System.out.println(new Fibonacci().fib3(9)); //596041 555292 
		long elapsedTime = System.nanoTime() - startTime;
		System.out.println("time="+elapsedTime);
	}

	//table tabulation dp
	int fib(int n) {
	
		int f[] = new int[n + 1];
		f[0] = 0;
		f[1] = 1;

		for (int i = 2; i <= n; i++) {
			f[i] = f[i - 1] + f[i - 2];
		}
		
		return f[n];
	}
	//recursion
	int fib2(int n) {
		if(n < 2) return n;
		return fib2(n - 1) + fib2(n - 2);
	}
	//memoization
	
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

}

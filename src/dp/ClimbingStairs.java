package dp;

public class ClimbingStairs {

	public static void main(String[] args) {
		System.out.println(distinctWays(2));
	}
	
	static int getDistinctWays(int n) {
		if(n<=2) return n;
		System.out.println("n="+n);
		return getDistinctWays(n - 1) + getDistinctWays(n - 2);
	}
	
	//Optimized
	static int distinctWays(int n) {
		int prev2 = 1;
		long prev = 1;

		for(int i = 2; i<=n; i++) {
			int current = (int) (prev2 + prev);
			prev2 = (int) prev;
			prev = current;
		}
		return (int) prev;
	}

}

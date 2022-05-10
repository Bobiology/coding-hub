package dp;

public class ClimbingStairs {

	public static void main(String[] args) {
		System.out.println(getDistinctWays(2));
	}
	
	static int getDistinctWays(int n) {
		if(n<=2) return n;
		System.out.println("n="+n);
		return getDistinctWays(n - 1) + getDistinctWays(n - 2);
	}
	
	//Optimized
	static int distinctWays(int n) {
		int prev2 = 1;
		int prev = 1;
		
		for(int i = 2; i<=n; i++) {
			int current = prev2 + prev;
			prev2 = prev;
			prev = current;
		}
		return prev;
	}

}

package aws;

public class EuclideanAlgo {

	public static void main(String[] args) {
		System.out.println("GCD -SUB ="+GCDBySubstraction(12,8));
		System.out.println("GCD -DIV ="+GCDByDivision(12,8));
		
		System.out.println("GCD -BINARY ="+GCDByBinary(12,8,1));
		
		System.out.println("LCM = "+LCM(12,8));

	}
	//Time Complexity = O(n)
	static int GCDBySubstraction(int A,int B) {
		int gcd=0;
		if(A==B) {
			return A;
		}
		if(A>B) {
			gcd=GCDBySubstraction(A-B,B);
		}else {
			gcd=GCDBySubstraction(A,B-A);
		}
		return gcd;
	}
	
	static int GCDByDivision(int A, int B) {
		if(A==B) {
			return A;
		}
		if(A%B==0) { // 8%2===0
			return B; 
		}else {
			return GCDByDivision(B,A%B);
			
		}
	}
	static int GCDByBinary(int a, int b, int res) {
		if(a==b) {
			return res*a;
		}else if(a%2==0 && b%2==0) {
			return GCDByBinary(a%2,b%2,res);
		}else if(a%2==0) {
			return GCDByBinary(a%2,b,res);
		}else if(b%2==0) {
			return GCDByBinary(a, b%2, res);
		}else if(a>b) {
			return GCDByBinary(a-b, b, res);
		}else {
			return GCDByBinary(a, b-a, res);
		}
	}
	
	/**
	 * 
	 * lcm(a,b) = (a.b)/gcd(a,b)
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	static int LCM(int a, int b) {
		int gcd =GCDBySubstraction(a,b);
		int lcm = (a*b)/gcd;
		return lcm;
	}

}

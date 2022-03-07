package aws;

public class CommonPrimeDivisors {

	public static void main(String[] args) {
		int[] A = {15,10,3};
		int[] B = {75,30,5};
		System.out.println(new CommonPrimeDivisors().solution(A, B));

	}
	public int solution(int[] A, int[] B) {
		int count=0;
		for(int i=0;i<A.length;i++) {
			if(samePrimeAdvisor(A[i], B[i])) count++;
			
		}
		return count;
	}
	int gcd(int a,int b) {
		if(a%b==0) return b;
		else return gcd(b,a%b);
	}
	boolean samePrimeAdvisor(int a, int b) {
		int gcdValue = gcd(a,b);
		int gcdA;
		int gcdB;
		
		while(a!=1) {
			gcdA = gcd(a,gcdValue);
			
			if(gcdA==1) break;
			else a=a/gcdA;
		}
		if(a!=1)return false;
		
		while(b!=1) {
			gcdB = gcd(b,gcdValue);
			if(gcdB==1) break;
			else b=b/gcdB;
		}
		return b==1;
	}
	

}

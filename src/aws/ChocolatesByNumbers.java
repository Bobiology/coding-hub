package aws;

public class ChocolatesByNumbers {

	public static void main(String[] args) {
		int N=10,M=4;
		System.out.println("CHOCOS = "+new ChocolatesByNumbers().solution(N,M));
	}

	/**
	 * 
	 * 
	 */
	public int solution(int N, int M) {
		return N/gcdByDivision(N,M);
	}
	private int gcdByDivision(int n, int m) {
		if(n%m==0)return m;
		else return gcdByDivision(m,n%m);
	}

}

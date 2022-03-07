package aws;

public class BalancedParenthesis {

	public static void main(String[] args) {
		String S = "((()))";
		System.out.println(isValidString(S));

	}
	static boolean isValidString(String S) {
		boolean status=true;
		int lower = 0;
		int n = S.length()-1;
		int upper = n;
		
		while(n>=0) {
			System.out.println("LOWER-->"+lower+" LOWER="+S.charAt(lower)+" UPPER-->"+upper+" UPPER="+S.charAt(upper));
			if(S.charAt(lower)=='(' && S.charAt(upper)==')') {
				status = true;
			}else {
				status=false;
			}
			lower++;
			upper--;
			n=n-2;
		}
		return status;
	}

}

package aws;


/*
 * Return medium node of linkedlist
 */
public class PalindromeCheck {

	public static void main(String[] args) {
		String pal = "racecar";
		
		System.out.println(isPalindrome(pal));

	}

	private static boolean isPalindrome(String pal) {
		int n = pal.length()-1;
		if(n < 2) return true;
		int lower = 0; int upper = n;
		while(lower <= upper) {
			if(pal.charAt(lower) != pal.charAt(upper)) {
				return false;
			}
			lower++;
			upper --;
		}
		return true;
	}

}

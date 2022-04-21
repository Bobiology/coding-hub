package aws;

/*
 * Given an integer x, return true if x is palindrome integer.
 * Input: x = 121
 * Output: true
 */
public class PalindromeNumber {

	public static void main(String[] args) {
		int n = 12321;
		System.out.println(new PalindromeNumber().isPalindromeO(n));
	}
	public boolean isPalindrome(int x) {
		String s = String.valueOf(x);
		int n = s.length();
		int left = 0;
		int right = n - 1;
		while(left <=right) {
			if(s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
	//121 % 10 = 1
	public boolean isPalindromeO(int x) {
		int z = 0;
		if(x < 0)return false;
		int y = x;
		
		while(y != 0) {
			int digit = y % 10;
			z = z * 10 + digit;
			y = y / 10;
			
			System.out.println("y="+y+" x="+x+" z="+z);
		}
		
		if(z == x) return true;
		
		return false;
		
	}

}

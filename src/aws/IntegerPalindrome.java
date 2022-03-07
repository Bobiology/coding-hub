package aws;

public class IntegerPalindrome {

	public static void main(String[] args) {
		int num = 12344321;
		System.out.println("Palindrome=" + isPalindrome(num));
	}

	private static boolean isPalindrome(int num) {
		boolean palindrome = false;
		String numS = String.valueOf(num);
		int n = numS.length() - 1;
		int lower = 0;
		int higher = n;
		while (n > 0) {
			if (numS.charAt(lower) == numS.charAt(higher)) {
				lower++;
				higher--;
				palindrome = true;
			} else {
				palindrome = false;
			}
			n--;
		}
		return palindrome;
	}

}

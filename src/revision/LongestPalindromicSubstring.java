package revision;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		String s = "babad";
		LongestPalindromicSubstring l = new LongestPalindromicSubstring();
		System.out.println(l.longestPalindrome(s));

	}

	public String longestPalindrome(String s) {

		if (s == null || s.length() < 1)
			return "";
		int start = 0, end = 0;
		int n = 0;
		for (int i = 0; i < s.length(); i++) {
			int n1 = expandFromMiddle(s, i, i);
			int n2 = expandFromMiddle(s, n, i + 1);
			n = Math.max(n1, n2);

			if (n > (end - start)) {
				start = i - ((n - 1) / 2);
				end = i + (n / 2);
			}
		}

		return s.substring(start, end + 1);

	}

	private boolean isPalindrome(String s) {
		int lower = 0, upper = s.length() - 1;

		while (lower <= upper) {
			if (s.charAt(lower) != s.charAt(upper)) {
				return false;
			}
			lower++;
			upper--;

		}
		return true;
	}

	private int expandFromMiddle(String s, int left, int right) {
		if (s == null && left > right)
			return 0;

		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return right - left - 1;
	}

}

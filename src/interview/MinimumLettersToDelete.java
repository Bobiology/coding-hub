package interview;

import java.util.Arrays;

public class MinimumLettersToDelete {

	public static void main(String[] args) {
		String S ="aaaabbbgggg";
		System.out.println(new MinimumLettersToDelete().getMinimumLettersDeleted(S));
	}

	public int getMinimumLettersDeleted(String S) {
		int[] frequency = new int[26];
		for (int i = 0; i < S.length(); i++) {
			frequency[S.charAt(i) - 'a']++;
		}
		// not very optimal
		Arrays.sort(frequency);
		int maxIndex = frequency.length - 1;
		int count = 0;
		for (int i = maxIndex; i > 0; i--) {
			if (frequency[i - 1] >= frequency[i]) {
				while (frequency[i - 1] != 0 && frequency[i] <= frequency[i - 1]) {
					frequency[i - 1]--;
					count++;
				}
			}
		}
		return count;
	}

}

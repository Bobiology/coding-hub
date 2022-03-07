package interview;

public class Subsequence {

	public static void main(String[] args) {
		int a[] = { 5, 1, 22, 25, 6, -1, 8, 10 };
		int sub[] = { 1, 6, -1, 10 };
		System.out.println(isSubsequence(a, sub));

	}

	static boolean isSubsequence(int[] a, int[] sub) {
		int aIdx = 0;
		int subIdx = 0;
		while (aIdx < a.length && subIdx < sub.length) {
			if (a[aIdx] == sub[subIdx]) {
				subIdx++;
			}
			aIdx++;
		}
		return subIdx==sub.length;
		

	}
}

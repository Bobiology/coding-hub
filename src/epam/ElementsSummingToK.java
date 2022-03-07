package epam;

import java.util.HashMap;

//Given an array of integers, return all pairs of two numbers sum of which is equal to target.
//Given numbers = [2, 5, 6, 4, 7, 18, 9, 1, 8, 11, 15], target = 9
public class ElementsSummingToK {

	public static void main(String[] args) {
		int[] num = { 2, 5, 6, 4, 7, 18, 9, 1, 8, 11, 15 };
		int target = 9;
		// bruteForce(num, target);
		// optimisedSolution(num, target);
		System.out.println(optimisedSolution(num, target));
	}

	/**
	 * 
	 * @param num
	 * @param k   Brute force solution Performance O(n^2)
	 */
	private static void bruteForce(int[] num, int k) {
		int n = num.length;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (k - num[i] == num[j]) {
					System.out.println("integers are: " + num[i] + " and " + num[j]);
				}
			}
		}
	}

	/*
	 * Optimised solution Performance O(n)
	 */
	private static String optimisedSolution(int[] num, int k) {
		int n = num.length;
		HashMap<Integer, Integer> integerMap = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for (int i = 0; i < n; i++) {
			if (num[i] <= k) {
				int nextNum = k - num[i];
				if (integerMap.get(nextNum) != null) {
					sb.append("[" + num[i] + "," + nextNum + "],");
				} else {
					integerMap.put(i, num[i]);
				}
			}
		}
		sb.append("}");
		return sb.toString();
	}

}

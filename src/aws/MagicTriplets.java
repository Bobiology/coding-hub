package aws;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MagicTriplets {

	public static void main(String[] args) {
		int[] siblings = { 1, 8, 3, 0, -1, -3, 6, 7, 2 };

		System.out.println("BRUTE=" + Arrays.toString(getMagicTriplets(siblings)));
		System.out.println("OPTIMIZED=" + Arrays.toString(magicTripletsOptimized(siblings)));

	}
	//BRUTE FORCE : Time O(n^3), SPace O(n^2)
	static String[] getMagicTriplets(int[] siblings) {
		Set<Object> answer = new HashSet<>();
		int n = siblings.length;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					if (siblings[i] + siblings[j] + siblings[k] == 0) {
						answer.add(siblings[i] + "," + siblings[j] + "," + siblings[k]);
						System.out.println("Magic Sibling: i=" + i + " siblings[i]=" + siblings[i] + " j=" + j
								+ " siblings[j]=" + siblings[j] + " k=" + k + " siblings[k]=" + siblings[k]);
					}

				}
			}
		}
		return answer.toArray(new String[0]);

	}

	// Optimized solution
	//Time = O(n^2+n*log(n)), space=O(n^2)
	static String[] magicTripletsOptimized(int[] siblings) {
		Set<Object> magicTriplets = new HashSet<>();
		Arrays.sort(siblings);
		int n = siblings.length;
		for (int i = 0; i < n; i++) {
			int currentElement = siblings[i];
			int neededSum = -currentElement;
			int left = i + 1;
			int right = n - 1;
			while (left < right) {
				int sum = siblings[left] + siblings[right];
				if (neededSum == sum) {
					magicTriplets.add(siblings[i] + "," + siblings[left] + "," + siblings[right]);
					left++;
				} else if (sum > neededSum) {
					right--;
				} else {
					left++;
				}
			}
		}
		return magicTriplets.toArray(new String[0]);

	}

	static void secondTwin(int i, int[] siblings) {
		HashMap<Integer, Integer> siblingMap = new HashMap<>();
		int n = siblings.length;
		// int thirdSibling=0;
		for (int j = i; j < n; j++) {
			// thirdSibling = 0 -(siblings[i]+siblings[j]);
			if (siblingMap.get(0 - (siblings[i] + siblings[j])) != null) {
				System.out.println("1st sibling=" + siblings[i]);
				System.out.println("2nd sibling=" + siblings[j]);
				System.out.println("3rd sibling=" + siblingMap.get(0 - (siblings[i] + siblings[j])));
			} else {
				siblingMap.put(j, siblings[j]);
			}
		}
	}

}

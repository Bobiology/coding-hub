package ms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IndicesAddingTarget {

	public static void main(String[] args) {
		//int[] arr = { 2, 4, 2, 1, 7 };
		int [] arr ={2,5,9,1,4,6};
		int a = 15;
		//System.out.println(Arrays.toString(anotherSoln(arr, a)));
		System.out.println(Arrays.toString(getIndicesOfItemWeights(arr, a)));

	}

	/**
	 * m=2 {(2+4),(2+7),(2+2),(2+1),(2+7)}
	 * 
	 * @param arr
	 * @param target
	 * @return
	 */
	static int[] mySolution(int[] arr, int target) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i] + arr[j] == target) {
					return new int[] { i, j };
				}
			}
		}
		return null;

	}
//Overall complexity {O(n)}
	  static int[] getIndicesOfItemWeights(int[] arr, int limit) {
			//Make length of array static(n). This increases performance
	    int n = arr.length; //space complexity {O(1)}
			Map<Integer, Integer> map = new HashMap<>(); //space complexity {O(n)}
			int diff = 0; //space complexity {O(1)}
			for (int i = 0; i < n; i++) { //time complexity {O(n)}
				diff = limit - arr[i];
				if (map.containsKey(diff)) {
					if (map.get(diff) < i) { //time complexity {O(1)}
						return new int[] { i, map.get(diff) };
					} else {
						return new int[] { map.get(diff), i };
					}
				}
				map.put(arr[i], i); //time complexity {O(1)}
			}
			return new int[] {};
	  }

	static int[] anotherSoln(int[] arr, int t) {
		Map<Integer, Integer> map = new HashMap<>();
		int n = arr.length;
		int diff = 0;
		for (int i = 0; i < n; i++) {
			diff = t - arr[i];
			if (map.containsKey(diff)) {
				return new int[] { map.get(diff), i };
			} else {
				map.put(arr[i], i);
			}
		}
		return arr;

	}

}

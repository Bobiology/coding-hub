package hashMap;

import java.util.HashMap;
import java.util.Map;
/*
 * Given an array of integers, count the number of unique pairs of integers 
 * that have difference k. 
 * Input: [1, 7, 5, 9, 2, 12, 3] K=2 Output: 
 * 4 We have four pairs with difference 2: (1, 3), (3, 5), (5, 7), (7, 9). 
 * Note that we only want the number of these pairs, not the pairs themselves.
 */
public class CountPairsWithDifference {

	public static void main(String[] args) {
		int[] num = {1, 7, 5, 9, 2, 12, 3};
		int K = 2;
		System.out.println(countPairsWithDiff(num, K));
	}

	private static int countPairsWithDiff(int[] num, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		int count = 0;
		for(int i : num) {
			map.put(i, 1);
		}
		
		for(int i : num) {
			int diff = Math.abs(i - k);
			if((i - diff)>0 && map.containsKey(diff)) {
				System.out.println("{" + i + ", " + diff + "} ==> difference = " + (int)(i  - diff));
				count ++;
			}
		}
		
		return count;
	}

}

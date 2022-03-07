package hashMap;

import java.util.HashMap;
import java.util.Map;

/*
 * 
 * Find the most repeated element in an array of integers. 
 * What is the time complexity of this method? 
 * (A variation of this exercise is finding the most repeated word in a sentence. 
 * The algorithm is the same. Here we use an array of numbers for simplicity.)  
 * Input: [1, 2, 2, 3, 3, 3, 4] 
 * Output: 3
 * 
 */
public class MostRepeatedInteger {

	public static void main(String[] args) {
		int[] A = {1, 2, 2, 3, 3, 3, 4};
		MostRepeatedInteger m = new MostRepeatedInteger();
		System.out.println(m.mostFrequent(A));
	}
	int mostFrequent(int[] a) {
		Map<Integer, Integer> map = new HashMap<>();
		int count = 0;
		int value = -1;
		for(int i : a) {
			if(map.containsKey(i))
				map.put(i, map.get(i)+1);
			else
				map.put(i, 1);
		}
		for(var entry : map.entrySet()) {
			var entryValue = entry.getValue();
			if(entryValue>count) {
				count = entryValue;
				value = entry.getKey();
			}
		}
		return value;
	}
}

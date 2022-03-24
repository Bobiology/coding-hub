package hackerrank1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaximumGreatness {

	public static void main(String[] args) {
		//var list = new ArrayList<Integer>(Arrays.asList(1, 3, 5, 2, 1, 3, 1));
		//var list = new ArrayList<Integer>(Arrays.asList(4, 1, 6, 3));
		var list = new ArrayList<Integer>(Arrays.asList(1, 2, 6, 3, 2, 1));
		System.out.println(findMaximumGreatness(list));

	}
	
	public static int findMaximumGreatness(List<Integer> arr) {
		
		Collections.sort(arr);
		int count = 0;
		int n = arr.size()-1;
		System.out.println(arr);
		while(n > 0) {
			if(n - 1 >1 && arr.get(n) == arr.get(n -1))
				count++;
			if(arr.get(n) > arr.get(n -1)) {
				count++;
			}
			n--;
		}
		
		return count;
	}

}

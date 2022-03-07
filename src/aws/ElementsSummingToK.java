package aws;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ElementsSummingToK {

	public static void main(String[] args) {
		int[] num = { 3, 7, 1, 2, 6 };
		int k = 9;
		//System.out.println("LOOP="+getElements(num, k));
		System.out.println("MAP="+getElementsAnother(num, k));

	}

	//O(n)
	private static String getElements(int[] num, int k) {
		Arrays.sort(num);
		int n = num.length;
		StringBuilder nums = new StringBuilder();
		int lower = 0;
		int upper = n - 1;
		
		while (n >= 0) {
			int firstNum = num[lower];
			int nextNum = k - firstNum;
			if (nextNum == num[upper]) {
				nums.append("[");
				nums.append(firstNum);
				nums.append(",");
				nums.append(nextNum);
				nums.append("]");
				break;
			}else if(nextNum<num[upper]) {
				upper--;
			}else {
				lower++;
			}
			n--;
		}

		return nums.toString();
	}
	//O(n)
	private static String getElementsAnother(int[] num, int k) {
		Map<Integer, Integer> elementMap = new HashMap<>();
	    int n = num.length;
	    StringBuilder nums = new StringBuilder();
	    for(int i=0;i<n;i++) {
	    	elementMap.put(i, num[i]);
	    }
	    
	    for(Entry<Integer, Integer> entry: elementMap.entrySet()) {
	    	int firstNum = entry.getValue();
	    	int nextNum = k - firstNum;
	    	if(entry.getValue()==elementMap.get(nextNum)) {
	    		nums.append(firstNum);
				nums.append(",");
				nums.append(nextNum);
				//System.out.println("==="+num);
				//break;
	    	}
	    }
	    
		return nums.toString();
	}

}

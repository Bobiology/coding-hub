package revision;

import java.util.Arrays;

public class ThreeLargestNumbers {

	public static void main(String[] args) {
		int[] num = {141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7};
		System.out.println(Arrays.toString(findThreeLargestNumbers(num)));
	}
	public static int[] findThreeLargestNumbers(int[] array) {

		int[] newArray = new int[3];
		int n = array.length;
		// Find first largest element
	    int first = array[0];
	    for (int i = 1;i < n ; i++)
	        if (array[i] > first)
	            first = array[i];
	 
	    // Find second largest element
	    int second = Integer.MIN_VALUE;
	    for (int i = 0; i < n ; i++)
	        if (array[i] > second && array[i] < first)
	            second = array[i];
	 
	    // Find third largest element
	    int third = Integer.MIN_VALUE;
	    for (int i = 0; i < n ; i++)
	        if (array[i] > third && array[i] < second)
	            third = array[i];
	 
	    newArray[0] = third;
	    newArray[1] = second;
	    newArray[2] = first;
		return newArray;
	}

}

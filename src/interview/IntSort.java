package interview;

import java.util.Arrays;

public class IntSort {
	public static void main(String[] args) {
		int[] a = {1,0,3,3,2,0,0,1,9,4};
		simpleSort(a);
		System.out.println(Arrays.toString(a));
	}
	
	static int[] simpleSort(int[] arr) {
		for(int i=0;i<arr.length-1;i++) {
			if(arr[i]>arr[i+1]) {
				int holder = arr[i];
				arr[i]=arr[i+1];
				arr[i+1]=holder;
				i=-1;
			}
		}
		return arr;
	}
}

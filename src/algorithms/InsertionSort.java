package algorithms;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int[] a = { 9, 6, 5, 0, 3, 4, 1, 2, 14, 10 };
		System.out.println(Arrays.toString(sort(a)));
		
		char ch = 'a';
		
		System.out.println(Character.isAlphabetic(ch));

	}

	static int[] sort(int[] a) {
		int current = 0;
		for (int i = 1; i < a.length; i++) {
			current = a[i];
			int j = i - 1;
			while (j >= 0 && a[j] > current) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = current;
		}
		return a;
	}

}

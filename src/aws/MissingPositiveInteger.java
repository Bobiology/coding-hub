package aws;

import java.util.Arrays;

public class MissingPositiveInteger {

	public static void main(String[] args) {
		int[] num = {3, 4, -1, 1};
		System.out.println(positiveInteger(num));

	}
	static int positiveInteger(int[] num) {
		Arrays.sort(num);
		int count = 1;
		for(int i = 0; i < num.length; i++) {
			if(num[i] == count) {
				count++;
			}
		}
		return count;
	}

}

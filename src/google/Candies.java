package google;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Candies {
	public static void main(String[] arg) {

		int totalCandies = 0;
		int candiesLeft = 0;
		Scanner in = new Scanner((Readable) new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			int m = in.nextInt();
			for (int j = 0; j < n; j++) {
				totalCandies += in.nextInt();
			}
			candiesLeft = totalCandies % m;
			System.out.println("Case #" + i + ": " + candiesLeft);
		}
	}

	static String candiesSharing(int caseId, int candyBags, int kids, int[] candies) {
		int totalCandies = 0;
		int candiesLeft = 0;
		for (int i = 0; i < candyBags; i++) {
			totalCandies += candies[i];
		}
		candiesLeft = totalCandies % kids;
		return "Case #" + caseId + ": " + candiesLeft;
	}

}
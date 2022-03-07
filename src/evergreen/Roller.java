package evergreen;

import java.util.Arrays;

public class Roller {
	public static void main(String[] args) {
		int[] x = { 0,3,6,5 };
		int[] y = { 0,3,2,4 };
		int w = 1;
		System.out.println("Trips: "+numberOfTrips(x, y, w));
	}

	static int numberOfTrips(int[] x, int[] y, int w) {
		int trips = 0;
		Arrays.sort(y);
		Arrays.sort(x);
		System.out.println("Sorted Array: "+Arrays.toString(x));
		for (int i = 0; i < x.length - 1; i++) {
			if (x[i] <=x[i + 1] && i < x.length) {
				trips++;
			}
		}
		return trips;

	}

}

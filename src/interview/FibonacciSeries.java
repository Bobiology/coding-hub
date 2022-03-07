package interview;

import java.util.ArrayList;

public class FibonacciSeries {
	// next number = sum of 1st 2 numbers
	public static void main(String[] args) {
		int n =29;
		System.out.println(myFibonacci().get(16));
		System.err.println(myFibonacciNth(n).get(n-1));
	}

	static ArrayList<Integer> myFibonacci() {
		ArrayList<Integer> series = new ArrayList<>();
		series.add(1);
		series.add(1);
			while(series.get(series.size()-1)<1000) {
				series.add(series.get(series.size()-1)+series.get(series.size()-2));
			}
		return series;

	}
	static ArrayList<Integer> myFibonacciNth(int n) {
		ArrayList<Integer> series = new ArrayList<>();
		series.add(1);
		series.add(1);
			while(n>series.size()) {
				series.add(series.get(series.size()-1)+series.get(series.size()-2));
			}
		return series;

	}

}

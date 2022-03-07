package interview;

public class SmallestNumberWithSameDigits {
	public static void main(String[] args) {
		int N = 125;
		System.out.println(smallest(N));
	}

	public static int smallest(int N) {
		int smallestNumber = 0;
		if (N <= 1 || String.valueOf(N).length() == 1) {
			return smallestNumber;
		}
		int numberOfDigits = String.valueOf(N).length();
		return (int) Math.pow(10, numberOfDigits - 1);
	}
}

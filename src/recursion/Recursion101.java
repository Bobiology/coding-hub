package recursion;

public class Recursion101 {

	public static void main(String[] args) {
		// 4! = 4 x 3 x 2 x 1
		// 3! = 3 x 2 x 1

		System.out.println(" ==> " + factorial(4));
		System.out.println("Recursion = "+factorialByRecursion(4));
	}

	// implementation
	static int factorial(int i) {
		int factorial = 1;
		while (i > 0) {
			factorial = i * factorial;
			i--;
		}
		return factorial;
	}

	static int factorialByRecursion(int n) {
		if (n <= 1) {
			return n;
		}
		return n * factorialByRecursion(n - 1);
	}
}

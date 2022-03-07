package aws;

public class Fibonacci {

	public static void main(String[] args) {

		//System.out.println(fibo(11));
		//System.out.println("FAST FIBONACCI = " + new Fibonacci().fibonacciAlgorithm(10));
		System.out.println("FAST FIBONACCI 2 = " + new Fibonacci().fibonacciSeries(10));

		//System.out.println(fibonacciSeries(9));
	}

	static int fibo(int n) {
		if (n < 2) {
			return n;
		}
		//int num = fibo(n - 1) + fibo(n - 2);
		//System.out.print(n+" ");
		return fibo(n - 1) + fibo(n - 2);
	}

	/* Time Complexity O(log n) 
	 * Space complexity O(1)
	 * formula => Fn = {[(√5 + 1)/2] ^ n} / √5 
	 * */
	int fibonacciAlgorithm(int n) {
		return (int) ((double) (
			Math.pow(((1 + Math.sqrt(5)) / 2), n) 
			- Math.pow(((1 - Math.sqrt(5)) / 2), n))
			/ Math.sqrt(5));
	}
	
	int fibonacciAlgorithm2(int n) {
		return (int) ((double)((Math.pow(((1+Math.sqrt(5))/2), n) - Math.pow(((1-Math.sqrt(5))/2), n))/ Math.sqrt(5)));
	}
	
	static int fibonacciSeries(int n) {
		int value=0;
		if(n<2) {
			return n;		
			}else {
			 value+= fibonacciSeries(n-1)+fibonacciSeries(n-2);
				//System.out.print(value+", ");
				
			}
		
		return value;
	}

}

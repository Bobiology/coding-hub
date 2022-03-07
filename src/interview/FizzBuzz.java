package interview;

public class FizzBuzz {
	public static void main(String[] args) {
		int n =50;
		myFizzBuzz(n);
	}
	static void myFizzBuzz(int a) {
		int i=1;
		while (i<a) {
			if(i%3==0 && i%5==0) {
				System.out.println(i+ ": FizzBuzz");
			}else if(i%3==0) {
				System.out.println(i+ ": Fizz");
			}
			else if(i%5==0) {
				System.out.println(i+ ": Buzz");
			}else {
				//System.err.println(i);
			}
			i++;
		}
	}

}

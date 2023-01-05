package recursion;

public class PrintNameNTimes {

	public static void main(String[] args) {
		new PrintNameNTimes().printName(5);
	}
	
	void printName(int n) {
		if(n == 0) return;
		
		System.out.println("Bob");
		
		printName(--n);
	}

}

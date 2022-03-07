package codility;

import java.util.Scanner;

public class ReducedForm {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		// Declare the variable
		int testCases;

		// Read the variable from STDIN
		int num=0;
		testCases = in.nextInt();
		while (testCases > 0) {
			 num= in.nextInt();
			 int[] elements = new int[num];
			System.out.println("num: " + num);
			if (num > 0) {
				int i=0;
				while (num>0) {
					
					int holder = in.nextInt();
					//testCases[i]=holder;
					System.out.println("holder: " + holder);
					num--;
					i++;
			 }
			}
			testCases--;
		}
		// Output the variable to STDOUT
		System.out.println(testCases);

	}

}

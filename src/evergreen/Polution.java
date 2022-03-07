package evergreen;

import java.util.Arrays;

public class Polution {

	public static void main(String[] args) {
		int[] a = { 5, 19, 8, 1 };
		System.out.println(solution(a));
	}

	static int solution(int[] A) {
		Arrays.sort(A);
		int filters = 0;
		double population = 0.0;
		double expectedPopulation = 0.0;
		int[] myA = new int[A.length];
		for (int i = A.length; i > 0; i--) {
			
			expectedPopulation = expectedPopulation + A[i-1];
		}
		
		for (int k = A.length; k > 0; k--) {
			myA[k-1] = A[k-1]/2;
			Arrays.sort(myA);
			for (int j = k; j >0; j--) {
				filters++;
				population = population + A[j-1];
			}
			if(population>=expectedPopulation/2) {
				
			}
		}
		

		System.out.println("Expected polution: " + expectedPopulation / 2);
		System.out.println("population: " + population);
		System.out.println("myA: " + Arrays.toString(myA));

		return filters;
	}

}

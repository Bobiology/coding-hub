package evergreen;

import java.util.Arrays;

public class NonIntersecting {

	public static void main(String[] args) {
		int a [] = {10,1,3,1,2,2,1,0,4};
		System.out.println(mySolution(a));
	}
	static int mySolution(int [] A) {
		int count =0;
		int [] myArray = new int[A.length];
		for(int i =0; i<A.length-1;i=i+2) {
			if(i%2==0 && (i+1)%2==1) {
			myArray[i] =A[i]+A[i+1];
			}
		}
		Arrays.sort(myArray);
		int max = myArray[myArray.length-1]; 
		for(int j=0;j<myArray.length;j++) {
			if(myArray[j]==max) {
				count++;
			}
		}
		System.out.println("My Array: "+Arrays.toString(myArray)+": max : "+max);
		return count;
	}
}

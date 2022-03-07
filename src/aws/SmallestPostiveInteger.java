package aws;

import java.util.Arrays;

public class SmallestPostiveInteger {

	public static void main(String[] args) {
		int[] A = {7,3,6,4,5,2};
		//System.out.println(new SmallestPostiveInteger().solution(A));
		//addIntegers();
		reverseArray();

	}
	public int solution(int[] A) {
		int smallestInteger=0;
		boolean endOfArray = false;
		Arrays.sort(A);
		int n = A.length-1;
		if(A[n]<0) {
			return 1;
		}
		System.out.println("NEW ARRAY = "+Arrays.toString(A));
		for(int i=0;i<n;i++) {
			System.out.println("i ="+i+" a[i] = "+A[i]+"  a[i+1] = "+A[i+1]);
			if((A[i+1]-A[i])>1 && smallestInteger<0) {
				System.err.println("INSIDE IF");
				smallestInteger = A[i]+1;
				 //System.out.println("i = "+i+" A.legnth = "+n);
			} else if(smallestInteger<0 && i==n){
                smallestInteger=A[i]+1;
            }

		}
		
		return smallestInteger;
	}
	
	static void addIntegers() {
		int[] A = {1,2,3};
		int[] B = {4,5,6};
		//1st add A[i] to b[j]
		
		for(int i = 0,j=0;i<A.length && j<B.length;i++,j++) {
		//System.out.println("i == "+i+" A[i] = "+A[i]);
		//System.out.println("i == "+j+" B[j] ="+B[j]);
			//A[A.length+j]=B[j];
		}
		
		//System.out.println("Clone A = "+Arrays.toString(A)+Arrays.toString(B));
	}
	
	static void reverseArray() {
		int[] A = {1,2,3,4,5,6};
		int n=A.length;
		int[] B = new int[n];
		for(int i=n-1,j=0;i>=0 && j<n;i--,j++) {
			//System.out.println(A[i]);
			B[j]=A[i];
			//System.out.println("B = "+Arrays.toString(B));
		}
		System.out.println(Arrays.toString(B));
	}

}

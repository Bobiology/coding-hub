package codility;

import static org.junit.jupiter.api.DynamicTest.stream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.IntStream;
public class MinimumPositiveInteger {

	public static void main(String[] args) {
		int[] A = {-1,-3,0,1,3,4,2};
		System.out.println(new MinimumPositiveInteger().solution(A));

	}
//O(n)
	public int solution(int[] A) {
		int smallestInteger=0;
		HashMap<Integer,Integer> integersMap = new HashMap<>();

		//Stream
		//Arrays.stream(A).forEach(i ->integersMap.put(i, i));
		Arrays.stream(A)
			.filter(x -> x>0)
			.forEach(i ->integersMap.put(i, i));
		/*
		for(int i=0;i<A.length;i++)
			if(A[i]>0) integersMap.put(A[i],A[i]);
		*/
		System.out.println("MAP="+integersMap);
		
		int integerSize =integersMap.size()+1;
		if(integerSize<1)smallestInteger=1;
		
		//IntStream.of(integerSize).filter(x ->integersMap.getOrDefault(x, 0)).forEach(smallestInteger=);
				
		for(int i=1;i<=integerSize;i++)
			if(i>0 && i !=integersMap.getOrDefault(i, 0)) smallestInteger= i;
		
		return smallestInteger;
		
	}

}

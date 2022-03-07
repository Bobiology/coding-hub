package aws;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DivisibleSumPair {

	public static void main(String[] args) {
		List<Integer> ar = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
		int k = 5;
		int n = ar.size();
		System.out.println(divisibleSumPairs(n, k, ar));
	}

	public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
		int countOfPairs = 0;
		for(int i=0;i<(n-1);i++){
            for(int j=0;j<n;j++){
                if(i<j){
                    if((ar.get(i)+ar.get(j))%k==0)
                    	countOfPairs++;
                }
            }
        }
		return countOfPairs;
	}

}

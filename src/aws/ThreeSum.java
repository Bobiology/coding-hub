package aws;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeSum {
/**
 * 
 * Given an array of integers, nums, return all the 
 * triplets in the given array nums[i], nums[j], nums[k] such 
 * that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * 
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 */
	public static void main(String[] args) {
		int nums[] = {-1,0,1,2,-1,-4};
		long startTime = System.nanoTime();
		System.out.println(threeSumBF(nums));
		System.out.println("B="+(System.nanoTime() - startTime));
		
		long startTime1 = System.nanoTime();
		System.out.println(threeSumBFO(nums));
		System.out.println("O="+(System.nanoTime() - startTime1));
		long startTime2 = System.nanoTime();
		System.out.println(threeSum(nums));
		System.out.println("P="+(System.nanoTime() - startTime2));
	}
	//BRUTE FORCE
	public static List<List<Integer>> threeSumBF(int[] nums){
		List<List<Integer>> result =  new ArrayList<>();
		int n = nums.length;
		for(int i = 0; i< n; i++) {
			for(int j = i + 1; j < n; j++) {
				for(int k = j + 1; k < n; k++) {
					if((nums[i] + nums[j] + nums[k]) == 0) {
						List<Integer> list = new ArrayList<>();
						list.add(nums[i]);
						list.add(nums[j]);
						list.add(nums[k]);
						Collections.sort(list);
						if(!result.contains(list))
							result.add(list);
					}
				}
			}
		}
		return result;
	}
	//BRUTE FORCE OPTIMIZED
	public static List<List<Integer>> threeSumBFO(int[] nums){
		Set<List<Integer>> result =  new HashSet<>();
		int n = nums.length;
    
		for(int i = 0; i< n; i++) {
			Set<Integer> set = new HashSet<>();
            int runningSum = 0 - nums[i];

			for(int j = i + 1; j < n; j++) {
                //int target = 0 -(nums[i] + nums[j]);
                int comp = runningSum - nums[j];
                if(set.contains(comp)) {
						List<Integer> list = new ArrayList<>(Arrays.asList(nums[i],nums[j],comp));
						Collections.sort(list);
						result.add(list);
					}
                set.add(nums[j]);
			}
			
		}
		return new ArrayList<List<Integer>>(result);
	}
	
	public static List<List<Integer>> threeSum(int[] nums){
		int n = nums.length;	
		List<List<Integer>>result = new ArrayList<>();
		
		Arrays.sort(nums);
		for(int i = 0; i+2 < n; i++) {
			if(i > 0 && nums[i]==nums[i - 1]) {
				continue;
			}
			int leftPointer = i + 1;
			int rightPointer = n -1;
			while(leftPointer < rightPointer) {
				int sum = nums[i]+nums[leftPointer]+nums[rightPointer];
				if(sum == 0) {					
					result.add(Arrays.asList(nums[i], nums[leftPointer], nums[rightPointer]));
					rightPointer--;
					leftPointer++;
					while(leftPointer < rightPointer && nums[rightPointer]== nums[rightPointer + 1]) rightPointer--;
				}
				else if(sum < 0){
					leftPointer++;
				}else {
					rightPointer --;
				}
			}
		}
		return result;
	}

}

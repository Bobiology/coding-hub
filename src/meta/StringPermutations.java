package meta;

import java.util.ArrayList;
import java.util.List;

public class StringPermutations {

	public static void main(String args[]) {
		permutation("123");
		
		int[] nums =  {1, 2, 3};
		StringPermutations sp = new StringPermutations();
		
		System.out.println("ANS="+sp.permute(nums));
	}

	/*
	 * A method exposed to client to calculate permutation of String in Java.
	 */
	public static void permutation(String input) {
		permutation("", input);
	}

	/*
	 * Recursive method which actually prints all permutations of given String, but
	 * since we are passing an empty String as current permutation to start with, I
	 * have made this method private and didn't exposed it to client.
	 */
	private static void permutation(String perm, String word) {
		if (word.isEmpty()) {
			System.err.println(perm);
			return;

		}
		for (int i = 0; i < word.length(); i++) {
			//System.out.println("perm="+perm+" word.charAt(i)="+word.charAt(i)+" i="+i+" word.substring(0, i)="+word.substring(0, i)+"  word.substring(i + 1, word.length())"+ word.substring(i + 1, word.length())+" word.length()="+word.length());
			permutation(perm + word.charAt(i), word.substring(0, i) + word.substring(i + 1, word.length()));
		}

	}
	
	//ANOTHER SOLUTION
	private void recurPermute(int[] nums, List<Integer> ds, List<List<Integer>> ans, boolean [] freq) {
		if(ds.size() == nums.length) {
			ans.add(new ArrayList<>(ds));
			return;
		}
		
		for(int i = 0; i< nums.length; i++) {
			if(!freq[i]) {
				freq[i] = true;
				ds.add(nums[i]);
				recurPermute(nums, ds, ans, freq);
				ds.remove(ds.size() - 1);
				freq[i] = false;
			}
		}
	}
	
	public List<List<Integer>> permute(int[] nums){
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> ds = new ArrayList<>();
		boolean freq[] = new boolean[nums.length];
		recurPermute(nums, ds, ans, freq);
		
		return ans;
	}
	
	
	//OPTIMIZED SOLUTIONS
	private void recurPermute2(int index, int[] nums, List<List<Integer>> ans) {
		if(index == nums.length) {
			//copy ds to ans
			List<Integer> ds = new ArrayList<>();
			for(int i = 0; i<nums.length; i++)
				ds.add(nums[i]);
			
			ans.add(new ArrayList<>(ds));
			return;
		}
		
		for(int i = index; i <nums.length; i++) {
			swap(i, index, nums);
			recurPermute2(index+1, nums, ans);
			swap(i, index, nums);
		}
	}
	
	private void swap(int i, int j, int[] nums) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
		
	}
	
	public List<List<Integer>> permuter(int[] nums){
		List<List<Integer>> ans = new ArrayList<>();
		recurPermute2(0, nums, ans);
		
		return ans;
	}
	
}
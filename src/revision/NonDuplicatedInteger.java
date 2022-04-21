package revision;
/**
 * 
 * @author sakawabob
 *
 *Given an array of integers where every integer occurs three times 
 *except for one integer, which only occurs once, find and return the 
 *non-duplicated integer.
 *
 *Given [6, 1, 3, 3, 3, 6, 6], return 1. 
 *Given [13, 19, 13, 13], return 19.
 */
public class NonDuplicatedInteger {

	public static void main(String[] args) {
		int[] nums = {6, 1, 3, 3, 3, 6, 6};
		System.out.println(findNonDuplicatedInteger(nums));
	}
	static int findNonDuplicatedInteger(int[] nums) {
		int n = nums.length;
		int uniqueNumber = 0;
		int count = 0;
		for(int i = 0; i< n; i++) {
			if(uniqueNumber == nums[i]) {
				count+=1;
			}else {
				uniqueNumber = nums[i];
				count = 0;
			}
		}
		return uniqueNumber;
	}

}

package google;
import java.util.*;

public class SumToTarget {

	public static void main(String[] args) {
		int[] nums = {10,15,3,7};
		int k = 17;
		
		System.out.println(summingToK(nums, k));
	}
	static boolean summingToK(int[] list, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for(var i: list) {
			var difference = target - i;
			if(map.containsKey(difference))
				return true;
			map.put(i, 1);
		}
		return false;
		
	}

}

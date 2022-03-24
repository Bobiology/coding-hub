package aws;

public class ASCII {

	public static void main(String[] args) {
		int ascii = 'a' - 'A';
		
		System.out.println(ascii);
		int[] a = {1, 2, 3, 4, 5, 6};
		int b = 3;
		System.out.println(indexOfK(a, b));

	}
	static int indexOfK(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;

		while (low <= high) {
			// Finding the mid using floor division
			int mid = low + ((high - low) / 2);

			// Target value is present at the middle of the array
			if (nums[mid] == target) {
				return mid;
			}

			// Target value is present in the low subarray
			else if (target < nums[mid]) {
				high = mid - 1;
			}

			// Target value is present in the high subarray
			else if (target > nums[mid]) {
				low = mid + 1;
			}
		}

		// Target value is not present in the array
		return -1;
	}

}

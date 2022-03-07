package aws;

/*
 * Given an array of integers, print sums of all subsets in it. 
 * Output sums can be printed in any order.
 * 
 */
public class SubsetSum {

	public static void main(String[] args) {
		int arr[] = {2, 4, 5}; // 0, 2, 4, 5, 6, 7, 9, 11
		subsetSum(arr);
	}
	
	static void subsetSum(int[] arr) {
		int n = arr.length;
		
		int total = 1 << n;
		
		for(int i = 0; i < total; i++) {
			int sum = 0;
			
			for(int j = 0; j < n; j++) {
				if((i & (1 << j)) != 0){
					sum += arr[j];
				}
			}
			System.out.println("sum="+sum);
		}
	}

}

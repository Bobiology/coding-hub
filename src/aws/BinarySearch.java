package aws;

public class BinarySearch {

	public static void main(String[] args) {
		int[] num = {0,1,2,3,4,5,6,7,8,9};
		int i = 9;
		System.out.println(getIndexOfK(num,i));
	
}
	// O(log n)
	static int getIndexOfK(int[] num, int i) {
		int n=num.length;
		int low =0;
		int high =n;
		int mid = (low+high)/2;

		while(low<high) {
			mid = (low+high)/2;
			if(num[mid]==i) {
				return mid;
			}else if(num[mid]<i) {
				low++;
			}else {
				high++;
			}
		}
		
		return mid;
	}

}

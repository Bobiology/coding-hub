package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSortDemo {
	static int count = 0;
	public MergeSortDemo() {
		// TODO Auto-generated constructor stub
	}

	// Merges two subarrays of arr[]. 
		// First subarray is arr[l..m] 
		// Second subarray is arr[m+1..r] 
		 void merge(int[] arr, int l, int m, int r) 
		{ 
			
			// Find sizes of two subarrays to be merged 
			int n1 = m - l + 1; 
			int n2 = r - m; 

			// Create temp arrays /
			int L[] = new int [n1]; 
			int R[] = new int [n2]; 

			/*Copy data to temp arrays*/
			for (int i=0; i<n1; ++i) 
				L[i] = arr[l+i]; 
			for (int j=0; j<n2; ++j) 
				R[j] = arr[m + 1+ j]; 


			// Merge the temp arrays /

			// Initial indexes of first and second subarrays 
			int i = 0, j = 0; 

			// Initial index of merged subarry array 
			int k = l; 
			while (i < n1 && j < n2) 
			{ 
				if (L[i] <= R[j]) 
				{ 
					arr[k] = L[i]; 
					i++; 
				} 
				else
				{ 
					arr[k] = R[j];
					j++;
					count++;
				} 
				k++; 
			} 

			// Copy remaining elements of L[] if any /
			while (i < n1) 
			{ 
				arr[k] =  L[i];
				
				i++; 
				k++; 
			} 

			// Copy remaining elements of R[] if any /
			while (j < n2) 
			{ 
				arr[k] =  R[j];
				j++; 
				k++; 
			} 
		} 

		 // Main function that sorts arr[l..r] using 
		// merge() 
		void sort(int[] arr, int l, int r) 
		{ 
			if (l < r) 
			{ 
				// Find the middle point 
				int m = (l+r)/2; 

				// Sort first and second halves 
				sort(arr, l, m); 
				sort(arr , m+1, r); 

				// Merge the sorted halves 
				merge(arr, l, m, r); 
			} 
		} 

		public static int largestCountValue(List<Integer> a) {
			int n = a.size();
			int[] ar = new int[n];
			for(int i=0; i<n;i++) {
				ar[i] = a.get(i);
			}
			new MergeSortDemo().sort(ar, 0, a.size()-1);
			return count;
		}

		//A utility function to print array of size n 
		static void printArray(int[] arr) 
		{ 
			int n = arr.length; 
			for (int i=0; i<n; ++i) 
				System.out.print(arr[i] + " "); 
			System.out.println(); 
		} 
		

		// Driver method 
		public static void main(String args[]) 
		{ 
			//int arr[] = {12, 11, 13, 5, 6, 7};
			//int arr[] = {2,1,3}; //1
			//int arr[]= {1,2,3,4,5,10};//0
			int arr[]={1,2,3,4,5,10};
			//List<Integer> arr = new ArrayList<>(Arrays.asList(1,2,3,4,5,10));

			System.out.println("Given Array"); 
			printArray(arr); 

			MergeSortDemo ob = new MergeSortDemo(); 
			new MergeSortDemo().sort(arr, 0, arr.length-1); 

			System.out.println("\nSorted array"); 
			printArray(arr);
			
			System.out.println("count="+count);
		} 

}

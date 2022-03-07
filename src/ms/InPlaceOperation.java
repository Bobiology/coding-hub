package ms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class InPlaceOperation {

	public static void main(String[] args) {
		int[] arr = { 17, 18, 5, 4, 6, 1 };
		System.out.println(Arrays.toString(replaceElements(arr)));
	}

	/**
	 * input: arr =[17,18,5,4,6,1] output: arr =[18,6,6,6,1,-1] working left of
	 * arr[0] arr[1] -> 0={arr[1]} left of arr[1] arr[4] -> 1={arr[4]} left of
	 * arr[2] arr[4] -> 2={arr[4]} left of arr[3] arr[4] -> 3={arr[4]} left of
	 * arr[4] arr[5] -> 4={arr[5]} left of arr[5] 0 -> 5={-1}
	 * 
	 * @param arr
	 * @return newArr
	 */
	static int[] replaceElements1(int[] arr) {
		int n = arr.length;
		int[] newArr = new int[n];
		int max=0;
		Map<Integer,Integer> map =new HashMap<>();
		for (int i = 0; i < n-1; i++) {
			max=arr[i+1];
			for (int j = i+1; j < n; j++) {
				if(max<arr[j]) {
					max=arr[j];
				}
				//System.out.println("i = "+i+" value: "+arr[i]+" j= "+j+" value: "+arr[j]+" max= "+max);
			}
			newArr[i]=max;
		}
		newArr[n-1]=-1;
		return newArr;

	}
    public static int[] replaceElements2(int[] arr) {
        
        int[] result = new int[arr.length];
        result[arr.length-1] = -1;
        
        int max = -1;
        
        for(int i = arr.length-2; i>=0; i--) {
            result[i] = Math.max(arr[i+1], max); 
            max = result[i];
        }
        
        return result;
    }
    public static int[] replaceElements(int[] arr) {
        
        
// ALGORITHM 1
        
/*

    Your runtime beats 26.41 % of java submissions.
    Your memory usage beats 27.51 % of java submissions.

    15 / 15 test cases passed.
    Runtime: 143 ms
    Memory Usage: 40.4 MB
    
    This is O(n^2) solution. It's because one of the for loops starts with i while the other inner nested for loop  will check for the max element in the next set of remaining values.
    
    Now, I'll need to optimize the solution. I did a small optimization. For that look into the below comments

*/
        
/* Code starts here >>>


        if(arr.length == 1){
            arr[0] = -1;
            return arr;
        }
        
        for(int i=0; i < arr.length-1; i++){
            int max = 0;
            for(int j = i+1; j < arr.length; j++){
                if(arr[j] > max) max = arr[j];
            }
            arr[i] = max;
        }
        
        arr[arr.length-1] = -1;
        return arr;
        
 >>> Code ends here                                     */
        
// ALGORITHM 2

/*
        
    15 / 15 test cases passed.
    Runtime: 1 ms
    Memory Usage: 40.1 MB

    Your runtime beats 99.89 % of java submissions.
    Your memory usage beats 65.55 % of java submissions.

    Here I'll follow the same algorithm as above, however, instead of checking for the max element everytime using the inner loop (j), I'll note down the max element's index position when I calculate the max element for the first time.
    
    Then, while iterating the external loop (i), I'll see if the index i is less than the max element's index. If it is less than the max element's index, it simply means that the max element is still there somewhere in the right of the element arr[i]. This means the max element is still the maximum element that we would've found using the inner loop (j).
    
    So now, instead of calculating the max element we'll simply replace the arr[i] with the max element saving a lot of time as we are not finding the max element again.
    
    This is also an O(n^2) solution, however, in the best case it acts as a O(n) algorithm while in the worst case it is O(n^2).
    
    Code starts here >>>>                                           
    

        
        if(arr.length == 1){
            arr[0] = -1;
            return arr;
        }

        int max = 0, k = 0;
        
        for(int i=0; i < arr.length-1; i++){

            if(i < k) arr[i] = max;
            else{
                max = 0;
                
                for(int j = i+1; j < arr.length; j++){
                    if(arr[j] > max){
                        max = arr[j];
                        k = j;
                    }
                }
                arr[i] = max;
            }
        }
        
        arr[arr.length-1] = -1;   // replacing the last element with -1 as asked in the problem statement
        return arr;
        

//    <<< Code ends here                            */
        
// ALGORITHM 3
        
        
        

/*

    In this algorithm, I'm planning to use Max Heap, to get the maximum element from a Heap which only takes O(1) time. So, first time, I'll load all the elements into a max heap from i+1 where i starts at 0.
    
    As, it's a max heap, the maximum element is always returned in O(1) time and it's also easy to get rid of the maximum element.
    
    So, this goes on like this >> we'll load all the elements into a max heap using the default provided max heap implementation done by priority queue.
    
     PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
     
     Now, when we traverse the array again from i+1, we'll see if the element arr[i+1] is less than the element which is the maximum in the heap. If the element is less, we'll replace the arr[i] with the maximum element. We'll keep on doing that, and in case we encounter an element which is itself the maximum element, then we know that we can't use that as the maximum element as according to the problem statement, the  max element should always be on the right of the arr[i] element. Hence, we delete/remove that element from the max heap.
     
     For instance, lets say there are two max elements, and when we encountered one of that when we are traversing using a for loop, we'll have to delete it right! Now, when we delete such an element, automatically, the other same element will take place of the deleted item and the algorithm works without any failure. Let's try it and see if this algorithm can reduce the time and space complexity.




        if(arr.length == 1){
            arr[0] = -1;
            return arr;
        }
        
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        int i = 0;
        for(i = 1; i < arr.length; i++){
            pQueue.add(arr[i]);
        }
        
        for(int j = 0; j < arr.length-1; j++){
            if(pQueue.peek() > arr[j+1]) arr[j] = pQueue.peek();
            else if(pQueue.peek() == arr[j+1]){
                pQueue.poll();
                arr[j] = pQueue.peek();
            }
        }
        arr[arr.length-1] = -1;
        return arr;                                                             */
        
        
        
// ALGORITHM 4
        
/*        
        Here we come from the backside and keep replacing the arr[j] with the max element. For instance, lets take the case of the following array
        
        1,1,1,5,3,2,2,1,2
        
        Here we come from the backside and we put the last element into the max element. As we are putting the bigger value into the max element, and if the current max element is lost, it's lost forever, so intead of directly storing the bigger value in the max, we'll store it in a temp variable, then put the higher value in max and then replace the temp variable into arr[j].
        
        We then go to the next last element and compare it with the max element. If it is less than max element, we'll replace it with the max element using the above temp concept, and continue the same process until we encounter an element greater than max. However, if a particular element is smaller than the max element, we'll simply replace the element arr[j] with the max without doing any other thing
        
        */
// Code starts here                  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        int max =-1;
        for(int j = arr.length-1; j >= 0; j--){
            if(arr[j] > max){
                int temp = max;
                max = arr[j];
                arr[j] = temp;
            }
            else arr[j] = max;
        }
        return arr;
        
// <<<<<<<<<<<<<<<<<<<<<<<<<<<<                        Code ends here
    }
}

package queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
/**
 * Used in printers, OS, web servers, live support systems
 * 
 * OPERATIONS(ALl support O(1))
 * enqueue
 * dequeue
 * peek
 * isEmpty
 * isFull
 * 
 * 
 * @author sakawabob
 *
 */
public class JavaImplementation {

	public static void main(String[] args) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(10);
		queue.add(20);
		queue.add(30);
		
		System.out.println(queue);
		System.out.println(queue.peek());
		System.out.println(queue.remove());
		System.out.println(queue);
		
		int[] nums = {0,1,0,3,12};
		
		moveZeroes(nums);

	}
    public static void moveZeroes(int[] nums) {
        Queue<Integer> queue = new ArrayDeque<>();
        int n = nums.length;
        for(int i = 0; i< n; i++){
            if(nums[i] != 0){
                queue.add(nums[i]);
            }
        }
        
        int j = 0;
        nums = new int[n];
        while(!queue.isEmpty()){
            nums[j] = queue.remove();
            j++;
        }
        System.out.println(Arrays.toString(nums));
    }
    
    public void moveZeroesOptimised(int[] nums) {
        int zeroIndex = 0;
        for(int i = 0,j=0; i < nums.length; i++){
            //find a zero
            if(nums[i] != 0){
                int tmp = nums[i];              
                nums[i] = nums[j];
                nums[j] = tmp;
                j++;                
            }
        }
        
    }

}

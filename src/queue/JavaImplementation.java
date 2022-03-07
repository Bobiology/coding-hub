package queue;

import java.util.ArrayDeque;
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


	}

}

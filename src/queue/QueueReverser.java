package queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class QueueReverser {

	public static void main(String[] args) {
		Queue<Integer> queue = new ArrayDeque<>(Arrays.asList(10, 20, 30, 40, 50));
		int K = 3;
		QueueReverser qr = new QueueReverser();
		System.out.println(qr.reverse(queue,K));
	}
	/*
	 *  Q = [10, 20, 30, 40, 50]
	 *  K = 3
	 *  R = [30, 20, 10, 40, 50]
	 *  
	 *  S = [30, 20, 10]
	 */
	public Queue<Integer> reverse(Queue<Integer> queue, int K) {
		Stack<Integer> stack = new Stack<>();
		Queue<Integer> reversedQueue = new ArrayDeque<>();
		int count = 1;
		while(!queue.isEmpty() && count <= K) {
			stack.push(queue.poll());
			count ++;
		}
		while(!stack.isEmpty()) {
			reversedQueue.add(stack.pop());
		}
		while(!queue.isEmpty()) {
			reversedQueue.add(queue.poll());
		}
		return reversedQueue;
	}

}

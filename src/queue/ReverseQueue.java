package queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {

	public static void main(String[] args) {
		Queue<Integer> queue = new ArrayDeque<>(Arrays.asList(10,20,30,40));
		System.out.println(reverse(queue));
	}
	public static Queue<Integer> reverse(Queue<Integer> queue) {
		Stack<Integer> stack = new Stack<>();
		if(queue.isEmpty()) throw new IllegalArgumentException();
		for(int i=0;i<=queue.size();i++) {
			stack.add(queue.remove());
		}
		while(!stack.isEmpty()) {
			queue.add(stack.pop());
		}
		return queue;
		
	}

}

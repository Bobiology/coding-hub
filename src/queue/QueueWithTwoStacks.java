package queue;

import java.util.Stack;

public class QueueWithTwoStacks {
	private Stack<Integer> stack1 = new Stack<>();
	private Stack<Integer> stack2 = new Stack<>();

	public static void main(String[] args) {
		QueueWithTwoStacks queue = new QueueWithTwoStacks();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		var first = queue.dequeue();
		System.out.println(first);
	}
	public void enqueue(int item) {
		stack1.push(item);
	}
	
	public int dequeue() {
		if(isEmpty()) throw new IllegalStateException();
		moveStack1ToStack2();

		return stack2.pop();
	}
	
	public int peek() {
		if(isEmpty()) throw new IllegalStateException();
		moveStack1ToStack2();
		return stack2.peek();
	}
	public boolean isEmpty() {
		return stack1.isEmpty() && stack2.isEmpty();
	}
	
	public void moveStack1ToStack2() {
		if(stack2.isEmpty()) {
			while(!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
	}

}

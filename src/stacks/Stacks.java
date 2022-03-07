package stacks;

import java.util.Stack;
/**
 * Stack supports below operations(All Operations have time complexity of O(1))
 *  - push(add element to top of stack)
 *  - pop(remove top element of stack without removing it)
 *  - peek(return the top element)
 *  -isEmpty (checks if stack is empty)
 * @author sakawabob
 *
 */
public class Stacks {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		System.out.println(stack);
		System.out.println("peek="+stack.peek());
		System.out.println(stack);
		System.out.println("pop="+stack.pop());
		System.out.println(stack);

	}

}

package stacks;

import java.util.Stack;

/**
 * Stacks should be used for the reversal of items and undo features
 * 
 * @author sakawabob
 *
 */
public class ReverseString {

	public static void main(String[] args) {
		String s = "abcd";
		System.out.println(reverser(s));

	}

	static String reverser(String s) {
		Stack<Character> stack = new Stack<>();
		StringBuffer sb = new StringBuffer();
		if (s == null) {
			throw new IllegalArgumentException();
		}
		for (char ch : s.toCharArray()) {
			stack.push(ch);
		}
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return sb.toString();
	}

}

package stacks;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BalancedExpressions {
	private final List<Character> rightBrackets = Arrays.asList(')','>',']','}');
	private final List<Character> leftBrackets = Arrays.asList('(','<','[','{');


	public static void main(String[] args) {
		// Edge cases
		// (
		// (()
		// )(
		String s = "(<1> + <2>)";
		System.out.println(new BalancedExpressions().isBalanced(s));

	}

	 boolean isBalanced(String s) {
		Stack<Character> stack = new Stack<>();
		if (s == null)
			throw new IllegalArgumentException();

		for (char ch : s.toCharArray()) {
			if (isLeftBracket(ch)) {
				stack.push(ch);
			}
			if (isRightBracket(ch)) {
				if (stack.isEmpty())
					return false;
				var top = stack.pop();
				if (!bracketsMatch(ch, top))
					return false;
			}
		}
		return stack.empty();
	}
	private boolean isLeftBracket(char ch) {
		return leftBrackets.contains(ch);
	}
	private boolean isRightBracket(char ch) {
		return rightBrackets.contains(ch);
	}
	private boolean bracketsMatch(char right, char left) {
		return leftBrackets.indexOf(left)==rightBrackets.indexOf(right);
	}

}

package revision;

import java.util.Stack;

public class ReverseInteger {

	public static void main(String[] args) {
		ReverseInteger ri = new ReverseInteger();
		//System.out.println(ri.reverse(1534236469));
		System.out.println(reverse2(536));
	}

	public int reverse(int x) {

		if (x < (int) Math.pow(-2, 31) || x > ((int) Math.pow(2, 31) - 1))
			return 0;

		Stack<Object> stack = new Stack<>();
		int n = String.valueOf(x).length();
		char sign = 0;
		for (int i = 0; i < n; i++) {
			if (Character.isDigit(String.valueOf(x).charAt(i))) {
				stack.add(String.valueOf(x).charAt(i));
			} else {
				sign = String.valueOf(x).charAt(i);
			}

		}
		if (sign != 0)
			stack.add(sign);

		StringBuilder newValue = new StringBuilder();
		while (!stack.isEmpty()) {
			newValue.append(stack.pop());
		}
		try {
			return Integer.parseInt(newValue.toString());
		} catch (NumberFormatException num) {
			return 0;
		}
	}
	//321
	static String reverse2(int x) {
		StringBuilder builder = new StringBuilder();
		int n = (int)x+"".length();
		
		System.out.println("n="+n);
		while(n > 0) {
			int rem = x % 10;
			builder.append(rem);
			n--;
			System.out.println(rem);
		}
		
		return builder.toString();
	}

}

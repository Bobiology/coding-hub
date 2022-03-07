package stacks;


public class Demo {

	public static void main(String[] args) {
		StackImplementation stack = new StackImplementation();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		
		stack.pop();
		System.out.println(stack.peek());
		
		System.out.println(stack);
		System.out.println(stack.isEmpty());

	}

}

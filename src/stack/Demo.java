package stack;

public class Demo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		String path[] = "smsf/applicant".split("\\/");
		System.out.println("path1="+path[0]+" path2="+path[1]);
		
		Stack<Integer> stack = ImmutableStack.empty();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		
		System.out.println("Done");

	}

}

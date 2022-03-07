package aws;

import java.util.LinkedList;
import java.util.Queue;

public class QueueManipulation {

	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<>();
		queue.offer("Bob");
		queue.offer("James");
		queue.offer("John");
		queue.offer("Betty");
		queue.offer("Joy");
		
		queue.stream().forEach(a ->{
			System.out.println(a.replaceAll("o", "0"));
		});
		
		System.out.println("peek="+queue.peek());
		System.out.println("elements=");

		queue.peek();
		
	}

}

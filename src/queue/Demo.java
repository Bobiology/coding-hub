package queue;

public class Demo {

	public static void main(String[] args) {
		ArrayQueue queue = new ArrayQueue(5);
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		
		System.out.println(queue.toString());
		System.out.println(queue.dequeue());
		System.out.println(queue.toString());
		System.out.println(queue.dequeue());
		System.out.println(queue.toString());
		queue.enqueue(40);
		queue.enqueue(50);
		queue.enqueue(60);
		System.out.println(queue.toString());
	}

}

package linkedList;

import java.util.Arrays;

public class Demo {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		System.out.println(list.indexOf(300));
		System.out.println(Arrays.toString(list.toArray()));
		System.out.println("size="+list.size());
		System.out.println("kth from end="+list.getKthFromTheEnd(1));
		System.out.print("middle=");
		list.printMiddle();
		System.out.println();
		//list.removeFirst();
		//list.removeLast();
		list.reverse();
		System.out.println(Arrays.toString(list.toArray()));
		System.out.println(list.contains(30));
		System.out.println(4 >> 2);
	}
}

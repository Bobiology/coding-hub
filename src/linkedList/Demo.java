package linkedList;

import java.util.Arrays;

public class Demo {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		//System.out.println(list.indexOf(300));
		list.removeFirst();
		list.removeLast();
		System.out.println(list.contains(30));


	}
}

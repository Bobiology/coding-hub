package aws;

import java.util.LinkedList;

public class LinkedListManipulation {

	public static void main(String[] args) {
		LinkedList<Integer>list = new LinkedList<>();
		list.add(11);
		list.add(12);
		list.add(15);
		list.add(17);
		list.add(21);
		
		linkedList(list);
	}
	static void linkedList(LinkedList<Integer> list) {
		int n=list.size();
		int ele = list.pollLast();
		System.out.println("Element="+ele);
		
		System.out.println("List="+list);
	}

}

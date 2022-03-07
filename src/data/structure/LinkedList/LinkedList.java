package data.structure.LinkedList;

public class LinkedList {
	static class Node{
		int data;
		Node next=null;
		
		public Node(int d) {
		data =d;	
		}
	}
	
	static void appendToTail(int d) {
		Node end =new Node(d);
		Node n = null;
		while(n.next !=null) {
			n=n.next;
		}
		n.next=end;
	}

}

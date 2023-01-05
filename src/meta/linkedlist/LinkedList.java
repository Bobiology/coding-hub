package meta.linkedlist;

public class LinkedList {
	Node head;
	
	public void add(int data) {
		Node node = new Node(data);
		if(head != null) {
			node.next = head;
			head = node;
		}else
			head = node;
		
	}
	
	public void addAtEnd(int data) {
		Node node = new Node(data);
		
	}
	
	public void print() {
		Node n = head;
		while(n != null) {
			System.out.println(n.data);
			n = n.next;
		}
	}
}

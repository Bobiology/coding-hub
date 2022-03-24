package aws;

public class LinkedList {
	private Node first;
	private Node last;
	private class Node{
		private Node next;
		private int value;
		
		public Node(int value) {
			this.value = value;
		}
		
		@Override
		public String toString() {
			return "" + value + "";
		}
	}
	//10 -> 20 -> 30 -> 40
	public void addFirst(int value) {
		var  node = new Node(value);
		if(first == null) {
			first = last = node;
		}
		else {
			node.next = first;
			first = node;
		}
		//System.out.println("head="+first.toString());
	}
	
	public void addLast(int value) {
		var node = new Node(value);
		if(first == null) {
			first = last = node;
		}else {
				last.next = node;
				last = node;
			
		}
		//System.out.println("tail="+last.toString());
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.addFirst(10);
		list.addFirst(20);
		list.addFirst(30);
		list.addFirst(40);
		
		list.addLast(5);
		list.addLast(15);
		
		System.out.println("Done!");
	}

}

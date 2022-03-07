package linkedLister;

public class LnkdList {
	Node head;//head of linkedlist
	static class Node{
		Node next; //pointer to the next element
		int data; //data element
		//constructor
		Node(int data){
			this.data=data;
			next=null;
		}
	}
	
	public static void main(String[] args) {
		LnkdList ll = new LnkdList();
		ll.head=new Node(1);
		Node l2nd = new Node(2);
		Node l3rd = new Node(3);
		Node l4th = new Node(4);
		
		/* Three nodes have been allocated dynamically.
        We have references to these three blocks as head, 
        second and third

           ll.head        l2nd              l3rd				l4th
           |                |                  |				  |
           |                |                  |				  |
       +----+------+     +----+------+     +----+------+    +-----+-----+
       | 1  | null |     | 2  | null |     |  3 | null |    |  4  | null|
       +----+------+     +----+------+     +----+------+    +-----+-----+ 
       */
		
		ll.head.next=l2nd; // Link first node with the second node
 
        /*  Now next of the first Node refers to the second.  So they
            both are linked.
 
         llist.head        second              third
            |                |                  |
            |                |                  |
        +----+------+     +----+------+     +----+------+
        | 1  |  o-------->| 2  | null |     |  3 | null |
        +----+------+     +----+------+     +----+------+ */
		l2nd.next=l3rd;// Link second node with the third node
 
        /*  Now next of the second Node refers to third.  So all three
            nodes are linked.
 
         llist.head        second              third
            |                |                  |
            |                |                  |
        +----+------+     +----+------+     +----+------+
        | 1  |  o-------->| 2  |  o-------->|  3 | null |
        +----+------+     +----+------+     +----+------+ */
		l3rd.next=l4th;
		l4th.next=null;	
		ll.printList();
	}
	
	void printList(){
		Node n=head;
		while(n !=null) {
			System.out.print(n.data+" -> ");
			n=n.next;
		}
		
	}

}

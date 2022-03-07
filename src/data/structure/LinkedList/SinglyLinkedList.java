package data.structure.LinkedList;

public class SinglyLinkedList {

	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
	/**
	 * 
	 * 1.  5 -> 6 -> 4 = {465} reverse form
	 * 2.  2 -> 4 -> 3 = {243} reverse form
	 * 					 (708) sum of the reversed values
	 * 3. Result: 7 -> 0 -> 8 ={807} reversed sum
	 * 
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	    ListNode dummyHead = new ListNode(0);
	    ListNode p = l1, q = l2, curr = dummyHead;
	    int carry = 0;
	    while (p != null || q != null) {
	        int x = (p != null) ? p.val : 0;
	        int y = (q != null) ? q.val : 0;
	        int sum = carry + x + y;
	        carry = sum / 10;
	        curr.next = new ListNode(sum % 10);
	        curr = curr.next;
	        if (p != null) p = p.next;
	        if (q != null) q = q.next;
	    }
	    if (carry > 0) {
	        curr.next = new ListNode(carry);
	    }
	    return dummyHead.next;
	}
	public static void main(String[] args) {
		ListNode l1 = null;
		ListNode l2=null;

		System.out.println("addTwoNumbers: "+new SinglyLinkedList().addTwoNumbers(l1,l2));
	}
}

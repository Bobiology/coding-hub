package linkedList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;

public class LinkedList {

	private class Node {
		private int value;
		private Node next;

		public Node(int value) {
			this.value = value;
		}
	}

	private Node first;
	private Node last;
	private int size;

	// addFirst
	public void addFirst(int item) {
		Node node = new Node(item);
		if (isEmpty()) {
			first = last = node;
		} else {
			node.next = first;
			first = node;
		}
		size++;

	}

	// addLast
	public void addLast(int item) {
		Node node = new Node(item);
		if (isEmpty()) {
			first = last = node;
		} else {
			last.next = node;
			last = node;
		}
		size++;
	}

	// deleteFirst
	public void removeFirst() {
		if (isEmpty())
			throw new NoSuchElementException();

		if (first == last) {
			first = last = null;
			return;
		}
		Node second = first.next;
		first.next = null;
		first = second;
		
		size --;
	}

	// deleteLast
	public void removeLast() {
		if (isEmpty())
			throw new NoSuchElementException();

		if (first == last) {
			first = last = null;
			return;
		}
		Node previous = getPrevious(last);
		last = previous;
		last.next = null;
		size--;
	}

	// contains
	public boolean contains(int item) {
		return indexOf(item) != -1;
	}

	// indexOf
	public int indexOf(int item) {
		int index = 0;
		Node current = first;
		while (current != null) {
			if (current.value == item) {
				return index;
			} else {
				current = current.next;
				index++;
			}
		}
		return -1;
	}

	private boolean isEmpty() {
		return first == null;
	}

	private Node getPrevious(Node node) {
		Node current = first;
		while (current != null) {
			if (current.next == node)
				return current;
			current = current.next;
		}
		return null;
	}
	
	
	public int size() {
		return size;
	}
	
	public int[] toArray() {
		int[] array = new int[size];
		var current = first;
		var index = 0;
		
		while(current != null) {
			array[index++] = current.value;
			current = current.next;
		}
		return array;
	}
	
	public void reverse() {
		if(isEmpty()) return;
		
		var previous = first;
		var current = first.next;
		
		last = first;
		last.next = null;
		while(current !=null) {
			var next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		first = previous;
	}
	
	public int getKthFromTheEnd(int k) {
		if(isEmpty())
			throw new IllegalStateException();
		var a = first;
		var b = first;
		for(int i = 0; i < k - 1; i++) {
			b = b.next;
			if(b == null)
				throw new IllegalArgumentException();
		}
		while(b != last) {
			a = a.next;
			b = b.next;
		}
		return a.value;
	}
	
	public void printMiddle() {
		if(isEmpty())
			throw new IllegalStateException();
		
		var a = first;
		var b = first;
		while(b != last && b.next != last) {
			b = b.next.next;
			a = a.next;
		}
		if(b == last) 
			System.out.println(a.value);
		else
			System.out.println(a.value + ", " + a.next.value);
	}
	
	public Node printMiddle2() {
		var slow = first;
		var fast = first.next;
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	
	public void removeLoop(Node head){
        Node current = null;
        HashSet<Node> set = new HashSet<>();
        
        if(head == null)
            return;
        
        while(head != null){
            if(set.contains(head)){
                current.next = null;
                break;
            }else{
                set.add(head);
                current = head;
                head = head.next;
            }
            
        }
    }
	/*
	 * 
	 * Given a singly linked list of size N. 
	 * The task is to left-shift the linked list by k nodes, 
	 * where k is a given positive integer smaller than or 
	 * equal to length of the linked list.
	 */
	 public Node rotate(Node head, int k) {
	       while(k-- > 0){
	           Node temp = head;
	           Node last = new Node(head.value);
	           last.next = null;
	           while(temp.next != null){
	               temp = temp.next;
	           }
	           temp.next = last;
	           head = head.next;
	       }
	       
	       return head;
	    }
	 /*
	  * Given a singly linked list of size N of integers. 
	  * The task is to check if the given linked list is palindrome or not.
	  */
	 public boolean isPalindrome(Node head) 
	    {
	        List<Integer> list = new ArrayList<>();
	        while(head != null){
	            list.add(head.value);
	            head = head.next;
	        }
	        
	        int lower = 0, n = list.size(), upper = n -1;
	        while(lower < upper){
	            if(list.get(lower) != list.get(upper)){
	                return false;
	            }
	            lower++;
	            upper--;
	        }
	        return true;
	    }
	 /*
	  * Given a linked list of N nodes. The task is to reverse this list.
	  * Input: LinkedList: 1->2->3->4->5->6
	  * Output: 6 5 4 3 2 1
	  */
	 public Node reverseList(Node head)
	    {
	        Node previous = null, current = head, temp = head;
	        
	        while(temp != null){
	            temp = current.next;
	            current.next = previous;
	            previous = current;
	            current = temp;
	        }
	        
	        return previous;
	    }
	 /*
	  * Given a singly linked list of N nodes.
	  * The task is to find the middle of the linked list. For example, if the linked list is
	  * 1-> 2->3->4->5, then the middle node of the list is 3.
	  * If there are two middle nodes(in case, when N is even), print the second middle element.
	  * For example, if the linked list given is 1->2->3->4->5->6, then the middle node of the list is 4.
	  */
	 public int getMiddle(Node head)
	    {
	        //Space = O(n+n)
	        Node slow = head;
	        Node fast = head.next;
	        int length = 0;
	        if(head == null) return -1;
	        //Time = O(n)
	        while(head != null){
	            length++;
	            head = head.next;
	        }
	        //Time = O(log n)
	        while(fast != null && fast.next != null){
	            
	            slow = slow.next;
	            fast = fast.next.next;
	        
	        }

	        return length % 2 == 0 ? slow.next.value : slow.value;
	        
	    }
	
}

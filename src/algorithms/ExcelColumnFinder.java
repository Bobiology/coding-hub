package algorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import data.structure.LinkedList.SinglyLinkedList.ListNode;

public class ExcelColumnFinder {

	public static void main(String[] args) {
		int n = 56;//56 {AAD}
		System.out.println(new ExcelColumnFinder().getColumnLabel(n));
		
		double m = 39.33;
		System.out.println("ceil:"+Math.ceil(m));
		String bob = "sakawa";
		char[] a = bob.toCharArray();
		System.out.println(Arrays.toString(a));
		

	}
	 public class ListNode {
		     int val;
		     ListNode next;
		     ListNode() {}
		     ListNode(int val) { this.val = val; }
		     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		  }
	
	private String getColumnLabel(int n) {
		
		int count = 0;
		Map<Integer, Character> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		for (char ch = 'A'; ch <= 'Z'; ++ch) 
			  map.put(count++, ch); 
		
		while(n > 0) {
			int index = (n - 1) % 26;
			sb.append(map.get(index));
			n = (n - 1) / 26;
		}
		
		return sb.reverse().toString();
	}
	
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>((Comparator<ListNode>)(o1, o2) -> o1.val - o2.val);
         for(ListNode head : lists){
             if(head != null)
                 heap.offer(head);
         }
     
         ListNode pre = new ListNode(-1);
         ListNode tmp = pre;
         
         while(!heap.isEmpty()){
             ListNode current = heap.poll();
             tmp.next = new ListNode(current.val);
             if(current.next != null)
                 heap.offer(current.next);
             
             tmp = tmp.next;
         }
         return pre.next;
     }

}

package aws;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

public class RemoveDuplicatesLinkedList {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>(Arrays.asList(2,3,4,5,6,5,7,6));
		usingDS(list);
		linkedListManipulation(list);
		
	}
	static void usingDS(LinkedList<Integer> list) {
		System.out.println("INITIAL LIST = "+list);
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<list.size();i++) {
			map.put(list.get(i),i);
		}
		System.out.println("MAP = "+map);
		list.clear();
		for(Entry<Integer, Integer>entry: map.entrySet()) {
			list.add(entry.getKey());
		}
		
		System.out.println("NEW LIST = "+list);
	}
	
	static void linkedListManipulation(LinkedList<Integer> list) {
		int previous =0;
		LinkedList<Integer> cleanList = new LinkedList<>();
		System.out.println("INITIAL LIST = "+list);
		for(int i=0;i<list.size();i++) {
			if(list.get(i)==previous) {
				list.remove(list.get(i));
			}else {
				cleanList.add(list.get(i));
				previous = list.get(i);
			}
		}
		System.out.println("NEW LIST = "+cleanList);
	}
	
	static void deleteMiddleNode(LinkedList<Integer> list) {
		if(list.size()>2) {
			list.remove(list.get(3));
		}
	}

}

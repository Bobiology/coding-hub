package hackerrank;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class CharacterWithMostOccurrence {
	public static void main(String[] args) {
		String hello = "abbbaacc";
		char[] stringC = hello.toCharArray();
		Queue<Character> hell = new PriorityQueue<>();
		// hell.
		System.out.println(printFrequency(stringC));
		anotheSample(stringC);
		
	}

	public static char printFrequency(char arr[]) {
		Map<Character, Integer> mp = new HashMap<Character, Integer>();
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
		}

		PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>(
				(a, b) -> a.getValue().equals(b.getValue()) ? Integer.compare(b.getKey(), a.getKey())
						: Integer.compare(b.getValue(), a.getValue()));

		for (Map.Entry<Character, Integer> entry : mp.entrySet()) {
			queue.offer(entry);
		}
		char result = queue.poll().getKey();
		
		return result;
	}
	
	public static void anotheSample(char arr[]) {
		String s = "abbbbaaacc";
		//s = "hello world";

		// PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
		PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(Collections.reverseOrder());

		Map<Character,Integer> map = new HashMap<>();
		for(int i=0;i<s.length();i++) {
		char ch = s.charAt(i);
		//System.out.println(ch);
		map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		System.out.println(map);
		map.forEach((k,v)->{
		pQueue.add(v);
		});
		System.out.println("pQueue=" + pQueue.peek());

		for (Map.Entry m : map.entrySet()) {
		if(pQueue.peek() == m.getValue()){
		System.out.println("Key: "+m.getKey());
		break;
		}

		}
	}
}

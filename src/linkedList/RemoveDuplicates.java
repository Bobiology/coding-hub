package linkedList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class RemoveDuplicates {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 1, 2, 6));
		System.out.println(list);
		System.out.println(removeDup(list));
	}

	static LinkedList<Integer> removeDup(LinkedList<Integer> list) {
		Map<Integer, Integer> map = new HashMap<>();
		if (list == null)
			throw new IllegalStateException();

		for (int item : list) {
			if (map.containsKey(item))
				map.put(item, map.get(item) + 1);
			map.put(item, 1);
		}
		list = new LinkedList<Integer>();
		for (var keyset : map.entrySet()) {
			if (keyset.getValue() == 1) {
				list.add(keyset.getKey());
			}
		}
		return list;

	}

}

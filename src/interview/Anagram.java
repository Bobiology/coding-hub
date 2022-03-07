package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagram {
	/**
	 * str[] a = {"cat","act","atc","dog","dgo","fgo"} cat -> {cat,act,atc} dog ->
	 * {dog,dgo} fgo -> {fgo} == do not return
	 * 
	 */
	public static void main(String[] args) {
		String[] list = { "cat", "act", "atc", "dog", "dgo", "fgo" };

		System.out.println("groupAnagrams: " + groupAnagrams(list));

	}

	static String myAnagram(String[] a) {
		return null;
	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> resultList = new ArrayList<>();
		Map<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			char[] chArray = str.toCharArray();
			Arrays.sort(chArray);
			String tempString = String.valueOf(chArray);
			if (!map.containsKey(tempString)) {
				List<String> newList = new ArrayList<>();
				map.put(tempString, newList);
			}
			map.get(tempString).add(str);
		}
		for (String key : map.keySet()) {
			resultList.add(map.get(key));
		}
		return resultList;
	}
}

package revision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	/**
	 * Given an array of strings strs, group the anagrams together
	 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
	 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
	 * 
	 */

	public static void main(String[] args) {
		String[] st = {"eat","tea","tan","ate","nat","bat"};
		System.out.println(new GroupAnagrams().groupAnagrams(st));
	}
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>>map = new HashMap<>();
        for(String current: strs){
           String sorted = sortString(current);
            if(!map.containsKey(sorted)){
                map.put(sorted, new ArrayList());
            }
            map.get(sorted).add(current);
        }
        List<List<String>> result = new ArrayList<>();
        result.addAll(map.values());
        
        return result;
    }
    public static String sortString(String s){
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

}

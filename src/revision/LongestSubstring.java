package revision;

import java.util.HashSet;

/*
 * Given a string s, find the length of the longest substring without repeating characters.
		Example 1:
		
		Input: s = "abcabcbb"
		Output: 3
		Explanation: The answer is "abc", with the length of 3.
 */
public class LongestSubstring {

	public static void main(String[] args) {
		String s = "abcabcbb";
		s = "bbbbb";
		s = "pwwkew";
		//s = " ";
		//s = "dvdf";
		LongestSubstring l = new LongestSubstring();
		System.out.println(l.lengthOfLongestSubstring(s));
	}
	
	public int lengthOfLongestSubstring(String s) {
		int slow = 0, fast = 0;
		HashSet<Character> set = new HashSet<>();
		int longest = 0;
		while(fast < s.length() && slow <= fast) {
			if(set.contains(s.charAt(fast))) {
				set.remove(s.charAt(slow));
				slow++;
			}else {
				set.add(s.charAt(fast));
				fast ++;
			}
			
			longest = Math.max(longest, set.size());
			System.out.println("set="+set + " slow="+slow+" fast="+fast);
		}
		return longest;
	}

}

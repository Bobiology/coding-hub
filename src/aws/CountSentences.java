package aws;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import arrays.Array;

public class CountSentences {

	public static void main(String[] args) {
		List<String> wordSet = new ArrayList<>(Arrays.asList("listen","silent","it","is"));
		List<String> sentence = new ArrayList<>(Arrays.asList("listen it is silent"));
		System.out.println(countSentences(wordSet, sentence));
	}
	/*
	 * wordSet = ['listen','silent', 'it', 'is']
	 * sentence = ['listen it is silent']
	 * 
	 * loop senetence
	 * split each sentence by space {listen, it, is, silent}
	 * 
	 * check if word[i] has anagram
	 * if has 1 anagram then count = 2^2
	 * if has 2 anagram words = 3^2
	 * 
	 */
	public static List<Long> countSentences(List<String> wordSet, List<String> sentences){
		int countOfAnagrams = 0;
		Set<String> set = new HashSet<>();
		
		String[] sentenceWords = sentences.toArray(new String[0]);
		 for(String sentence: sentenceWords) {
			 System.out.println("word="+sentence);
			 String[] words = sentence.split("\\s");
			 
			 System.out.println(Arrays.toString(words));
		 }
		
		
		 
		return null;
		
	}
	private static boolean isAnagram(String a, String b) {
		if(a.length() != b.length()) return false;
		int[] arr = new int[26];
		for(char c : a.toCharArray())
			arr[c -'a']++;
		
		for(char d: b.toCharArray())
			arr[d -'a']--;
		
		for(int i: arr) {
			if(i > 0)
				return false;
		}
		return true;
	}

}

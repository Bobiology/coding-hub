package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountSentenceQuz {

	public CountSentenceQuz() {

	}

	public static void main(String[] args) {
		
		//List<String> wordSet = Arrays.asList("the","bats","tabs","in","cat","act");
		//List<String> sentences = Arrays.asList("cat the bats", "in the act", "act tabs in");
		
		List<String> wordSet = Arrays.asList("listen","silent","it","is","tenlis");
		List<String> sentences = Arrays.asList("listen it tenlis silent");
		
		List<Long> out = solution(wordSet, sentences);
		System.out.println(out);
	
	}

	private static List<Long> solution(List<String> wordSet, List<String> sentences) {
		List<Long>  list = new ArrayList<>();
		Map<Long, Integer> map = new HashMap<>();
		wordSet.forEach(word -> {
			long code = getUnicode(word);
			map.put(code, map.getOrDefault(code, 0) + 1);
		});
		for(String sentence : sentences) {
			String[] words = sentence.split("\\ ");
			long count = 0;
			for(String word : words) {
				long code = getUnicode(word);
				int c = map.getOrDefault(code, 0);
				if(c > 1)
					count+=c;
				
			}
			list.add(count);
		}
		return list;
	}
	
	static long getUnicode(String s) {
		long unicode = 0;
		for(int i=0;i<s.length();i++) {
			int ch = s.charAt(i);
			unicode+=ch;
		}
		return unicode;
	}

}
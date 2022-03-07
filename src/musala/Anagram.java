package musala;

import java.util.Arrays;
import java.util.List;

public class Anagram {

	public Anagram() {
// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		List<String> wordSet = Arrays.asList("listen", "silent", "it", "is");
		List<String> sentences = Arrays.asList("listen it is silent");

		List<Long> out = solution(wordSet, sentences);
		System.out.println(out);

	}

	private static List<Long> solution(List<String> wordSet, List<String> sentences) {
		long count = 0;
		for (String sentence : sentences) {
			String[] words = sentence.split("\\ ");
			boolean isSentence = true;
			for (String word : words) {
				if (!wordSet.contains(word)) {
					isSentence = false;
					break;
				}
			}
			if (isSentence) {
				count++;
			}
		}
		return Arrays.asList(count);
	}

}

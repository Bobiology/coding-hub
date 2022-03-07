package safaricom;

public class SentenceWithLargestNumberOfWords {

	public static void main(String[] args) {
		// String S = "This is a . This is a string! This is not okay, he said. Then he
		// asked, why is the quiz difficult? okay, the quiz is very simple";
		String S = "We test coders. Give me a cup of water! Give us a try. Are you sure, you'll be going home today evening?";
		System.out.println(sentences(S));

	}

	static int sentences(String S) {

		String[] array = S.split("\\?|\\.|\\!");
		int maxWords = 0;
		for (String s : array) {
			s = s.trim();
			System.out.println(s);
			String[] words = s.split("\\S+");
			int max = words.length;
			if (maxWords < max) {
				maxWords = max;
			}
		}

		return maxWords;
	}

}

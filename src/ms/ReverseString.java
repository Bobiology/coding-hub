package ms;

public class ReverseString {

	// final static String str = "perfect makes practice";
	final static String str = " perfect makes practice ";
	// "practice makes perfect"
	// final static String str = "a";
	// final static String str = "";
	// final static String str = " ";
	// final static String str = "perfect";
	static char[] s = str.toCharArray();

	static char[] newArr;

	static int counter = 0, endOfStr = 0;

	static char spaceCharacter = ' ';

	// they occupy a contiguous location in memory = 40 characters, 22 Space O(n)
	// inserting an element into an already full array will be an O(n) operation;
	// create a new array of n+1
	// 1. reverse the whole string character by character
	// convert the String to character array
	// ecitcarp sekam tcefrep
	// go through the string and get each word, and reverse the characters of each
	// word at a time
	// practice makes perfect
	// Time O(n) => O(n) + O(n) = O(n)
	// Space O(1)
	public static void reverseString(char[] s) {

		int end = s.length - 1;

		for (int i = 0, j = end; i < j; i++, j--) {
			swap(s, i, j);
		}

		printArray(s);

		int startOfWord = -1;
		int endOfWord = -1;
		int newLen = 0;
		int noOfWords = 0;

		// ecitcarp sekam tcefrep
		for (int i = 0; i <= end; i++) {
			// start of a word = non-space character
			// end of a word = non-space character and either followed by a space or we are
			// at the end of the string
			// once we get the word, we reverse the characters of that word

			// I'll meet the start of a word first before I encounter the end of a word
			if (s[i] != spaceCharacter) {
				if (startOfWord == -1) {
					startOfWord = i;
				}

				if (startOfWord != -1 && (i == end || s[i + 1] == spaceCharacter)) {
					endOfWord = i;

					// reverse characters of the found word
					reverseWord(s, startOfWord, endOfWord);

					newLen += (endOfWord - startOfWord + 1);
					noOfWords++;
					endOfStr = endOfWord;

					startOfWord = -1;
					endOfWord = -1;
				}
			}
		}
		// port p=4, t=7 7-4+1 =4

		printArray(s);

		int[] arr = new int[10];
		arr[0] = 1; // O(1)
		arr[9] = -1; // O(1) => delete/update

		// O(log(n)) => base 2
		// binary search/binary search trees

		newArr = new char[newLen + noOfWords - 1];
		System.out.println("newArr length = " + newArr.length);
		for (int i = 0; i <= end; i++) {
			// start of a word = non-space character
			// end of a word = non-space character and either followed by a space or we are
			// at the end of the string
			// once we get the word, we reverse the characters of that word

			// I'll meet the start of a word first before I encounter the end of a word
			if (s[i] != spaceCharacter) {
				if (startOfWord == -1) {
					startOfWord = i;
				}

				if (startOfWord != -1 && (i == end || s[i + 1] == spaceCharacter)) {
					endOfWord = i;

					// add characters of the found word
					addWord(s, startOfWord, endOfWord, endOfStr);

					startOfWord = -1;
					endOfWord = -1;
				}
			}
		}

		printArray(newArr);

	}// BREADTH-FIRST APPROACH - list your helper functions: swap, reverseWord

	private static void addWord(char[] s, int startOfWord, int endOfWord, int endOfStr) {
		for (int i = startOfWord; i <= endOfWord; i++) {
			if (counter < newArr.length) {
				newArr[counter] = s[i];
				counter++;
			}
		}

		if (counter < newArr.length && counter != endOfStr) {
			newArr[counter] = spaceCharacter;
			counter++;
		}
	}

	private static void reverseWord(char[] s, int start, int end) {
		for (int i = start, j = end; i < j; i++, j--) {
			swap(s, i, j);
		}
	}

	private static void swap(char[] s, int i, int j) {
		char temp = s[i];
		s[i] = s[j];
		s[j] = temp;
	}

	private static void printArray(char[] s) {

		for (int i = 0; i < s.length; i++) {
			System.out.print(s[i]);
			if (i < s.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		reverseString(s);
	}
}

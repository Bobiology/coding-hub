package revision;

public class Anagram {

	public static void main(String[] args) {
		String a = "act";
		String b = "cat";
		System.out.println(isAnagram(a,b));
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

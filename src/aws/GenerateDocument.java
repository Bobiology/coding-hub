package aws;

import java.util.HashMap;

public class GenerateDocument {

	public static void main(String[] args) {
		String characters ="aabbcc";
		String document = "aabbcc";
		StringBuilder s =new StringBuilder();
		
		System.out.println(generateDocument(characters, document));
	}
	public static boolean generateDocument(String characters, String document) {
		HashMap<Character, Integer> map = new HashMap<>();

		for(char ch : characters.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		
		for(char ch : document.toCharArray()) {
			if(map.get(ch) == null) return false;
			
			if(map.get(ch)==0) return false;
			map.put(ch, map.get(ch) - 1);
		}
		return true;
	}

}

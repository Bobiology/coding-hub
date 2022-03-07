package aws;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FirstRepeatedCharacter {

	public static void main(String[] args) {
		// a green spoon
		//a = 1
		//  = 2
		//g = 1
		//return a
		String S = "agreen spoon";
		FirstRepeatedCharacter frc = new FirstRepeatedCharacter();
		System.out.println("MAP="+frc.findFirstRepeatedChar(S));
		System.out.println("SET="+frc.findFirstRepeatedChar2(S));
		
	}
	public char findFirstRepeatedChar(String S) {
		Map<Character, Integer> map = new HashMap<>();
		char[] chars = S.toCharArray();
		for(char ch : chars) {
			var count = map.containsKey(ch) ? map.get(ch) : 0;
			map.put(ch, count + 1);
		}
		for(char ch : chars) {
			if(map.get(ch)>1) {
				return ch;
			}
		}
		return Character.MIN_VALUE;
	}
	
	public char findFirstRepeatedChar2(String S){
		Set<Character> set = new HashSet<>();
		for(char ch : S.toCharArray()) {
			if(set.contains(ch))
				return ch;
			set.add(ch);
		}
		return Character.MIN_VALUE;
	}

}

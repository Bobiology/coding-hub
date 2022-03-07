package aws;

import java.util.Arrays;
import java.util.HashMap;

public class StringHasUniqueXters {

	public static void main(String[] args) {
		String unique ="Nooene";
		System.out.println(isStringUnique(unique));

	}

	static boolean isStringUnique(String unique) {
		char[] ch = unique.toCharArray();
		HashMap<Character,Integer> charMap = new HashMap<>();
		int count=0;
		boolean isUnique = true;
		System.out.println("Character = "+Arrays.toString(ch));
		for(int i=0;i<ch.length;i++) {
			if(charMap.getOrDefault(ch[i],-1)==-1) {
				charMap.put(ch[i], count+1);
			}else {
				//charMap.put(ch[i], charMap.getOrDefault(ch[i],0)+1);
				isUnique = false;
			}
			count=0;
			System.out.println("Map = "+charMap.toString());
		}
		return isUnique;
	}

}

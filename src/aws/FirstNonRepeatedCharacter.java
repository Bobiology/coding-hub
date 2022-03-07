package aws;

import java.util.HashMap;
import java.util.Map.Entry;

public class FirstNonRepeatedCharacter {

	public static void main(String[] args) {
		String S = "supercalifragilisticexpialidocious";
		System.out.println(findFirstNonRepeatingChar(S));
		
				
	}
	/*Given a string S, find the first character that occurs only once.
	
	For example: S = “supercalifragilisticexpialidocious”
	=> ‘f’
	*/
	static char findFirstNonRepeatingChar(String S){
	    HashMap<Character,Integer> map = new HashMap<>();
	    var chars = S.toCharArray();
	    for(char ch: chars){
	       var count = map.containsKey(ch) ? map.get(ch) : 0;
	       map.put(ch, count + 1);
	    }
	    
	    for(char ch : chars) {
	    	if(map != null && map.get(ch)==1) {
	    		return ch;
	    	}
	    }
	    return Character.MIN_VALUE;
	}
	
	public int firstUniqChar(String s) {
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        int n = s.length();
        // build hash map : character and how often it appears
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        
        // find the index
        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1) 
                return i;
        }
        return -1;
    }

}

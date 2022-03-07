package musala;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class MostOccurrenceString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maximumOccurringCharacter("bababbaa"));

	}
	
	public static char maximumOccurringCharacter(String text){
	     Map<Character, Integer> occurences = new HashMap<>();
	     char[] characters = text.toCharArray();

	     for (int i = 0; i < characters.length; i++) {
	         if (occurences.get(characters[i]) == null)
	             occurences.put(characters[i], 1);

	         else {
	             int mostOccurence = occurences.get(characters[i]);
	             mostOccurence++;
	             occurences.put(characters[i], mostOccurence);
	         }
	         System.out.println("Occurrence="+occurences+ " character="+characters[i]);
	     }

	     int max = 0;
	     char mostOccurringCharacter ='0';
	     for(Entry<Character, Integer> set: occurences.entrySet()) {
	    	 if(set.getValue()>max) {
	    		 max=set.getValue();
	    		 mostOccurringCharacter=set.getKey();
	    	 }
	     }

	     System.out.println("MOST OCCURRING CHARACTER="+mostOccurringCharacter);
	     return mostOccurringCharacter;

	 }
	public static void printMap(Map<?, ?> mp) {
	    Iterator<?> it = mp.entrySet().iterator();
	    while (it.hasNext()) {
	        Entry<?, ?> pair = (Entry<?, ?>) it.next();
	        System.out.println(pair.getKey() + " = " + pair.getValue());
	        it.remove(); // avoids a ConcurrentModificationException
	    }
	}

}

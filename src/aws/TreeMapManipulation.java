package aws;

import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapManipulation {

	public static void main(String[] args) {
	    TreeMap<Integer, String> map = new TreeMap<>();
	    map.put(3, "val");
	    map.put(2, "val");
	    map.put(1, "val");
	    map.put(5, "val");
	    map.put(4, "val");
	    
	    Integer highest = map.lowerKey(3);
	    
	    Integer highestKey = map.lastKey();
	    Integer lowestKey = map.firstKey();
	    Set<Integer> keysLessThan3 = map.headMap(3).keySet();
	    Set<Integer> keysGreaterThanEqTo3 = map.tailMap(3).keySet();
	    
	    Entry<Integer, String>remainingKey =map.higherEntry(3);
	    
	    System.out.println("lowerKey="+highest);
	    System.out.println("lastKey="+highestKey);
	    System.out.println("firstKey="+lowestKey);
	    System.out.println("headMap="+keysLessThan3);
	    System.out.println("tailMap="+keysGreaterThanEqTo3);
	    System.out.println("remainingKey="+remainingKey);
	    /**
	     * search, get,put & remove O(log n)
	     */

	}

}

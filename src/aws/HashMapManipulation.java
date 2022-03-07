package aws;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HashMapManipulation {

	@Test
	public void whenInsertObjectsHashMap_thenRandomOrder() {
	    Map<Integer, String> hashmap = new HashMap<>();
	    hashmap.put(3, "TreeMap");
	    hashmap.put(2, "vs");
	    hashmap.put(1, "HashMap");
	    Map<Integer, String> map = new HashMap<>();
	    map.put(1, "nnn");
	    map.put(2, "333");
	    map.put(3, "kk");
	    Assertions.assertEquals(hashmap.keySet(), map.keySet());
	}
	
	@Test
	public void whenInsertObjectsTreeMap_thenNaturalOrder() {
	    Map<Integer, String> treemap = new TreeMap<>();
	    treemap.put(3, "TreeMap");
	    treemap.put(2, "vs");
	    treemap.put(1, "HashMap");
	    
	    Map<Integer, String> testMap = new TreeMap<>();
	    testMap.put(1, "HashMap");
	    testMap.put(2, "vs");
	    testMap.put(3, "TreeMap");
	    
	    Assertions.assertEquals(treemap.keySet(), testMap.keySet());
	}
	@Test
	public void givenTreeMap_whenOrdersEntriesNaturally_thenCorrect() {
	    TreeMap<Integer, String> map = new TreeMap<>();
	    map.put(3, "val");
	    map.put(2, "val");
	    map.put(1, "val");
	    map.put(5, "val");
	    map.put(4, "val");

	    assertEquals("[1, 2, 3, 4, 5]", map.keySet().toString());
	}
	@Test
	public void givenTreeMap_whenOrdersEntriesNaturally_thenCorrect2() {
	    TreeMap<String, String> map = new TreeMap<>();
	    map.put("c", "val");
	    map.put("b", "val");
	    map.put("a", "val");
	    map.put("e", "val");
	    map.put("d", "val");

	    assertEquals("[a, b, c, d, e]", map.keySet().toString());
	}
	@Test
	public void givenTreeMap_whenOrdersEntriesByComparator_thenCorrect() {
	    TreeMap<Integer, String> map = new TreeMap<>(Comparator.reverseOrder());
	    map.put(3, "val");
	    map.put(2, "val");
	    map.put(1, "val");
	    map.put(5, "val");
	    map.put(4, "val");
	        
	    assertEquals("[5, 4, 3, 2, 1]", map.keySet().toString());
	}
	
	@Test
	public void givenTreeMap_whenPerformsQueries_thenCorrect() {
	    TreeMap<Integer, String> map = new TreeMap<>();
	    map.put(3, "val");
	    map.put(2, "val");
	    map.put(1, "val");
	    map.put(5, "val");
	    map.put(4, "val");
	    
	    
	    int highest = map.ceilingKey(3);
	    
	    Integer highestKey = map.lastKey();
	    Integer lowestKey = map.firstKey();
	    Set<Integer> keysLessThan3 = map.headMap(3).keySet();
	    Set<Integer> keysGreaterThanEqTo3 = map.tailMap(3).keySet();

	    assertEquals(new Integer(5), highestKey);
	    assertEquals(new Integer(1), lowestKey);
	    assertEquals("[1, 2]", keysLessThan3.toString());
	    assertEquals("[3, 4, 5]", keysGreaterThanEqTo3.toString());
	}

}

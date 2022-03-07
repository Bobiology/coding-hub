package aws;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

public class LinkedHashMapManipulation {
	public static void main(String[] args) {
		
		givenLinkedHashMap_whenAccessOrderWorks_thenCorrect();
		System.out.println("*************************************");
		givenHashMap_whenAccessOrderWorks_thenCorrect();
		//givenLinkedHashMap_whenGetsOrderedKeyset_thenCorrect();
	}
	
	static void givenLinkedHashMap_whenGetsOrderedKeyset_thenCorrect() {
		 LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
		    map.put(1, null);
		    map.put(2, null);
		    map.put(6, null);
		    map.put(3, null);
		    map.put(4, null);
		    map.put(5, null);

		    Set<Integer> keys = map.keySet();
		    Integer[] arr = keys.toArray(new Integer[0]);

		    for (int i = 0; i < arr.length; i++) {
		       System.out.println(new Integer(i + 1)+" ,"+arr[i]);
		    }
	}
	
	static void givenLinkedHashMap_whenAccessOrderWorks_thenCorrect() {
	    LinkedHashMap<Integer, String> map = new LinkedHashMap<>(16, .75f, true);
	    map.put(1, null);
	    map.put(2, null);
	    //map.put(6, null);
	    map.put(3, null);
	    map.put(4, null);
	    map.put(5, null);

	    Set<Integer> keys = map.keySet();
	    keys.stream().forEach(a ->{
	    	System.out.println("aaaa="+a);
	    });
	    System.out.println("[1, 2, 3, 4, 5]"+","+ keys.toString());
	 
	    map.get(4);
	    System.out.println("[1, 2, 3, 5, 4]"+","+ keys.toString());
	 
	    map.get(1);
	    System.out.println("[2, 3, 5, 4, 1]"+","+ keys.toString());
	 
	    map.get(3);
	    System.out.println("[2, 5, 4, 1, 3]"+","+ keys.toString());
	}
	static void givenHashMap_whenAccessOrderWorks_thenCorrect() {
	    HashMap<Integer, String> map = new HashMap<>();
	    map.put(1, null);
	    map.put(2, null);
	    //map.put(6, null);
	    map.put(3, null);
	    map.put(4, null);
	    map.put(5, null);

	    Set<Integer> keys = map.keySet();
	    System.out.println("[1, 2, 3, 4, 5]"+","+ keys.toString());
	 
	    map.get(4);
	    System.out.println("[1, 2, 3, 5, 4]"+","+ keys.toString());
	 
	    map.get(1);
	    System.out.println("[2, 3, 5, 4, 1]"+","+ keys.toString());
	 
	    map.get(3);
	    System.out.println("[2, 5, 4, 1, 3]"+","+ keys.toString());
	}
}

package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class tester {
	public static void main(String[] args) {
		HashMap<String, List> myMap= new HashMap<>();
		
		String GC = "11208^11209";
		
		String AS = "7130^7240";
		String limit ="1000000^5000";
		
		
		String[] gcList = GC.split("\\^");
		/*for(int i=0;i<gcList.length;i++) {
			System.out.println("gcList: "+gcList[i]);
			String [] asList = AS.split("\\^");
			String [] limitList = limit.split("\\^");
			myMap.put(gcList[i], asList);
			myMap.put(gcList[i], limitList);
		}*/
		
		String [] asList = AS.split("\\^");
		String [] limitList = limit.split("\\^");
		List<String> final1 = new ArrayList<>();
		List<String> final2 = new ArrayList<>();
		final1.add(asList[0]);
		final1.add(limitList[0]);
		
		final2.add(asList[1]);
		final2.add(limitList[1]);
		
		
		myMap.put(gcList[0], final1);
		myMap.put(gcList[1], final2);
		try {
		System.out.println("XXXXXXXXXXXXXXXXX : "+ myMap);
		System.out.println("XXXXXXXXXXXXXXXXX  11209: "+ myMap.get("112091").contains("7240"));
		System.out.println("XXXXXXXXXXXXXXXXX  11208: "+ myMap.get("11208"));
		
		System.out.println("XXXXXXXXXXXXXXXXX  11209 Stream: "+ myMap.get("11209").get(1)+" gcList: "+final1);
		}catch(NullPointerException e) {
			System.out.println("Null pointer");
		}
		 // create map to store
        Map<String, List<String>> map = new HashMap<String, List<String>>();

        // create list one and store values
        List<String> valSetOne = new ArrayList<String>();
        valSetOne.add("Apple");
        valSetOne.add("Aeroplane");

        // create list two and store values
        List<String> valSetTwo = new ArrayList<String>();
        valSetTwo.add("Bat");
        valSetTwo.add("Banana");

        // create list three and store values
        List<String> valSetThree = new ArrayList<String>();
        valSetThree.add("Cat");
        valSetThree.add("Car");

        // put values into map
        map.put("A", valSetOne);
        map.put("B", valSetTwo);
        map.put("C", valSetThree);

        // iterate and display values
        
        System.out.println("Fetching Keys and corresponding [Multiple] Values n");
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<String> values = entry.getValue();
            System.out.println("Key = " + key);
            System.out.println("Values = " + values.get(1) + "");
        }
	}
		
}

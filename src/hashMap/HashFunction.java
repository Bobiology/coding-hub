package hashMap;

import java.util.HashMap;
import java.util.Map;

public class HashFunction {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("123456-A", "Bob");
		
		String S = "orange";
		System.out.println(S.hashCode());
		
		System.out.println("HASH="+hash("123456-A"));
	}
	public static int hash(String key) {
		int hash = 0;
		for(char ch : key.toCharArray())
			hash += ch;
		return hash % 100;
	}

}

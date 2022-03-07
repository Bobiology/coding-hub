package hackerrank;

import java.util.HashMap;
import java.util.Map.Entry;

public class HappyLadyBugs {
	public static void main(String[] args) {
		String ladybugs = "";
		System.out.println("LadyBug=" + happyLadybugs(ladybugs));
	}

	public static String happyLadybugs(String b) {
		HashMap<String, Integer> happyMap = new HashMap<>();
		String isLadyBugHappy = "NO";
		System.out.println("EMPTY="+b);
		if (!b.contains("_")) {
			return isLadyBugHappy;
		} 
		char[] ch = b.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			String lady = ch[i] + "";
			if (happyMap.containsKey(lady))
				happyMap.put(ch[i] + "", (happyMap.get(lady) + 1));
			else
				happyMap.put(ch[i] + "", 1);
		}
		System.out.println(happyMap);
		isLadyBugHappy = "YES";
		for (Entry<String, Integer> lady : happyMap.entrySet()) {
			if (lady.getValue() <= 1 && !lady.getKey().equalsIgnoreCase("_"))
				isLadyBugHappy = "NO";
		}

		return isLadyBugHappy;
	}
}

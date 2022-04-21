package aws;

import java.util.HashMap;
import java.util.Map;

public class NumberGenerator {

	public static void main(String[] args) {
		String digits = "0123456789";
		String num = "210"; //output = 4
		digits = "8459761203";
		num = "5439";//output 17
		System.out.println(generateNum(digits, num));

	}
	
	public static int generateNum(String digits, String num) {
		int count = 0;
		int previousIndex = 0;
		int currentIndex = 0;
		Map<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < digits.toCharArray().length; i++) {
			map.put(digits.charAt(i), i);
		}
		
		for(char a: num.toCharArray()) {
			if(!map.isEmpty() && map.containsKey(a)) {
				currentIndex = map.get(a);
				count += Math.abs(currentIndex - previousIndex);
				previousIndex = currentIndex;
			}
		}
		
		return count;
	}

}

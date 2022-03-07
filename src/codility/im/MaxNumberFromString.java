package codility.im;

import java.util.HashMap;
import java.util.Map;

public class MaxNumberFromString {
	public static void main(String[] args) {
		Map<String,String>map = new HashMap<>();
		
		map.put("Currency", "USD");
		map.put("IdentityParam", "Currency");
		
		System.out.println("Map="+map);
		System.out.println("IdentityParam="+map.get("IdentityParam"));
		System.out.println("Currency="+map.getOrDefault(map.get("IdentityParam"), "BOB"));
		
		String str = "The price of 102 the book is $49YYYY98";

		System.out.println(maxValue(str));

	}
	static int maxValue(String S) {
		if(S == null || S.isEmpty()) {
			return 0;
		}
		String numberOnly = S.replaceAll("[^0-9]", "^");
		String[] num = numberOnly.split("\\^");
		int max = 0;
		for (int i = 0; i < num.length; i++) {
			if (num[i].length() > 0) {
				if (max < Integer.parseInt(num[i])) {
					max = Integer.parseInt(num[i]);
				}
			}
		}
		return max;
	}
}

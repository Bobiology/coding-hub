package algorithms;

import java.util.regex.Pattern;

public class RegexTest {

	public static void main(String[] args) {
		var regex = "[^a-zA-Z0-9]";
		
		var s = "12354R#6576";
		
		Pattern pattern = Pattern.compile(regex);
		
		var matcher = pattern.matcher(s);
		if(!matcher.find())
			System.out.println("MATCH");
		else
			System.out.println("NOT");
	}

}

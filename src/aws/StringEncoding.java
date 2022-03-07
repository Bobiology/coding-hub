package aws;

import java.util.Collections;

public class StringEncoding {

	public static void main(String[] args) {
		String s = "aaabbc";
		String S1 = "3a2b1c";

		System.out.println(encode(s));
		System.out.println(decode(S1));

	}
	static String encode(String S) {
		if(S==null || S.isEmpty()) return "";
		StringBuilder sb = new StringBuilder();
		int counter =0;
		char previousChar=0;
		
		for(int i=0; i<S.length();i++) {
			System.out.println("character="+S.charAt(i));
			if(previousChar==S.charAt(i)) {
				counter++;
			}else {
				if(previousChar !=0) {
					sb.append(counter).append(previousChar);
				}
				counter=1;
				previousChar=S.charAt(i);
			}
			
		}
		sb.append(counter).append(previousChar);
		return sb.toString();
	}
	
	static String decode(String S) {
		if(S==null || S.isEmpty()) return "";
		StringBuilder sb = new StringBuilder();
		int counter=0;
		char character=0;
		int n = S.length();
		int i=0;
	     while (n>0) {
			counter = Character.getNumericValue(S.charAt(i));
			character = S.charAt(i+1);
			
			System.out.println("Counter="+counter+" Character="+character);
			sb.append(String.join("", Collections.nCopies(counter, character+"")));
			i+=2;
			n-=2;
		}
		
		return sb.toString();
	}

}

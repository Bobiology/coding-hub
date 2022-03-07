package hackerrank;

import java.util.Arrays;
import java.util.List;

public class PasswordDecryption {
	public static void main(String[] args) {
		System.out.println(decryptionAlgorithm("43Ah*ck0rr0nk"));
	}
	/*
	 * 1. If s[i] is uppercase and s[i+1] is lowercase, swap them and remove '*' from s[i+2].
	 * 2. If s[i] is >0 move it to the last occurrence of 0.
	 * 
	 */
	static String decryptionAlgorithm(String password) {
		char[] array = password.toCharArray();
		StringBuilder out = new StringBuilder();
		String temp =password;
		int zeroPstn;
		System.out.println(Arrays.toString(array));
		for(int i=0;i<array.length;i++) {

			if(Character.isUpperCase(array[i]) && Character.isLowerCase(array[i+1])) {
				out.append(array[i+1]).append(array[i]);
				i+=2;
			}else if(Character.isDigit(array[i]) && array[i]>'0'){
				System.out.println("Digit: "+array[i]);
				//findZeroOccurrence(array[i],array);
			}else {
				out.append(array[i]);
			}
			if(array[i]=='0') {
				zeroPstn=i;
			}
			
		}
		
		return out.toString();
	}
	
	static char[] findZeroOccurrence(char ch, char[] s) {
		for(int i=s.length-1;i>0;i--) {
			if(s[i]=='0') {
				s[i]=ch;
			}
		}
		return s;
		
	}
}

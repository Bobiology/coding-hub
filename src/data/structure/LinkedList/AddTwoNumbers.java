package data.structure.LinkedList;

import java.util.LinkedList;

public class AddTwoNumbers {

	public static void main(String[] args) {
		java.util.LinkedList<Integer> num1 = new java.util.LinkedList<>();
		java.util.LinkedList<Integer> num2 = new java.util.LinkedList<>();

		num1.add(2);
		num1.add(4);
		num1.add(3);
		//num1.addFirst(5);
		//num1.addLast(7);
		//num1.add(3,8);
		//9999999+9999 = 10009998  -> 89990001
		
		num2.add(5);
		num2.add(6);
		num2.add(4);
		num2.add(3);
		
		System.out.println("sum: "+sumOfTwoNumbers(num1,num2));

	}
	static LinkedList<String> sumOfTwoNumbers(LinkedList<Integer> num1, LinkedList<Integer> num2) {
		
		String reverseStringHolder="";

		LinkedList<Integer> charHolder = new LinkedList<Integer>();
		LinkedList<String> mySum = new LinkedList<String>();
		charHolder.add(Integer.parseInt(reverseInput(num1, num1.size()-1, reverseStringHolder))+Integer.parseInt(reverseInput(num2, num2.size()-1, reverseStringHolder)));
		
		char[] charArr = charHolder.toString().toCharArray();
		int len = charArr.length-1;
		
		reverseSum(mySum, charArr, len);		
		return mySum;
		
	}
	private static void reverseSum(LinkedList<String> mySum, char[] charArr, int len) {
		for(int i=len;i>=0;i--) {
			if(charArr[i]!='[' && charArr[i] !=']') {
				mySum.add(charArr[i]+"");
			}
		}
	}
	private static String reverseInput(LinkedList<Integer> num1, int n, String reverseHolder) {
		for(int i=n;i>=0;i--) {
			reverseHolder=reverseHolder+""+num1.get(i);	
		}
		return reverseHolder;
	}

}

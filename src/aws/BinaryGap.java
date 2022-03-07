package aws;

public class BinaryGap {
	public static void main(String[] args) {
		int num=10;
		String binary = Integer.toBinaryString(num);
		System.out.println("Binary="+binary);
		System.out.println("max count="+maxBinaryGap(num));
	}
/**
 * 1010 => 1 ->
 * 
 *
 * 
 * 
 * @param num
 * @return
 */
	//BITWISE OPERATORS
	private static int maxBinaryGap(int num) {
		String binary = Integer.toBinaryString(num);
		
		int bit; //used for bitwise operation
		for(bit=1;bit>0;bit<<=1)//find lowest bit 1
			
			if((num&bit) !=0)
				break;
		
		int possibleGap = 0; //count the (possible) gap
		int longestGap = 0; //keep the longest gap
		for(;bit>0;bit<<=1) {
			if((num&bit) !=0) {// if it's bit 1
				longestGap = possibleGap<longestGap ? longestGap:possibleGap; //get the bigger one between possibleGap and longestGap
				possibleGap=-1;//Exclude this bit
			}
			possibleGap++; //Increment the count. If this bit is 1, then cnt would become 0 beause we set the cnt as -1 instead of 0.
	    
		}
		return longestGap;
		
	}

}

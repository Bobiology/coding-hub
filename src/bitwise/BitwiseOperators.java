package bitwise;

public class BitwiseOperators {

	public static void main(String[] args) {
		/*
		 * 0		1		2		3		4		5		6		7		8		9		10			11			12			13			14			15
		 * 0000		0001	0010	0011	0100	0101	0110	0111	1000	1001	1010		1011		1100		1101		1110		1111
		 * 
		 * 38 = 0110 + 0011 + 0010 = 1101
		 * 23 = 0101 + 0011 + 0001 = 1001
		 * 						   = 0100 {8}
		 */
		System.out.println(38 & 23);//bitwise AND
		System.out.println(38 | 23);//bitwise OR
		System.out.println(38 ^ 23);//bitwise XOR
		System.out.println(~32 );//bitwise NOT ==>  ~x == (-x) -1

	}

}

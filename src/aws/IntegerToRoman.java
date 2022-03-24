package aws;

public class IntegerToRoman {

	public static void main(String[] args) {
		IntegerToRoman ir = new IntegerToRoman();
		System.out.println(ir.intToRoman(123));
	}
	public String intToRoman(int num) {
		char[] symbols = new char[] { 'M', 'D', 'C', 'L', 'X', 'V', 'I' };
		int[] values  = new int[] { 1000, 500, 100, 50, 10, 5, 1 };
		// need to check             900, 400, 90,  40,  9, 4
		StringBuilder roman = new StringBuilder();
		for (int i = 0; i < symbols.length; i++) {
			int value = values[i];
			char symbol = symbols[i];
			while (num >= value) {
				roman.append(symbol);
				num -= value;
			}
			if (num == 0) {
				break;
			}
			// we return if we finished all I's;
			
			// so now we have num < 1000 or < 500 or < 100 or < 50 or < 10 or < 5:
			
			// 1. for i = 0, 2, 4, we check whether num >= value * 0.9
			//    if so, we need to append symbols[i + 2] + symbol[i];
			//  
			// 2. for i = 1, 3, 5, we check whether num >= value * 0.8
			//    if so, we need to append symbols[i + 1] + symbol[i];
			
			if (i % 2 == 0 && num >= value * 0.9) {
				roman.append(symbols[i + 2]);
				roman.append(symbol);
				num -= value - values[i + 2];
			} else if (i % 2 == 1 && num >= value * 0.8) {
				roman.append(symbols[i + 1]);
				roman.append(symbol);
				num -= value - values[i + 1];
			}
		}
		return roman.toString();
	}
	
}

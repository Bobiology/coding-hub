package aws;

public class IntegerToEnglish {
	String[] bigUnits = { "", " Thousand", " Million", " Billion" };
	String[] digits = { "", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine" };
	String[] tens = { "", "", " Twenty", " Thirty", " Forty", " Fifty", " Sixty", " Seventy", " Eighty", " Ninety" };
	String[] tenToTwenty = { " Ten", " Eleven", " Twelve", " Thirteen", " Fourteen", " Fifteen", " Sixteen",
			" Seventeen", " Eighteen", " Nineteen" };

	public static void main(String[] args) {
		IntegerToEnglish ie = new IntegerToEnglish();
		System.out.println(ie.numberToWords2(123));
	}

	public String numberToWords(int num) {
		if (num == 0) {
			return "Zero";
		}
		StringBuilder result = new StringBuilder();
		int bigUnitIndex = 0;
		while (num != 0) {
			if (num % 1000 != 0) {
				result.insert(0, parseThreeDigits(num % 1000) + bigUnits[bigUnitIndex] + "");
			}
			num /= 1000;
			bigUnitIndex++;
		}

		return result.toString().trim();
	}

	private String parseThreeDigits(int num) {
		StringBuilder result = new StringBuilder();
		if (num > 99) {
			result.append(digits[num / 100] + " Hundred");
			num = num % 100;
		}
		if (num > 19) {
			result.append(tens[num / 10]);
			num = num % 10;
		}
		if (num > 9) {
			result.append(tenToTwenty[num % 10]);
			return result.toString();
		}

		return result.append(digits[num]).toString();
	}
	
public String numberToWords2(int num) {
        
        StringBuilder sb = new StringBuilder();
        int rest = num;
        int bill = num / 1000000000;
        rest = rest - (bill * 1000000000);
        int mill = rest / 1000000;
        rest = rest - (mill * 1000000);
        int thous = rest / 1000;
        rest = rest - (thous * 1000);
        int hund = rest / 100;
        int tens = num % 100; 
        int ones = num % 10;
        
        if (bill > 0) {
            sb.append(numberToWords(bill)).append(" Billion ");
        }
        if(mill > 0) {
            sb.append(numberToWords(mill)).append(" Million ");
        }
        if(thous > 0) {
            sb.append(numberToWords(thous)).append(" Thousand ");
        }
        if(hund > 0) {
            sb.append(getNum(hund)).append(" Hundred ");
        }
        if(tens >= 20) {
            sb.append(getNum(tens - ones));
            if(ones > 0){
                sb.append(" ").append(getNum(ones));
            }
        }else{
            if(tens != 0 || sb.length() == 0){
                sb.append(getNum(tens));
            }
            
        }
    
        return sb.toString().trim();
    }
    
    private String getNum(int n){
        switch (n) {
          case 0  : return "Zero";
          case 1 : return "One";
          case 2 : return "Two";
          case 3 : return "Three";
          case 4 : return "Four";
          case 5 : return "Five";
          case 6 : return "Six";
          case 7 : return "Seven";
          case 8 : return "Eight";
          case 9 : return "Nine";
          case 10 : return "Ten";
          case 11 : return "Eleven";
          case 12 : return "Twelve";
          case 13 : return "Thirteen";
          case 14 : return "Fourteen";
          case 15 : return "Fifteen";
          case 16 : return "Sixteen";
          case 17 : return "Seventeen";
          case 18 : return "Eighteen";
          case 19 : return "Nineteen";
          case 20 : return "Twenty";
          case 30 : return "Thirty";
          case 40 : return "Forty";
          case 50 : return "Fifty";
          case 60 : return "Sixty";
          case 70 : return "Seventy";
          case 80 : return "Eighty";
          case 90 : return "Ninety";
          default : return "NULL";
        }
          
    }

}

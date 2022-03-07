package interview;

public class StringReplacer {
	public static void main(String[] args) {
		String a = "SakawaBOB";
		System.out.println(myString(a));
	}
static String myString(String a) {
	char originalChar ='a';
	char newch = 'b';
	
	String values = String.valueOf(newch);
	String valueOfchar = String.valueOf(originalChar);
	
	a.replace(originalChar+"", newch+"");
	
	return a.replace(valueOfchar, values);
}
}

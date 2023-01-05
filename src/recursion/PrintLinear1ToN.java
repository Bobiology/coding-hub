package recursion;

public class PrintLinear1ToN {

	public static void main(String[] args) {
		String s = "hello";
		StringBuilder builder = new StringBuilder("hello");
		StringBuilder builder2 = new StringBuilder("hello");
		
		//System.out.println(s == builder);
		System.out.println(builder2 == builder);
		System.out.println(s.equals(builder));
		System.out.println(builder.equals(builder2));
		
		final String s2 = "hel";
		String s3 = "lo";
		String s4 = "hello";
		
		//System.out.println(s == s4);
		//System.out.println(s == s2 + s3);
		//System.out.println(s == s2 + "lo");
		
		
		Long a1 = 111L;
		Long b1 = 111L;
		Long c1 = 333L;
		Long d1 = 333L;
		
		//System.out.println(a1 == b1);
		//System.out.println(c1 == d1);
		
		byte b = 1;
		action(b,b);

	}
	
	static void action(byte ... b) {}
	static void action(long l1, short s2) {}
	static void action(Byte b1, Byte b2) {}

	private void run() {
		System.out.println("My search engine:");
		//http//www.google.com
		return;
	}
}

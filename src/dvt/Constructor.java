package dvt;

public class Constructor {

	static String str;
	public void Construct() {
		System.out.println("In constructor");
		str ="Hellow world";
	}
	public static void main(String[] args) {
		Constructor c = new Constructor();
		System.out.println(str);
	}

}

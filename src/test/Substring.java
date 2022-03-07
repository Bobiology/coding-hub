package test;

public class Substring {

	public static void main(String[] args) {
	
		String path = "13345-Conditional Approval.com";
		String[] a = path.split("\\-");
		System.out.println("a[0]="+a[0]);
		System.out.println("a[1]="+path.split("\\-")[1]);
	}

}

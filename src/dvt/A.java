package dvt;

public class A {
public void printName() {
	System.out.println("Value -A");
  }
}
class B extends A{
	public void printName() {
		System.out.println("Value -B");
	}
}
class C extends A{
	public void printName() {
		System.out.println("Value -C");
	}
}
class Test{
	public static void main(String[] args) {
		B b = new B();
		C c = new C();
		//mismatch exception on the commented line
		//b =c;
		newPrint(b);
}
	public static void newPrint(A a) {
		a.printName();
	}
}
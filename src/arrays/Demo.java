package arrays;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Array numbers = new Array(3);
		numbers.insert(10);
		numbers.insert(20);
		numbers.insert(30);
		numbers.insert(40);
		numbers.insert(50);
		numbers.insert(60);
		numbers.insert(70);
		System.out.println("index="+numbers.indexOf(30));
		//numbers.removeAt(5);
		numbers.print();

	}

}

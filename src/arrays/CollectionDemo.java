package arrays;

import java.util.Hashtable;
import java.util.Vector;

public class CollectionDemo {

	public static void main(String[] args) {
		int arr[] = new int[] { 1, 2, 3, 4 };
		Vector<Integer> vector = new Vector<>();
		Hashtable<Integer, String> hash = new Hashtable();
		
		vector.add(1);
		vector.add(2);
		
		hash.put(1, "geeks");
		hash.put(2, "4geeks");
		
		System.out.println("a="+arr[0]);
		System.out.println("v="+vector.elementAt(0));
		System.out.println("h="+hash.get(1));

	}

}

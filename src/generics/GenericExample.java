package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericExample {

	public static void main(String[] args) {
		shout("John", 57);
		
		List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
		
		usingWildCat(list);
		
		System.out.println(2/0);
		
		
	}
	
	public static <T, V> void shout(T thingToShout, V otherThingsToShout) {
		
		System.out.println(thingToShout+"!!!!");
		System.out.println(otherThingsToShout+"!!!!");
	}
	
	static void usingWildCat(List<?> list) {
		System.out.println(list);
	}

}

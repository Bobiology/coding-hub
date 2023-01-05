package jumia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Subset {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3));
		var sublist = new Subset().getRandomSubset(list);
		
		list.stream().forEach(a ->{
			System.out.println("item="+a);
		});
		
		System.out.println(sublist);
		
		int n = 1;
		
		boolean resp = n == 1 ? true : false;
		
		System.out.println("response="+resp);
		
	}
	
	List<Integer> getRandomSubset(List<Integer> list){
		List<Integer> subset = new ArrayList<Integer>();
		Random random = new Random();
		
		for(int item : list) {
			if(random.nextBoolean()) {
				subset.add(item);
			}
		}
		System.out.println("subset="+subset);
		return subset;
	}

}

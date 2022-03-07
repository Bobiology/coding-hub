package musala;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FetchItemsToDisplay {

	public static void main(String[] args) {
		
		int sortParameter =0;
		int sortOrder =1;
		int X =2;
		List<String> item = new ArrayList<>();
		List<String> item2 = new ArrayList<>();
		List<String> item3 = new ArrayList<>();
		List<List<String>> items = new ArrayList<>();
		//item 1
		item.add("item1"); //name ->0
		item.add("10"); //relevance ->1
		item.add("15"); //price ->2
		items.add(item);
		//item 2
		item2.add("item2");
		item2.add("3");
		item2.add("4");
		items.add(item2);
		//item 3
		item3.add("item3");
		item3.add("17");
		item3.add("8");
		items.add(item3);
		
		System.out.println(fetchItemsToDisplay(items,sortParameter,sortOrder,X));
	}
	public static List<String> fetchItemsToDisplay(List<List<String>> items, int sortParameter, int sortOrder, int X){
		//String subList = "";
		//for(int i=0;i<items.size();i++) {
			items.forEach(item ->{
				System.out.println(item);
				
				if(sortParameter==0) {
					//sort by name
					item.get(0);
					if(sortOrder==0) {
						//ascending
						Collections.sort(item);
					}else if(sortOrder==1) {
						//descending
						Collections.sort(item);
						Collections.reverse(items);
					}
					
				}else if(sortParameter==1) {
					//sort by relevance
					item.get(1);
					if(sortOrder==0) {
						//ascending
					}else if(sortOrder==1) {
						//descending
					}
				}else if(sortParameter==2) {
					//sort by price
					item.get(3);
					if(sortOrder==0) {
						//ascending
					}else if(sortOrder==1) {
						//descending
					}
				}
				
				
				//subList = item.get(i);
			});
		//}
		
		return null;
		
	}

}

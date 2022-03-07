package arrays;

public class Array {
	private int[] items;
	private int count;
	public Array(int length) {
		items = new int[length];
	}
	public void print() {
		for(int i=0;i<count;i++) {
			System.out.println(items[i]);
		}
	}
	public int indexOf(int item) {
		int index=-1;
		for(int i=0;i<count;i++) {
			if(items[i]==item) {
				index=i;
			}
		}
		return index;
	}
	public void insert(int item) {
		if(items.length==count) {
			int[] newItems = new int[count*2];
			for(int i=0;i<count; i++) {
				newItems[i]=items[i];
			}
			items=newItems;
		}
		items[count++]=item;
	}
	public void removeAt(int index) {
		//validate index
		if(index<0 || index>=count) {
			throw new IllegalArgumentException();
		}
		//shift the items
		for(int i=index;i<count;i++) {
			items[i]=items[i+1];
		}
		count--;
		
	}

}

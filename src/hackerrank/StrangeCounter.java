package hackerrank;

public class StrangeCounter {

	public static void main(String[] args) {
		int t=17;
		System.out.println(strangeCounter(t));
	}

	public static long strangeCounter(long t) {
		int initialValue=3;
		int valueHolder=initialValue;
		int updateFlag=1;
		while(updateFlag>0 && initialValue>=1) {			
			if(initialValue==1 && updateFlag<=t) {
				initialValue=valueHolder*2;

			}
			
				initialValue--;
				updateFlag++;

		}
		System.out.println("time="+updateFlag+ " value="+initialValue);
		return initialValue;
		
	}

}

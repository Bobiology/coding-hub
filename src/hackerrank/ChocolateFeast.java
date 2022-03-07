package hackerrank;

public class ChocolateFeast {
	public static void main(String[] args) {
		System.out.println(chocolateFeast(15,3,2));
	}
	 public static int chocolateFeast(int n, int c, int m) {
		    int count = n/c;
		    int wrapper=count;
		    while(wrapper>=m){
		        int current = wrapper/m;
		        wrapper=(current + wrapper%m);
		        count +=current;
		    }
		    return count;
		    }
}

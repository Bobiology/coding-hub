package aws;

public class ForLoop {
	public static void main(String[] args) {
		factorial(9);//1*2*3*4=24
		
		starship(5);
		
	}
	static void forloop() {
		for(int i=0,j=51;i<50;i++,j++) {
			System.out.println(i);
			System.out.println(j);
		}
	}
	
	static void factorial(int N) {
		int factorial=1;
		for(int i=1;i<N+1;i++) {
			factorial*=i;
			System.out.println("i = "+i+" factorial = "+factorial);
		}
	}            
	
	static void starship(int N) {
		for(int i=0; i<N;i++) {
			for(int j=0;j<i;j++) {
				System.out.print(" * ");
			}
			System.out.println();
		}
	}

}

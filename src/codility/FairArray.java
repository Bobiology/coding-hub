package codility;

public class FairArray {
	/**
	 * 
	 * a1 = {0,4,-1,0,3}  k3 -> {0,4,-1} =3, {0,3} =3
	 * a2 = {0,-2,5,0,3}  k3 -> {0,-2,5} =3, {0,3} =3
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		int [] a1= {0,4,-1,0,3};
		int [] a2= {0,-2,5,0,3};
		int n = a1.length;
		
		solution(a1,a2,n);
		
	}
	private static int solution(int[] a1, int[] a2, int n) {
        int leftSum = 0, rightSum = 0;
        int leftSumb = 0, rightSumb = 0;
        int b, fairIndexCount = 0;
        for (int a=0; a<n; a++) {
            leftSum=0;
            leftSumb=0;
            for(b=0; b<a; b++) {
                leftSum += a1[b];
                leftSumb += a2[b];
                System.out.println("@ " + a + " b= " + b + " left sum =" + leftSumb);
            }
           
            rightSum=0;
            rightSumb=0;
            for(b=a; b<n; b++) {
                rightSum += a1[b];
                rightSumb += a2[b];
                System.out.println("@ " + a + " b= " + b + " right sum =" + rightSumb);
            }
       
            if (leftSum == rightSum && leftSumb == rightSumb) {
                System.out.println("found it! " + a);
                fairIndexCount++;
            }
           
            System.out.println("--------------------------------------------");
        }
        return fairIndexCount;
    }
	
}

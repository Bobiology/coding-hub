package interview;

import java.util.HashSet;
import java.util.Set;

public class StoreRoom {
	public static void main(String[] args) {
		int r=3;
		//int[] a= {2,1,2,3,2,2}; //2
		//r=2;
		///int[] a= {2,3,1,1,2}; //3
		r=3;
		int[] a= {20,10,10,10,30,20};//3
		//r=3;
		//int[] a= {1,100000,1};//0
		System.out.println(new StoreRoom().solution(a,r));
	}

	public int solution(int A[], int R) {
        int n= A.length;
        if(R == n){
            return 0;
        }
        int ans=0;
        int NoOfDiffItems= getDiffTypesOfItems(A);
        
        for(int i=0; i<=n-R; i++){
            Set<Integer> set= new HashSet<>();
            // we just traverse on window and count the types of shelves
            for(int j=i; j<i+R; j++){
                set.add(A[j]);
            }
            ans= Math.max(ans, NoOfDiffItems-set.size());
        }
        return ans;
    }
    public static int getDiffTypesOfItems(int[] A){
        Set<Integer> set= new HashSet<>();
        for(int a : A){
            set.add(a);
        }
        return set.size();
    }
    
	/*
	public int solution(int A[], int R) {
	    int n = A.length;
	    if ( R == n) {
	         return 0;
	    }
	   int ans = 0;
	   for (int i = 0; i < n - R + 1;  i++) {
	        HashSet<Integer> set = new HashSet<>();
	        for (int j = 0; j < n; j++) {
	            if (j >= i || j < i + R) {
	               continue;
	            } else {
	               set.add(A[j]);
	            }
	           ans = Math.max(ans, set.size());
	        }
	    }
	   return ans;
	}
	*/
}

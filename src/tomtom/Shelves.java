package tomtom;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Shelves {

	public static void main(String[] args) {
		int[] A = { 10, 20, 30, 50, 50, 10, 20, 20, 20, 40, 60, 10 };
		int R = 4;
		System.out.println(maxShelves(A, R));
	}

	private static int optimalShelves(int[] A, int R) {
		int max = 0;
		int l = A.length-1;
		Set<Integer> set = new HashSet<>();
		if (l <= R)
			return 0;
		for (int i = 0; i < l; i++) {
			for(int j=i+R;j<=l;j++) {
				set.add(A[j]);
				max = Math.max(max, set.size());
				System.out.println("i=" + i + " value=" + A[i]+" j="+j+" JJJJ="+A[j]+" max="+max+" set size="+set.size());
			}
			set.clear();
			
		}

		return max;
	}
	
	public static int maxShelves(int[] input , int R){

        HashMap<Integer,Integer> m = new HashMap<>();
        for(int i : input){
            m.put(i,m.getOrDefault(i,0) + 1);
        }
        System.out.println(m);

        int max = -1;
        int runningMax = m.size();
        for(int i = 0; i < R; i++){
            Integer p = input[i];
            m.put(p,m.get(p) - 1);
            if(m.get(p) == 0)
                runningMax--;

        }

        max = Math.max(max,runningMax);
        System.out.println(max);
      //  runningMax = max;

        for(int i = R; i < input.length; i++){
            //add first again
            Integer p = input[i-R];

            if(m.get(p) == 0)
                runningMax++;
            m.put(p,m.get(p) + 1);
            //remove current
            Integer q = input[i];
            m.put(q,m.get(q)-1);
            if(m.get(q) == 0)
                runningMax--;
            max = Math.max(max,runningMax);
            System.out.println(m);
          //  runningMax = max;


        }

        System.out.println(max);
        return max;
    }

}

package hackerrank;

import java.util.List;

public class BeautifuTriplets {
public static void main(String[] args) {
	
}
public static int beautifulTriplets(int d, List<Integer> arr) {
    int count=0;
    for (int i=0 ; i<arr.size();i++)
    {
        if(arr.contains(arr.get(i)+d) && arr.contains(arr.get(i) + 2*d))
            count++;
    }
    
    return count;
    }
}

package revision;

import java.util.ArrayList;
import java.util.List;

class MaximumGreatness
{  
     public static void main(String args[])
    {
        int max = 0;
        List<Integer> original = java.util.Arrays.asList(1, 3, 5, 2, 1, 3, 1);
        // List<Integer> original = java.util.Arrays.asList(4,1,6,3);
        List<List<Integer>> permutations = new ArrayList<>();
        permutingArray(permutations, original, 0);
        System.out.println("Size: " + permutations.size());
        
        for (int i = 0; i < permutations.size(); i++) {    
            List<Integer> current = permutations.get(i);
            int count = 0;
            for (int j = 0; j < current.size(); j++) {
                if (current.get(j) > original.get(j)) {
                   count += 1;
                } 
            }
            max = Math.max(count, max);
            //count = 0;
        }
        
        
        System.out.println("Maximum greatness: " + max);
    }
    
    
    
    public static void permutingArray(List<List<Integer>> permutations, java.util.List<Integer> arrayList, int element) {  
        permutations.add(new ArrayList<>(arrayList));
        for (int i = element; i < arrayList.size(); i++) {
            java.util.Collections.swap(arrayList, i, element);
            permutingArray(permutations, arrayList, element + 1);
            java.util.Collections.swap(arrayList, element, i);
        }
        if (element == arrayList.size() - 1) {
            
        }
        
    }
}
package meta;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ArrayIntersection {

	public static void main(String[] args) {
		int[] arr = {40,30,40,10,10,10,10,20,10};
        Map<Integer, Integer> map = new HashMap<>();
        map.put(10, map.getOrDefault(10, 0) + 1);
        map.put(10, map.getOrDefault(10, 0) + 1);
        map.put(10, map.getOrDefault(10, 0) + 1);
        map.put(10, map.getOrDefault(10, 0) + 1);
        map.put(20, map.getOrDefault(20, 0) + 1);
        map.put(10, map.getOrDefault(10, 0) + 1);
        map.put(30, map.getOrDefault(30, 0) + 1);
        map.put(40, map.getOrDefault(40, 0) + 1);
        map.put(40, map.getOrDefault(40, 0) + 1);
        
        for(Entry<Integer, Integer> entry : map.entrySet()) {
            int size = 0;
            if(entry.getKey()==10){
                for(int i = 0; i < entry.getValue(); i++){
                    arr[i] = entry.getKey();
                   size++; 
                }
            }
            else if(entry.getKey()==20){
                for(int i = size; i < entry.getValue(); i++){
                    arr[i] = entry.getKey();
                   size++; 
                }
            }
            
            else if(entry.getKey()==30){
                for(int i = size; i < entry.getValue(); i++){
                    arr[i] = entry.getKey();
                   size++; 
                }
            }
             if(entry.getKey()==40){
                 for(int i = size; i < entry.getValue(); i++){
                     arr[i] = entry.getKey();
                    size++; 
                 }
             }
            
        }
        
        System.out.println("Sorted="+Arrays.toString(arr));
        
	}
	public int[] intersect(int[] nums1, int[] nums2) {

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> finalSet = new HashSet<>();
        for(int num : nums1)
            set1.add(num);
        
        for(int num: nums2)
            set2.add(num);
        
        set1.retainAll(set2);
        
        Set<Integer> result = new HashSet<>(set1);
        
        int n = result.size();
        int[] nums = new int[n];
        int i = 0;
        
        for(int set : result) {
        	nums[i] = set;
        	i++;
        }
        
        
        return nums;
    }

}

package aws;

import java.util.HashMap;
import java.util.PriorityQueue;

public class ReOrganizeString {

	public static void main(String[] args) {
		ReOrganizeString s = new ReOrganizeString();
		s.reorganizeString("bbbaaaaab");

	}
	public String reorganizeString(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        // Defined Heap such that the root has more frequency than it's children  (a,b) -> map.get(b) - map.get(a)
        PriorityQueue<Character> maxHeap = new PriorityQueue<Character>((a, b) -> map.get(b) - map.get(a));
        
        StringBuilder sb = new StringBuilder();
        
        // get the character frequency
        for(char ch : s.toCharArray())
            map.put(ch, map.getOrDefault(ch,0) + 1);

        System.out.println("map"+ map);
        // add the character to the maxHeap
        for(Character ch : map.keySet())
            maxHeap.add(ch);
        
        System.out.println("max"+maxHeap);
        
        while(!maxHeap.isEmpty()){
            char ch = maxHeap.poll();
            sb.append(ch);
            int freq = map.get(ch);
            if(freq > 1){
                // if the freq is > 1 and the heap is empty, this means only same character with higher frequency is present and thus the string is not valid
                if(maxHeap.isEmpty())
                    return "";
                
                // Remove the next frequent element
                char ch2 = maxHeap.poll();
                
                // add it to sb
                sb.append(ch2);
                
                // After both the characters are added to sb, update their frequencies in the map and add it back to the heap
                map.put(ch, freq - 1);
                maxHeap.add(ch);
                
                // if the frequency of the 2nd removed character is not 1, then update the frequency in the map and add it back to the maxHeap;
                freq = map.get(ch2);
                if(freq != 1){
                    map.put(ch2, freq - 1);
                    maxHeap.add(ch2);
                }
            }
        }
        return sb.toString();
    }

}

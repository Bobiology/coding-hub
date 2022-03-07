package aws;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class GridKeyCollection3D {
	public static void main(String[] args) {
		String[] gridData = {"@.a.#","###.#","b.A.B"};
		GridKeyCollection3D grid = new GridKeyCollection3D();
		System.out.println(grid.shortestPathAllKeys(gridData));

	}
	    Map<Character,Integer> keys;
	    int[][] vector = {{0,1},{1,0},{0,-1},{-1,0}};//right, down, up, left
	    public int shortestPathAllKeys(String[] grid) {
	        
	        //map for holding key locks and their integer representation
	        keys = new HashMap<>();
	        
	        //assign numbers to keys from 0 to k-1
	        //also get the position of the @ so we can know where to start the BFS from
	        int key = 0;
	        int x=0,y=0;//starting point
	        for(int i=0; i<grid.length; i++){
	            for(int j=0; j<grid[i].length(); j++){
	                char c = grid[i].charAt(j);
	                if(Character.isUpperCase(c) && Character.isAlphabetic(c)){
	                    if(!keys.containsKey(c))
	                        keys.put(c,key++);
	                }
	                if(c == '@'){
	                    x = i;
	                    y = j;
	                }
	            }
	        }
	        //Run the 3D BFS and return the result
	        return bfs(x, y, grid);
	    }
	    private int bfs(int x, int y, String[] grid){
	        
	        int keyCombo = (int)Math.pow(2,keys.size());//all possible key selection states 
	        boolean[][][] visited = new boolean[grid.length][grid[x].length()][keyCombo];
	        Queue<int[]> pq = new LinkedList<>();
	        
	        //seed the queue with the initial/starting position.
	        //Notice that the no key has been selected, that why the third number is 0
	        pq.offer(new int[]{x,y,0});
	        int moves = 0, mask;
	        
	        while(!pq.isEmpty()){
	            
	            //get size of the current level, pop all and enqueue their children
	            //while checking if we've found all keys
	            int size = pq.size();
	            moves++;
	            for(int i=0; i<size; i++){
	                int[] entry = pq.poll();
	                
	                //check the four possible neighbor
	                for(int[] v: vector){
	                    x = entry[0]+v[0];
	                    y = entry[1]+v[1];
	                    mask = entry[2]; 
	                    
	                    //check invalid entry (entry with # or visited or out of bound)
	                    if(!isValid(x, y, grid) || visited[x][y][mask])
	                        continue;
	                    
	                    char c = grid[x].charAt(y);
	                    //check if it is a lock and the key isn't found yet, then we can't pass
	                    //but if it is a lock and the key is collected, we can pass
	                    //a key is collected if the bit at the position of the key is 1. keys positons
	                    //are stored in the global hashmap
	                    if(Character.isUpperCase(c) && !isBitSet(keys.get(c), mask))
	                        continue;
	                    
	                    //check if it is a key and has not been collected before. if yes,
	                    //then collect the key, and check if all keys have been collected
	                    //if all keys have been collected, then u can return the current moves                    
	                    if(Character.isLowerCase(c) && !isBitSet(keys.get(Character.toUpperCase(c)), mask)){
	                        mask = setBit(keys.get(Character.toUpperCase(c)), mask);
	                        if(mask == keyCombo-1)return moves;
	                    }
	                    
	                    //at this point, notice it is possible we are passing through the 
	                    //@ again or ., or a visited lock or collected key. if so,
	                    //no need to check again since they are all empty and free to pass
	                    visited[x][y][mask] = true;
	                    pq.offer(new int[]{x,y,mask});
	                }
	            }
	            
	        }
	        return -1;
	    }
	    //method for checking if the entry is out of bound or if it is containing a wall (i.e. #)
	    private boolean isValid(int x, int y, String[] grid){
	        if(x < 0 || x >= grid.length || y < 0 || y >= grid[x].length() || grid[x].charAt(y) == '#')
	            return false;
	        return true;
	    }
	    //method for checking if a bit is set a position
	    private boolean isBitSet(int position, int mask){
	        return ((1<<position) & mask ) != 0;
	    }
	    //method for setting a bit at a location
	    private int setBit(int position, int mask){
	        return (1 << position) | mask;
	    }

}

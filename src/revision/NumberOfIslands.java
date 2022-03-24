package revision;

import java.util.HashSet;
import java.util.Set;

public class NumberOfIslands {

	public static void main(String[] args) {
		char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
		NumberOfIslands islands = new NumberOfIslands();
		
		System.out.println(islands.numIslands(grid));
	}
    public int numIslands(char[][] grid) {
        //use dfs to traversal neighbours of 1
      int n = grid.length;
      int m = grid[0].length;
      int numberOfIslands = 0;
      Set<String> visited = new HashSet<>();
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.println("key="+visited);
                if(!visited.contains(i+"X"+j) && grid[i][j] == '1'){
                    dfs(i, j, grid, visited);
                    numberOfIslands += 1;
                }
                    
            }
        }
        return numberOfIslands;
    }
        private void dfs(int i, int j, char[][] grid, Set<String> visited){
            if(visited.contains(i+"X"+j))
                return;
            
            if(grid[i][j] == '0'){
                visited.add(i+"X"+j);
                return;
            }
            
            visited.add(i+"X"+j);
            //cell above
            if(i - 1 >= 0)
                dfs(i - 1, j, grid, visited);
            
             //cell below
            if(i + 1 < grid.length)
                dfs(i + 1, j, grid, visited);
            
             //cell to the left
            if(j - 1 >= 0)
                dfs(i, j - 1, grid, visited);
            
             //cell to the right 
            if(j + 1 < grid[i].length)
                dfs(i, j + 1, grid, visited);
            
            return;
        }

}

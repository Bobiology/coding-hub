package revision;

public class MaximumAreaOfIsland {

	public static void main(String[] args) {
		MaximumAreaOfIsland m = new MaximumAreaOfIsland();
		int[][] grid = {
				        {0,0,1,0,0,0,0,1,0,0,0,0,0},
						{0,0,0,0,0,0,0,1,1,1,0,0,0},
						{0,1,1,0,1,0,0,0,0,0,0,0,0},
						{0,1,0,0,1,1,0,0,1,0,1,0,0},
						{0,1,0,0,1,1,0,0,1,1,1,0,0},
						{0,0,0,0,0,0,0,0,0,0,1,0,0},
						{0,0,0,0,0,0,0,1,1,1,0,0,0},
						{0,0,0,0,0,0,0,1,1,0,0,0,0}
		
					   };
		int[][] grids = {
				{1,1,0,0,0},
				{1,1,0,0,0},
				{0,0,0,1,1},
				{0,0,0,1,1}
				};
		System.out.println(m.maxAreaOfIsland(grid));;
	}
	/*
	 * You are given an m x n binary matrix grid. An island is a group of 1's 
	 * (representing land) connected 4-directionally (horizontal or vertical.) 
	 * You may assume all four edges of the grid are surrounded by water.
	 * The area of an island is the number of cells with a value 1 in the island.
	 * Return the maximum area of an island in grid. If there is no island, return 0.
	 * 
	 * Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
	 * Output: 6
	 * Explanation: The answer is not 11, because the island must be connected 4-directionally.

	 */
	public int maxAreaOfIsland2(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
            	result = Math.max(markIsland2(grid, i, j), result);
            }
        }
		return result;
        
    }
	//not clear to me
	 private int markIsland2(int[][] grid, int i, int j) {
	        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 2) {
	            return 0;
	        }
	        if (grid[i][j] == 0) {
	            //grid[i][j] = -1;
	            return 0;
	        }
	        if (grid[i][j] == 1) {
	            grid[i][j] = 2;
	            return 1 + markIsland2(grid, i-1, j) + markIsland2(grid, i+1, j) + markIsland2(grid, i, j-1) + markIsland2(grid, i, j+1);
	        }
	        return 0;
	    }
	 
	public int maxAreaOfIsland(int[][] grid) {
		int rows = grid.length;
		int columns = grid[0].length;
		
		int maxArea = 0;
				
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {				
					maxArea = Math.max(maxArea, area(i, j, grid));
				}
			}
		
		return maxArea;
	}
	private int area(int row, int column, int[][] grid) {
		if(row < 0 || column < 0 || row >= grid.length || column >= grid[row].length || grid[row][column]==0)
			return 0;
		
		grid[row][column] = 0;
		return 1 + area(row - 1, column, grid) + area(row + 1, column, grid) + area(row, column - 1, grid) + area(row, column + 1, grid);
	}

}

package graph;

public class IslandPerimeter {
	static int area = 0;
	public static void main(String[] args) {
		int[][] b = {{1}};
		System.out.println(islandPerimeter(b));
	}
    static int islandPerimeter(int[][] grid) {
        for(int row=0;row<grid.length;row++) {
			for(int col=0;col<grid[row].length;col++) {
				if(grid[row][col] == 0) continue;
				search(grid, row, col);
			}
		}
        return area;
    }
    
    private static boolean search(int[][] matrix, int row, int col) {
		if(row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length) return false;
		if(matrix[row][col] == 0) return false;
        
        if( matrix[row][col] == -1){
            return true;
        } 
		
		matrix[row][col] = -1;
        area += 4;
        
        area = search(matrix, row-1, col) ? area-=1 : area; //UP
        area = search(matrix, row+1, col) ? area-=1 : area; //DOWN
        area = search(matrix, row, col-1) ? area-=1 : area; //LEFT
        area = search(matrix, row, col+1) ? area-=1 : area; //RIGHT    
		
		return true;
	}
}

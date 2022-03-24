package revision;

public class LargestSubMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	int area = 0;
    public int largestSubmatrix(int[][] matrix) {
        for(int row=0;row<matrix.length;row++){
            for(int col=0;col<matrix[row].length;col++){
                if(matrix[row][col] == 0) continue;
                adjustCol(matrix, row, col);
            }
        }
        return area;
    }
    
   boolean adjustCol(int[][] matrix, int row, int col){
       
       if(col <= 0 || col >= matrix[row].length - 1) return false;
       
        area = Math.max(area, countArea(matrix, row, col));
       
       //move left logic
       if(matrix[row][col-1] == 1) return false;
       
       matrix[row][col-1] = 1;  matrix[row][col] = 0;
       
       area = Math.max(area, countArea(matrix, row, col-1));
       
       adjustCol(matrix, row, col-1);
      /*
      //move right logic
       */
       
       return true;
    }

private int countArea(int[][] matrix, int row, int col) {
	 
	return 0;
}

}

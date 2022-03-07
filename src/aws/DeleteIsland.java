package aws;

import java.util.Arrays;

public class DeleteIsland {
/*
 * 
 * Input:
[[0, 0, 0, 1, 1, 1],
 [0, 0, 0, 1, 1, 1],
 [1, 1, 1, 1, 1, 1],
 [1, 1, 1, 1, 1, 1],
 [1, 1, 1, 1, 1, 1]]
 output: 
[[0, 0, 0, 1, 1, 1],
 [0, 0, 0, 1, 0, 1],
 [1, 1, 1, 1, 0, 1],
 [1, 0, 0, 0, 0, 1],
 [1, 1, 1, 1, 1, 1]]
 */
	public static void main(String[] args) {
		int[][] matrix = new int[5][6];
		matrix[0][0]=0;
		matrix[0][1]=0;
		matrix[0][2]=0;
		matrix[0][3]=1;
		matrix[0][4]=1;
		matrix[0][5]=1;
		
		matrix[1][0]=0;
		matrix[1][1]=0;
		matrix[1][2]=0;
		matrix[1][3]=1;
		matrix[1][4]=1;
		matrix[1][5]=1;
		
		matrix[2][0]=1;
		matrix[2][1]=1;
		matrix[2][2]=1;
		matrix[2][3]=1;
		matrix[2][4]=1;
		matrix[2][5]=1;

		matrix[3][0]=1;
		matrix[3][1]=1;
		matrix[3][2]=1;
		matrix[3][3]=1;
		matrix[3][4]=1;
		matrix[3][5]=1;
		
		matrix[4][0]=1;
		matrix[4][1]=1;
		matrix[4][2]=1;
		matrix[4][3]=1;
		matrix[4][4]=1;
		matrix[4][5]=1;
		
		deleteIslands(matrix);

	}
	public static void deleteIslands(int[][] matrix)
    {
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[0].length; j++)
            {
                if (matrix[i][j] == 1 && !CheckIfEdge(matrix, i, j))
                {
                    matrix[i][j] = 2;
                    System.out.println("==="+ matrix[i][j]);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0;j < matrix[0].length; j++)
            {
                if (matrix[i][j] == 2)
                {
                    matrix[i][j] = 0;
                    System.out.println("==>"+ matrix[i][j]);
                }
            }
        }
        
        System.out.println("==>"+ Arrays.deepToString(matrix));
    }

    public static boolean CheckIfEdge(int[][] matrix, int i, int j)
    {
        if (i <= 0 || i >= matrix.length - 1 || j <= 0 || j >= matrix[0].length - 1)
        {
            return true;
        }

        if (matrix[i-1][j] == 0 || matrix[i+1][j] == 0 || matrix[i][j - 1] == 0 || matrix[i][j + 1] == 0 || matrix[i - 1][j - 1] == 0 || matrix[i + 1][j + 1] == 0)
        {
            return true;
        }

        return false;
    }

}

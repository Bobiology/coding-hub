package aws;

public class CoinCollection2DMatrix {

	public static void main(String[] args) {
		int[][] coins = { { 0, 3, 1, 1 }, { 2, 0, 0, 4 }, { 1, 5, 3, 1 } };
		System.out.println(new CoinCollection2DMatrix().solve(coins));
	}

	public int solve(int[][] matrix) {
		if (matrix == null)
			return 0;

		int C = matrix[0].length;
		int R = matrix.length;

		int[][] dp = new int[R][C];

		// Base
		dp[0][0] = matrix[0][0];
		for (int c = 1; c < C; c++) {
			dp[0][c] = dp[0][c - 1] + matrix[0][c];
		}
		for (int r = 1; r < R; r++) {
			dp[r][0] = dp[r - 1][0] + matrix[r][0];
		}
		// Construction
		for (int r = 1; r < R; r++) {
			for (int c = 1; c < C; c++) {
				dp[r][c] = Math.max(dp[r - 1][c], dp[r][c - 1]) + matrix[r][c];
			}
		}

		return dp[R - 1][C - 1];

	}

}

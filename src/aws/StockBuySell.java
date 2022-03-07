package aws;

public class StockBuySell {

	public static void main(String[] args) {
		int[] stock = { 2, 3, 10, 6, 4, 8, 1 };
		System.out.println("BF - Profit=" + maximumProfit(stock));
		System.out.println("OP - Profit=" + maximumProfitOptimized(stock));
	}

	//Brute force O(n^2)
	private static int maximumProfit(int[] stock) {
		int maxProfit = -1;
		int n = stock.length;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (stock[j] - stock[i] > maxProfit) {
					maxProfit = stock[j] - stock[i];
				}
			}
		}
		
		return maxProfit;
	}
	//Optimised - O(n)
	private static int maximumProfitOptimized(int[] stock) {
		int maxProfit = -1;
		int n = stock.length;
		int maxRight=stock[n-1];
		for(int i=n-2;i>=0;i--) {
			if(stock[i]>maxRight) {
				maxRight=stock[i];
			}else {
				if(maxRight-stock[i]>maxProfit) {
					maxProfit = maxRight-stock[i];
				}
			}
		}

		return maxProfit;
	}

}

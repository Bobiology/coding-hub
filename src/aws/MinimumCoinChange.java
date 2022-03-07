package aws;

import java.util.Arrays;

public class MinimumCoinChange {

	public static void main(String[] args) {
		int[] coins = {1,3,5};
		int amount = 9;
		System.out.println(minChange(coins, amount));
	}

	private static int minChange(int[] coins, int amount) {
		int minimumCoin=0;
		int n = coins.length-1;
		Arrays.sort(coins);
		if(amount<=0)return minimumCoin;
		
		for(int i=n;i>=0;i--) {
			if(amount>=coins[i]) {
				minimumCoin++;
				amount=amount-coins[i];
			}
			System.out.println("coins="+coins[i]+" bal amount="+amount);

		}
		return minimumCoin;
	}

}

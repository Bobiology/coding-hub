package ezy.test;

import java.util.Arrays;

public class ChangeCalculator {
 public static void main(String[] args) {
	 System.out.println(Arrays.toString(new ChangeCalculator().getChange(3,0.01)));
}
 /**
  * 
  * 600    100
  * 6
  * @param amount
  * @param cost
  * @return
  */
 int[] getChange(double amount, double cost) {
	 int[]coins = {1,5,10,25,50,100};
	 int change = (int) ((Math.round((amount-cost)*100)));
	 
	 int[]resultedCoins= new int[6];
	 for(int i=coins.length-1; i>0; i--) {
		 
		 if(change/coins[i] >0) {
			 resultedCoins[i]=(int) (change/coins[i]);
			 change = change%coins[i];
			 
		 }
		 else if(change<=4) {
			 resultedCoins[0]=change;
		 }
		
	 }
	return resultedCoins;
	 
 }
}

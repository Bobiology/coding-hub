package revision;

public class CartridgeRecycler {

	public static void main(String[] args) {
		int cartridges = 737;//3;//4;//10;
		int dollars = 677;//6;//8;//10;
		int recycleReward = 893;//4;//3;//2;
		int perksCost = 87;//5;//4;//2;
		
		System.out.println(maxPerksItems(cartridges, dollars, recycleReward, perksCost));
		
	}
	public static double maxPerksItems(int cartridges, int dollars, int recycleReward, int perksCost) {
		/*
		int numbeOfPerks = 0;
		while(numbeOfPerks < cartridges) {
			cartridges--;
			
			numbeOfPerks = dollars / perksCost;
			dollars += recycleReward;
			System.out.println("numbeOfPerks= "+numbeOfPerks+" dollars="+dollars+" recycleReward="+recycleReward+" cartridges="+cartridges);
			
		}
		return numbeOfPerks;
		*/
		return (dollars + cartridges * recycleReward) / (perksCost + recycleReward);
	}

}

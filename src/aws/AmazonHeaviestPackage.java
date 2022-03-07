package aws;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AmazonHeaviestPackage {

	public static void main(String[] args) {
		List<Integer> packages = new ArrayList<>(Arrays.asList(2,9,10,3,7));
		System.out.println(getHeaviestPackage(packages));
	}
	static long getHeaviestPackage(List<Integer> packageWeight) {
		packageWeight.sort(Comparator.naturalOrder());
		int[] dp = new int[packageWeight.size()];
		dp[0] = packageWeight.get(0);
		long max = packageWeight.get(0);
		for (int i = 1; i < packageWeight.size(); i++) {
			if (packageWeight.get(i) > packageWeight.get(i-1)) {
				int s = Math.max(packageWeight.get(i) + dp[i - 1], packageWeight.get(i));
				dp[i] = s;
				max = Math.max(max, s);
			} else {
				dp[i] = packageWeight.get(i);
			}
		}
		return max;
	}

}

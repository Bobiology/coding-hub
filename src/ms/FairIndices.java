package ms;

//Fair Indices:
public class FairIndices {

//2
//static int[] a1 = {0, 4, -1, 0, 3};
//static int[] a2 = {0, -2, 5, 0, 3};

//1
//static int[] a1 = {2, -2, -3, 3};
//static int[] a2 = {0, 0, 4, -4};

//0
//static int[] a1 = {4, -1, 0, 3};
//static int[] a2 = {-2, 6, 0, 4};

//0
//static int[] a1 = {3, 2, 6};
//static int[] a2 = {4, 1, 6};

//2
//static int[] a1 = {1, 4,2,-2,5};
//static int[] a2 = {7, -2,-2,2,5};

//1
	static int[] a1 = { 2, -2, -3, 3 };
	static int[] a2 = { 0, 0, 4, -4 };

//where leftsum has at least 2 elements summed
	private static int totalFairIndices(int[] a1, int[] a2) {

		int fairIndices = 0;
		int leftSumA = 0;
		int leftSumB = 0;
		int rightSumA = 0;
		int rightSumB = 0;
		int len = a1.length;
		int initK = 1;

//do initial sum for lefts
		for (int i = 0; i < initK; i++) {
			leftSumA += a1[i];
			leftSumB += a2[i];
		}

//do initial sum for rights
		for (int i = initK; i < len; i++) {
			rightSumA += a1[i];
			rightSumB += a2[i];
		}

		if (leftSumA == leftSumB && rightSumA == rightSumB && leftSumA == rightSumA) {
			fairIndices++;

			System.out.println("1. k = " + initK);
			System.out.println("leftSumA=" + leftSumA + ", leftSumB=" + leftSumB);
			System.out.println("rightSumA=" + rightSumA + ", rightSumB=" + rightSumB);
			System.out.println();
		}

		for (int k = initK + 1; k < len; k++) {
			leftSumA += a1[k - 1];
			leftSumB += a2[k - 1];

			rightSumA -= a1[k - 1];
			rightSumB -= a2[k - 1];

			if (leftSumA == leftSumB && rightSumA == rightSumB && leftSumA == rightSumA) {
				fairIndices++;
				System.out.println("k = " + k);
				System.out.println("leftSumA=" + leftSumA + ", leftSumB=" + leftSumB);
				System.out.println("rightSumA=" + rightSumA + ", rightSumB=" + rightSumB);
				System.out.println();
			}
		}
		return fairIndices;
	}

	public static void main(String[] args) {
		int t = totalFairIndices(a1, a2);
		System.out.println("fairIndices = " + t);
	}
}


public class Solution {
    /*
     * @param A: An integer array
     * @param target: An integer
     * @return: An integer
     */
    public int MinAdjustmentCost(List<Integer> A, int target) {
		int n = A.size();
		// f[i][j] = change A[i-1] to j (0 ~ 100), the min adjustment for A[0, ..., i-1], ensuring the adjasent diff is <= Target
		int[][] f = new int[n + 1][100 + 1];
		
		// init
		for (int i = 0; i <= 100; i++) {
			f[1][i] = Math.abs(A.get(0) - i);
		}

		for (int i = 2; i <= n; i++) {
			// change A[i - 1] to B[i - 1] = j
			for (int j = 1; j <= 100; j++) {
				f[i][j] = Integer.MAX_VALUE;
				for (int k = j - target; k <= j + target; k++) {
					if (k < 1 || k > 100) {
						continue;
					}
					f[i][j] = Math.min(f[i][j], f[i - 1][k] + Math.abs(A[i - 1] - j));
				}
			}
		}
		int res = Integer.MAX_VALUE;
		for (int i = 1; i <= 100; i++) {
			res = Math.min(res, f[n][i]);
		}

		return res;
	}
}

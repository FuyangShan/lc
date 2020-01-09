# Minimum Adjustment Cost

-   Given an integer array

### Q: adjust each integers so that the difference of every adjacent integers are not greater than a given number target.

-   If the array before adjustment is A, the array after adjustment is B, you should minimize the sum of |A[i]-B[i]|

> Example
> Example 1:
> Input: [1,4,2,3], target=1
> Output: 2

> Example 2:
> Input: [3,5,4,7], target=2
> Output: 1

```java
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
		for (int j = 1; j <= 100; j++) {
			f[1][j] = Math.abs(A.get(0) - j);
		}

		for (int i = 2; i <= n; i++) {
			// change A[i - 1] to j (1 ~ 100)
			for (int j = 1; j <= 100; j++) {
				f[i][j] = Integer.MAX_VALUE;
				// enumerate the cost for [0, ..., i-2]
				for (int k = j - target; k <= j + target; k++) {
					if (k < 1 || k > 100) {
						continue;
					}
					// f[i][j] = Min {f[i-1][k] + Abs(A[i-1]-j)}
					f[i][j] = Math.min(f[i][j], f[i - 1][k] + Math.abs(A.get(i - 1) - j));
				}
			}
		}
		int res = Integer.MAX_VALUE;
		// find the minimum among f[n][1 ~ 100]
		for (int j = 1; j <= 100; j++) {
			res = Math.min(res, f[n][j]);
		}

		return res;
    }
}

```

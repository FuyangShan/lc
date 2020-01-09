# K Sum

- Given n distinct positive integers, integer K (k <= n) and a number target
### Q: Find k numbers where sum is target. Calculate how many solutions there are?

> Example 1

> Input:
> List = [1,2,3,4]
> k = 2
> target = 5
> Output: 2
> Explanation: 1 + 4 = 2 + 3 = 5

> Example 2

> Input:
> List = [1,2,3,4,5]
> k = 3
> target = 6
> Output: 1
> Explanation: There is only one method. 1 + 2 + 3 = 6

```java
public class Solution {
	public int kSum(int A[], int K, int target) {
		int n = A.length;
		// f[i][k][s] = num of methods to select "k" elements to sum up to "s" with A[0,...,i-1]
		int[][][] f = new int[n + 1][K + 1][target + 1];

		// dp
		for (int i = 0; i <= n; i++) {
			for (int k = 0; k <= K; k++) {
				for (int s = 0; s <= target; s++) {
					// init
					if (i == 0 && k == 0 && s == 0) {
						f[i][k][s] = 1;
						continue;
					} else if (i == 0) {
						f[i][k][s] = 0;
						continue;
					}

					// A[i - 1] not selected
					f[i][k][s] = f[i - 1][k][s];

					// A[i - 1] selected
					if (k >= 1 && s >= A[i - 1]) {
						f[i][k][s] += f[i - 1][k - 1][s - A[i - 1]];
					}
				}
			}
		}

		return f[n][K][target];
	}
}

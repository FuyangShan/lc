# Paint Fence
- There is a fence with n posts, each post can be painted with one of the k colors.

- You have to paint all the posts such that no more than two adjacent fence posts have the same color.

- Return the total number of ways you can paint the fence.

- Note:
- n and k are non-negative integers.

> Example:

> Input: n = 3, k = 2
> Output: 6
> Explanation: Take c1 as color 1, c2 as color 2. All possible ways are:

>           post1  post2  post3 
> ----      -----  -----  -----
>  1         c1     c1     c2
>  2         c1     c2     c1
>  3         c1     c2     c2
>  4         c2     c1     c1
>  5         c2     c1     c2
>  6         c2     c2     c1

```java
class Solution {
    public int numWays(int n, int k) {
		// f[i][j] = ways to paint first i posts with color j-1
		int[][] f = new int[n + 1][k];

		for (int j = 0; j < k; j++) {
			f[0][j] = 0;
			if (n > 0) f[1][j] = 1;
			if (n > 1) f[2][j] = k;
		}

		for (int i = 3; i <= n; i++) {
			for (int j = 0; j < k; j++) {
				f[i][j] = 0;
				for (int c = 0; c < k; c++) {
					if (c == j) continue;
					// ways of last post painted j-1
					// +
					// ways of last 2 posts painted j-1
					f[i][j] += f[i - 1][c] + f[i - 2][c];
				}
			}
		}
		int res = 0;
		for (int j = 0; j < k; j++) {
			res += f[n][j];
		}
		return res;
    }
}

```

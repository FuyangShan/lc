# Ones and Zeroes
- In the computer world, use restricted resource you have to generate maximum benefit is what we always want to pursue.

- For now, suppose you are a dominator of m 0s and n 1s respectively. On the other hand, there is an array with strings consisting of only 0s and 1s.

### Q: Now your task is to find the maximum number of strings that you can form with given m 0s and n 1s. Each 0 and 1 can be used at most once.

- Note:

- The given numbers of 0s and 1s will both not exceed 100
- The size of given string array won't exceed 600.

> Example 1:

> Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
> Output: 4
> Explanation: This are totally 4 strings can be formed by the using of 5 0s and 3 1s, which are “10,”0001”,”1”,”0”

> Example 2:

> Input: Array = {"10", "0", "1"}, m = 1, n = 1
> Output: 2

> Explanation: You could form "10", but then you'd have nothing left. Better form "0" and "1".

```java
class Solution {
	    public int findMaxForm(String[] strs, int m, int n) {
			int T = strs.length;
			int[] cnt0 = new int[T];
			int[] cnt0 = new int[T];

			for (int i = 0; i < T; i++) {
				cnt0[i] = cnt1[i] = 0;
				chars[] s = strs[i].toCharArray();
				for (int j = 0; j < s.length; j++) {
					if (s[j] == '0') {
						cnt0[i]++;
					} else {
						cnt1[i]++;
					}
				}
			}
			
			int[][][] f = new int[T + 1][m + 1][n + 1];

			// init
			for (int j = 0; j <= m; j++) {
				for (int k = 0; k <= n; k++) {
					f[0][j][k] = 0;
				}
			}
			for (int i = 0; i <= T; i++) {
				for (int j = 0; j <= m; j++) {
					for (int k = 0; k <= n; k++) {
						// strs[i - 1] not selected
						f[i][j][k] = f[i - 1][j][k];
						
						// strs[i - 1] selected
						if (j >= cnt0[i - 1] && k >= cnt1[i - 1]) {
							f[i][j][k] = Math.max(f[i][j][k], f[i - 1][j - cnt0[i - 1]][k - cnt1[i - 1]] + 1);
						}
					}
				}
			}

			return f[T][m][n];
		}
}
```

```java
class Solution {
	public int longestCommonSubsequence(String text1, String text2) {
		int m = text1.length();
		int n = text2.length();
		int[][] f = new int[m+ 1][n + 1];
		
		for (int i = 0; i <=m; i++) {
			for (int j = 0; j <= n; j++) {
				// init
				if (i == 0 || j == 0) {
					f[i][j] = 0;
					continue;
				}
				// normal transition function
				f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
				if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
					f[i][j] = Math.max(f[i][j] = f[i - 1][j - 1] + 1);
				}
		}
		return f[m][n];	
	}
}
```

# Interleaving String
- Given s1, s2, s3
### Q: Find whether s3 is formed by the interleaving of s1 and s2.

> Example 1:

> Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
> Output: true
> Example 2:

> Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
> Output: false


```java
// DP
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
	int m = s1.length();
	int n = s2.length();

	if (s3.length() != m + n) return false;
		
	// f[i][j] = is S3[0,..., i+j-1] can be interleaved with S1[0,...,i-1] and S2[0,...,j-1] 	
	boolean[][] f = new boolean[m + 1][n + 1];

	for (int i = 0; i <= m; i++) {
		for (int j = 0; j <= n; j++) {
			// init
			if (i == 0 && j == 0) {
				f[i][j] = true;
				continue;
			}
			// i == 0 || j == 0 --> f[i][j] = false
			f[i][j] = false;
			// f[i][j] = {f[i-1][j] | s3[i+j-1]=s1[i-1] OR f[i][j-1] | s3[i+j-1]=s2[j-1]}
			if (i > 0 && s3.charAt(i + j - 1) == s1.charAt(i - 1)) {
				f[i][j] |= f[i - 1][j];
			}
			if (j > 0 && s3.charAt(i + j - 1) == s2.charAt(j - 1)) {
				f[i][j] |= f[i][j - 1];
			}
		}
	}
        return f[m][n];
    }
}
```

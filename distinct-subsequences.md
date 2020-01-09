# 115. Distinct Subsequences

- Given a string S and a string T, count the number of distinct subsequences of S which equals T.

- A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters.

> ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not

> Example 1:

> Input: S = "rabbbit", T = "rabbit"
> Output: 3
> Explanation:

> As shown below, there are 3 ways you can generate "rabbit" from S.
> (The caret symbol ^ means the chosen letters)

> rabbbit
> ^^^^ ^^
> rabbbit
> ^^ ^^^^
> rabbbit
> ^^^ ^^^

```java
// DP
class Solution {
    public int numDistinct(String S, String T) {
	int m = S.length();
	int n = T.length();
        // f[i][j] = number of distinct T[0,...,j-1] in S[0,...i-1]
        int[][] f = new int[m + 1][n + 1];

        for(int i = 0; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
		// init
	    	if (j == 0) { // T is empty
			f[i][j] = 1;
			continue;
		} else if (i == 0) { // S is empty
			f[i][j] = 0;
			continue;
		}

		// f[i][j] = {f[i-1][j] + f[i-1][j-1] | S[i-1]=T[j-1]}
		f[i][j] = f[i-1][j];
		if (S.charAt(i-1) == T.charAt(j-1)) {
			f[i][j] += f[i - 1][j - 1];
		}
            }
        }
        return f[m][n];
    }
}
```

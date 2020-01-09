# Edit Distance

- Given two words word1 and word2
### Q: find the minimum number of operations required to convert word1 to word2.

- You have the following 3 operations permitted on a word:

- Insert a character
- Delete a character
- Replace a character

> Example 1:

> Input: word1 = "horse", word2 = "ros"
> Output: 3
> Explanation: 
> horse -> rorse (replace 'h' with 'r')
> rorse -> rose (remove 'r')
> rose -> ros (remove 'e')

> Example 2:

> Input: word1 = "intention", word2 = "execution"
> Output: 5
> Explanation: 
> intention -> inention (remove 't')
> inention -> enention (replace 'i' with 'e')
> enention -> exention (replace 'n' with 'x')
> exention -> exection (replace 'n' with 'c')
> exection -> execution (insert 'u')


```java

// DP
class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) return 0;
        int m = word1.length(), n = word2.length();
        if (m * n == 0) return m + n;
	// f[i][j] = minDistance from word1[0,...,i-1] to word2[0,...,j-1]
        int[][] f = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++){
            f[i][0] = i;
        }
        for (int j = 1; j <= n; j++){
            f[0][j] = j;
        }
        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){

	    	// f[i][j] = Min{f[i-1][j]+1, f[i][j-1]+1, f[i-1][j-1]+1, f[i-1][j-1] | word1[i-1]=word2[j-1]}

	    	// case1: Delete- word1[i-1]
		// case2: Add- word2[j-1]
            	f[i][j] = Math.min(f[i - 1][j] + 1, f[i][j - 1] + 1);
		// case3: Replace- word1[i-1] with word2[j-1]
		f[i][j] = Math.min(f[i][j] + f[i - 1][j - 1] + 1);
		// case4: Same- do nothing, continue...
		if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
			f[i][j] = Math.min(f[i][j], f[i - 1][j - 1]);
		}
	    }
        }
        return f[m][n];
    }
}
```

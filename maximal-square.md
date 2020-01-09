# Maximal Square
- Given a 2D binary matrix filled with 0's and 1's 
### Q: find the largest square containing only 1's and return its area.

>Example:

>Input: 

>1 0 1 0 0
>1 0 1 1 1
>1 1 1 1 1
>1 0 0 1 0

>Output: 4

```java

class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int m = matrix.length;
		int n = matrix[0].length;
        // f[i][j] = length of largest 1's square within matrix[(0,0), ..., (i-1, j-1)]
        int[][] f = new int[m][n];
        int max = 0;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {

				// matrix[i][j] = 0
				if (matrix[i][j] == '0') {
					f[i][j] = 0;
					continue;
				}

                // matrix[i][j] = 1
				// init
				if (i == 0 || j == 0) {
					f[i][j] = 1;
					max = Math.max(max, 1);
					continue;
				}

				// f[i][j] = Min{f[i-1][j], f[i][j-1], f[i-1][j-1]} + 1
				f[i][j] = Math.min(Math.min(f[i - 1][j], f[i][j - 1]), f[i - 1][j - 1]) + 1;
				max = Math.max(max, f[i][j]);
            }
        }
        return max * max;
    }
}
```

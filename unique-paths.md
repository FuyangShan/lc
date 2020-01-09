# Unique Paths
- A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
- The robot can only move either down or right at any point in time. 
- The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

### Q : How many possible unique paths are there?

```java
// DP
class Solution {
    public int uniquePaths(int m, int n) {
        // f[i][j] = total unique paths from (0,0) to (i,j)
        int[][] f = new int[m][n];
        // init
        f[0][0] = 1;
        
        for(int i = 0; i < m; i++) { 
            for (int j = 0; j < n; j++) { 
                if (i == 0 || j == 0) {
                    // init, only 1 way to reach top row and left column
                    f[i][j] = 1; 
                } else {
                    // f[i][j] = {f[i-1][j] + f[i][j-1]}
                    f[i][j] = f[i - 1][j] + f[i][j - 1];
                }
            }  
        } 
        // total unique paths from (0,0) to (m-1, n-1)
        return f[m - 1][n - 1];
    }
}
```
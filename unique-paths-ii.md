# Unique Paths II
- A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

- The robot can only move either down or right at any point in time. 
- The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

### Q: Now consider if some obstacles are added to the grids. How many unique paths would there be?

```java
// DP
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        // f[i][j] = total unique paths from (0,0) to (m-1, n-1)
        int[][] f = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) 
                    // corner condition
                    f[i][j] = 0;
                else {
                    if (i == 0 && j == 0) 
                        // init
                        f[i][j] = 1;
                    else {
                        // init
                        f[i][j] = 0;
                        // f[i][j] = Max{f[i-1][j] + f[i][j-1]}
                        if (i > 0)
                            f[i][j] += f[i - 1][j];
                        if (j > 0)
                            f[i][j] += f[i][j - 1];
                    }
                }
            }
        }
        return f[m - 1][n - 1];
    }
}
```
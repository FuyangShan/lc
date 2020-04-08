# Max of Min Altitude
Given a matrix with r rows and c columns, find the maximum score of a path starting at [0, 0] and ending at [r-1, c-1]. The score of a path is the minimum value in that path. For example, the score of the path 8 → 4 → 5 → 9 is 4.

Don't include the first or final entry. You can only move either down or right at any point in time.

Example 1:

Input:
[[5, 1],
 [4, 5]]

Output: 4
Explanation:
Possible paths:
5 → 1 → 5 => min value is 1
5 → 4 → 5 => min value is 4
Return the max value among minimum values => max(4, 1) = 4.
Example 2:

Input:
[[1, 2, 3]
 [4, 5, 1]]

Output: 4
Explanation:
Possible paths:
1-> 2 -> 3 -> 1
1-> 2 -> 5 -> 1
1-> 4 -> 5 -> 1
So min of all the paths = [2, 2, 4]. Note that we don't include the first and final entry.
Return the max of that, so 4.

```java
/*

1 2 3
4 5 1

*/

class Solution {
    public int maxMinAltitude(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] dp = new int[m][n]; // store the maxMinAltitude ending at grid[i][j]

        dp[0][0] = Integer.MIN_VALUE; // starting point being the MIN to avoid when considering MAX min

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                // looking at left, MIN(grid[left], dp[left])
                if (i == 0 && j > 0) dp[i][j] = Math.min(dp[i][j - 1], grid[i][j - 1]);
                else if (i > 0 && j == 0) dp[i][j] = Math.min(dp[i - 1][j], grid[i - 1][j]);
                else {
                    int left = Math.min(dp[i][j - 1], grid[i][j - 1]);
                    int top = Math.min(dp[i - 1][j], grid[i - 1][j]);
                    dp[i][j] = Math.max(left, top);
                }
            }
        }

        return dp[m - 1][n - 1];
    }

}

```
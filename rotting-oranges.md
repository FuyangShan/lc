# Rotting Oranges

In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.

 

Example 1:



Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: [[0,2]]
Output: 0
Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
 

Note:

1 <= grid.length <= 10
1 <= grid[0].length <= 10
grid[i][j] is only 0, 1, or 2.

```java
class Solution {
    public int orangesRotting(int[][] grid) {
        int elapsed = 0;
        // save the total number of orange in cells
        int target = 0;
        int[][] dirs = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int m = grid.length, n = grid[0].length;
        // use queue to store coordinates of rotten oranges in the current time
        Queue<int[]> q = new LinkedList<>();
        
        /* BFS: add fresh neighbors of each rotten orange every minute into q, 
        if the q.size() == target, return the elapsed
        if there is no new rotten orange added in Queue
        */
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) target++;
                if (grid[i][j] == 2) q.add(new int[]{i, j});
            }
        }
        if (target == 0) return elapsed;
        while (!q.isEmpty()) {
            if (target == 0) return elapsed;
            int size = q.size();
            while (size > 0) { 
                int[] cur = q.poll();
                if (cur != null) {
                    for (int[] dir : dirs) {
                        int nX = cur[0] + dir[0];
                        int nY = cur[1] + dir[1];
                        if (nX >= 0 && nX < m && nY >= 0 && nY < n && grid[nX][nY] == 1) {
                            q.add(new int[] {nX, nY});
                            target--;
                            grid[nX][nY] = 2;
                        }
                    }
                }
                size--;
            }
            elapsed++;
        }
        return -1;
    }
}
```



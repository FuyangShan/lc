```java
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] grid = new int[n][n];
        int[][] dirs = new int[][] {{0,1}, {1,0}, {0,-1}, {-1,0}};
        boolean[] visited = new boolean[n * n];
        int i = 0, j = 0; // start from top left cell
        int index = 1;
        int dir = 0;
        while (index <= n * n) {
            
            grid[i][j] = index;
            index++;
            visited[i * n + j] = true;
            int next_i = i + dirs[dir%4][0];
            int next_j = j + dirs[dir%4][1];
            
            if (next_i >= n || next_i < 0 || next_j >= n || next_j < 0 || visited[next_i * n + next_j]) {
                dir++;  
            } 
            i += dirs[dir%4][0];
            j += dirs[dir%4][1];
        }
        
        return grid;
    }
}
```
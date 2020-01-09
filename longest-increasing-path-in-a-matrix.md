```java
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n]; // store if visited
        int[][] dp = new int[m][n]; // store longest increasing path
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int len = DFS(matrix, i, j, visited, Integer.MIN_VALUE, dp);
                max = Math.max(max, len);
            }
        }
        return max;
    }
    public int DFS(int[][] matrix, int i, int j, boolean[][] visited, int prev, int[][] dp) {
        int len = 0;
        // if curr out of boundary or visited
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || visited[i][j]) {
            return len;
        }
        // if curr is no greater than prev
        if (matrix[i][j] <= prev) return len;
        // if dp stored [i][j]
        if (dp[i][j] != 0) return len + dp[i][j];
        
        visited[i][j] = true;
        len = Math.max(len, DFS(matrix, i + 1, j, visited, matrix[i][j], dp) + 1);
        len = Math.max(len, DFS(matrix, i - 1, j, visited, matrix[i][j], dp) + 1);
        len = Math.max(len, DFS(matrix, i, j + 1, visited, matrix[i][j], dp) + 1);
        len = Math.max(len, DFS(matrix, i, j - 1, visited, matrix[i][j], dp) + 1);
        visited[i][j] = false;
        
        dp[i][j] = len;
        return len;
    }
}
```
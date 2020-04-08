```java
// S1 : DFS
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (matrix[i][j] == 1) matrix[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (matrix[i][j] == 0) dfs(matrix, i, j, 0);
            }
        }
        return matrix;
    }
    public void dfs(int[][] matrix, int i, int j, int distance){
        if (i < 0 || j < 0|| i >= matrix.length|| j >= matrix[0].length|| matrix[i][j] < distance) return;
        matrix[i][j] = distance;
        dfs(matrix, i + 1, j, distance + 1);
        dfs(matrix, i - 1, j, distance + 1);
        dfs(matrix, i, j + 1, distance + 1);
        dfs(matrix, i, j - 1, distance + 1);
    }
}

// S2: BFS
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return matrix;
        int n = matrix[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (matrix[i][j] == 0) {
                    q.add(new int[]{i,j});
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            } 
        }
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        while (!q.isEmpty()){
            int[] point = q.poll();
            int row = point[0];
            int col = point[1];
            for (int[] direction : directions){
                int r = row + direction[0];
                int c = col + direction[1];
                if (r < 0|| c < 0|| r >= m|| c >= n || matrix[r][c] <= matrix[row][col] + 1) continue;
                matrix[r][c] = matrix[row][col] + 1;
                q.add(new int[]{r,c});
            }
        }
        return matrix;
    }
}
```
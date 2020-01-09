```java
//DFS
class Solution {
    int m,n;
    public int numIslands(char[][] grid) {
        int count = 0;
        m = grid.length;
        if (m == 0)return 0;
        n = grid[0].length;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid, int i, int j){
        if (i < 0 || j < 0|| i >= m|| j >= n|| grid[i][j] != '1')return;
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}

//BFS
class Pair {
    int x, y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    BFS(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }
    private void BFS(char[][] grid, int x, int y) {
        //dir
        int[] dirX = {0, 1, 0, -1};
        int[] dirY = {1, 0, -1, 0};
        
        //initiate
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(x,y));
        grid[x][y] = '0';
        
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            for (int i = 0; i < 4; i++) {
                Pair adj = new Pair(curr.x + dirX[i], curr.y + dirY[i]);
                if (!isValid(grid, adj)) continue;
                grid[adj.x][adj.y] = '0';
                q.offer(adj);
            }
        }
    }
    private boolean isValid(char[][] grid, Pair node) {
        int x = node.x, y = node.y;
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0') return false;
        else return true;
    }
}
```
```java
//BFS
class Pair {
    int x, y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public int numDistinctIslands(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        Set<HashSet<Integer>> res = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    BFS(grid, i, j, res);
                }
            }
        }
        return res.size();
    }
    private void BFS(int[][] grid, int x, int y, Set<HashSet<Integer>> res) {
        HashSet<Integer> shape = new HashSet<>();
        
        //dir
        int[] dirX = {0, 1, 0, -1};
        int[] dirY = {1, 0, -1, 0};
        
        //initiate
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(x,y));
        grid[x][y] = 0;
        
        shape.add(0);
        
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            for (int i = 0; i < 4; i++) {
                Pair adj = new Pair(curr.x + dirX[i], curr.y + dirY[i]);
                if (!isValid(grid, adj)) continue;
                grid[adj.x][adj.y] = 0;
                q.offer(adj);
                shape.add((adj.x - x) * 2 * grid[0].length + (adj.y - y));
            }
        }
        if (!shape.isEmpty())
            res.add(shape);
    }
    private boolean isValid(int[][] grid, Pair node) {
        int x = node.x, y = node.y;
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0) return false;
        else return true;
    }
    
}
```

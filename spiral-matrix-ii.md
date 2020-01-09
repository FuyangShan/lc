```java
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        if (n == 0) return res;
        boolean[] visited = new boolean[n * n];
        int[][] dirs = {
            {0, 1}, // right
            {1, 0}, // down
            {0, -1}, // left
            {-1, 0} // top
        };
        int step = 1;
        int x = 0, y = 0;
        int dir = 0;

        while (step <= n * n){
            res[x][y] = step;
            step++;
            visited[x * n + y] = true;
            int newX = x + dirs[dir % 4][0];
            int newY = y + dirs[dir % 4][1];
            if (newX < 0 || newY < 0 || newX >= n || newY >= n || visited[newX * n + newY]){
                dir++;
                x += dirs[dir % 4][0];
                y += dirs[dir % 4][1];
                continue;
            }
            x += dirs[dir % 4][0];
            y += dirs[dir % 4][1];
        }
        return res;
    }
}
```
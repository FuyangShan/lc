```java
//DFS
class Solution {
    public void wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++){
            for (int j = 0; j < rooms[0].length; j++){
                if (rooms[i][j] == 0) dfs(rooms, i, j, 0);
            }
        }
    }
    public void dfs(int[][] rooms, int i, int j, int distance){
        if (i < 0|| j < 0|| i >= rooms.length|| j >= rooms[0].length|| rooms[i][j] < distance) return;
        rooms[i][j] = distance;
        dfs(rooms, i + 1, j, distance + 1);
        dfs(rooms, i - 1, j, distance + 1);
        dfs(rooms, i, j + 1, distance + 1);
        dfs(rooms, i, j - 1, distance + 1);
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
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) return;
        
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    distance(rooms, i, j);
                }
            }
        }
    }
    private void distance(int[][] rooms, int x, int y) {
        int[] dirX = {0, 1, 0, -1};
        int[] dirY = {1, 0, -1, 0};
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y));
        
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            for (int i = 0; i < 4; i++) {
                Pair adj = new Pair(curr.x + dirX[i], curr.y + dirY[i]);
                if (adj.x < 0 || adj.x >= rooms.length || adj.y < 0 || adj.y >= rooms[0].length || rooms[adj.x][adj.y] <= rooms[curr.x][curr.y] + 1) continue;
                rooms[adj.x][adj.y] = rooms[curr.x][curr.y] + 1;
                q.add(adj);
            }
        }
    }
}
```
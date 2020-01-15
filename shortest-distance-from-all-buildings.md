class Pair {
    int x, y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;
        
        int[][] reach = new int[grid.length][grid[0].length]; //how many buildings is the land accessible to
        int[][] dist = new int[grid.length][grid[0].length]; //how far is the land away from all the buildings
        int buildingNum = 0; //how many buildings existing
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    buildingNum++;
                    boolean[][] seen = new boolean[grid.length][grid[0].length];
                    distance(grid, seen, reach, dist, i, j);
                }
            }
        }
        int shortest = Integer.MAX_VALUE;
        //get the shortest distance among all empty land that is accessible to all buildings
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0 && reach[i][j] == buildingNum) {
                    shortest = Math.min(shortest, dist[i][j]);
                }
            }
        }
        return shortest == Integer.MAX_VALUE ? -1 : shortest;
    }
    private void distance(int[][] grid, boolean[][] seen, int[][] reach, int[][] dist, int x, int y) {
        int[] dirX = {0, 1, 0, -1};
        int[] dirY = {1, 0, -1, 0};
        int level = 1;
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y));
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair curr = q.poll();
                for (int j = 0; j < 4; j++) {
                    Pair adj = new Pair(curr.x + dirX[j], curr.y + dirY[j]);
                    if (adj.x >= 0 && adj.x < grid.length && adj.y >= 0 && adj.y < grid[0].length && !seen[adj.x][adj.y] && grid[adj.x][adj.y] == 0) {
                        seen[adj.x][adj.y] = true;
                        dist[adj.x][adj.y] += level;
                        reach[adj.x][adj.y]++;
                        q.add(adj);
                    } 
                }
            }  
            level++;
        } 
    }
}


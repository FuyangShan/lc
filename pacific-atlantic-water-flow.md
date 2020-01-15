//DFS
class Solution {
    boolean paAccess,alAccess;
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                paAccess = false;
                alAccess = false;
                boolean[][] visited = new boolean[matrix.length][matrix[0].length];
                dfs(matrix,i,j,matrix[i][j],visited);
                if (paAccess && alAccess) {
                    List<Integer> water = new ArrayList<>();
                    water.add(i);
                    water.add(j);
                    res.add(water);
                }
            }
        }
        return res;
    }
    public void dfs(int[][]matrix, int i, int j,int root,boolean[][] visited){
        if (i < 0|| j < 0) {
            paAccess = true;
        } else if (i >= matrix.length || j >= matrix[0].length){
            alAccess = true;
        } else if (matrix[i][j] > root) {
            return;
        } else if (visited[i][j]){
            return;
        } else {
            visited[i][j] = true;
            root = matrix[i][j];
            dfs(matrix, i + 1, j, root, visited);
            dfs(matrix, i - 1, j, root, visited);
            dfs(matrix, i, j + 1, root, visited);
            dfs(matrix, i, j - 1, root, visited);
        }
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
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;
        int m = matrix.length, n = matrix[0].length;
        //construct a queue for each ocean
        Queue<Pair> pq = new LinkedList<>();
        Queue<Pair> aq = new LinkedList<>();
        //make boolean matrix for each ocean
        boolean[][] pSeen = new boolean[m][n];
        boolean[][] aSeen = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            pq.add(new Pair(i, 0));
            aq.add(new Pair(i, n - 1));
            pSeen[i][0] = true;
            aSeen[i][n - 1] = true;
        }
        for (int i = 0; i < n; i++) {
            pq.add(new Pair(0, i));
            aq.add(new Pair(m - 1, i));
            pSeen[0][i] = true;
            aSeen[m - 1][i] = true;
        }
        bfs(matrix, pq, pSeen);
        bfs(matrix, aq, aSeen);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pSeen[i][j] && aSeen[i][j]) {
                    List<Integer> index = new ArrayList<>();
                    index.add(i);
                    index.add(j);
                    res.add(index);
                }
            }
        }
        return res;
    }
    private void bfs(int[][] matrix, Queue<Pair> q, boolean[][] visited) {
        int[] dirX = {0, 1, 0, -1};
        int[] dirY = {1, 0, -1, 0};
        
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            for (int i = 0; i < 4; i++) {
                Pair adj = new Pair(curr.x + dirX[i], curr.y + dirY[i]);
                if (adj.x >= 0 && adj.x < matrix.length && adj.y >= 0 && adj.y < matrix[0].length && !visited[adj.x][adj.y] && matrix[adj.x][adj.y] >= matrix[curr.x][curr.y]) {
                    visited[adj.x][adj.y] = true;
                    q.add(adj);
                }
            }
        }
    }
}
```java
// DFS
class Solution {
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (i == 0|| i == m - 1|| j == 0|| j == n - 1){
                    if (board[i][j] == 'O') dfs(board, i, j);
                }
            }
        }
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (board[i][j] == '*') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }
    public void dfs(char[][] board, int i, int j){
        if (i < 0|| i >= board.length || j < 0|| j >=board[0].length) return;
        if (board[i][j] == 'X'||board[i][j] == '*') return;
        board[i][j] = '*';
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }
}

// BFS
class Pair {
    int x, y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        List<Pair> border = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O' && (i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1)) {
                    flip(board, i , j); //flip 'O' at border to '*'
                }
            }
        }
        //flip all 'O' to 'X', and flip '*' back to 'O'
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '*') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }
    private void flip(char[][] board, int x, int y) {
        int[] dirX = {1, 0, -1, 0};
        int[] dirY = {0, 1, 0, -1};

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y));
        board[x][y] = '*';
        
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            for (int i = 0; i < 4; i++) {
                Pair adj = new Pair(curr.x + dirX[i], curr.y + dirY[i]);
                if (adj.x < 0 || adj.x >= board.length || adj.y < 0 || adj.y >= board[0].length || board[adj.x][adj.y] != 'O') continue; //skip all 'X' and '*'
                q.offer(adj);
                board[adj.x][adj.y] = '*';
            } 
        }
    }
}
```
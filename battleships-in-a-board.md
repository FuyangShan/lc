```java
// DFS
class Solution {
    int m,n;
    public int countBattleships(char[][] board) {
        int count = 0;
        m = board.length;
        if (m == 0) return 0;
        n = board[0].length;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (board[i][j] == 'X'){
                    dfs(board, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(char[][] board, int i, int j){
        if (i < 0|| j < 0|| i >= m || j >=n || board[i][j] != 'X') return;
        board[i][j] = '.';
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j + 1);
    }
}
```
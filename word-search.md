```java
// board =
// [
//   ['A','B','C','E'],
//   ['S','F','C','S'],
//   ['A','D','E','E']
// ]

// Given word = "ABCCED", return true.
// Given word = "SEE", return true.
// Given word = "ABCB", return false.


class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) return false;
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (dfs(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word, int i, int j, int index){
        if (index == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || word.charAt(index) != board[i][j]) return false;
        board[i][j] ^= 256;
        boolean exist = dfs(board, word, i, j+1, index + 1)
            || dfs(board, word, i, j-1, index + 1)
            || dfs(board, word, i+1, j, index + 1)
            || dfs(board, word, i-1, j, index + 1);
        board[i][j] ^= 256;
        return exist;
    }
}
```